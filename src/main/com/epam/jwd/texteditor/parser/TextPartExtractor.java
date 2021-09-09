package main.com.epam.jwd.texteditor.parser;

import main.com.epam.jwd.texteditor.model.TextPart;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TextPartExtractor {
    public static List<Component> extractParts(Composite text, TextPart type) {
        List<Component> result = new ArrayList<>();

        extract(result, text.clone(), type);

        if (type == TextPart.SENTENCE) {
            result = linkSentencesWithSymbols(result);
        } else {
            result = result.stream().filter(part -> part.getLexemeLength() != 0).collect(Collectors.toList());
        }

        return result;
    }

    private static void extract(List<Component> result, Component text, TextPart type) {
        if (text.getType() == type) {
            result.add(text);
        } else if (text.getType() == TextPart.SENTENCE
                || text.getType() == TextPart.PARAGRAPH
                || text.getType() == TextPart.TEXT) {
            for (Component part : ((Composite) text).getParts()) {
                extract(result, part, type);
            }
        } else if (text.getType() == TextPart.SYMBOL
                && ("!".equals(text.toString())
                || "?".equals(text.toString())
                || ".".equals(text.toString())
                || "...".equals(text.toString()))) {
            result.add(text);
        }
    }


    private static List<Component> linkSentencesWithSymbols(List<Component> parts) {
        List<Component> sentences = new ArrayList<>();
        for (int i = 0; i < parts.size() - 1; i += 2) {
            Component p = parts.get(i);
            ((TextComposite) p).addPart(parts.get(i + 1));
            sentences.add(p);
        }
        return sentences;
    }
}
