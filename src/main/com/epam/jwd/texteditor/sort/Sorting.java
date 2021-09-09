package main.com.epam.jwd.texteditor.sort;

import main.com.epam.jwd.texteditor.model.Component;
import main.com.epam.jwd.texteditor.model.Composite;
import main.com.epam.jwd.texteditor.model.TextPart;
import main.com.epam.jwd.texteditor.parser.TextPartExtractor;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Sorting implements SortService {

    private static Sorting instance;

    private Sorting() {
    }

    public static Sorting getInstance() {
        if (instance == null) {
            instance = new Sorting();
        }
        return instance;
    }

    @Override
    public Composite sortText(Composite text, Comparator<Component> comparator) {
        List<Component> sentences =
                TextPartExtractor.extractParts(text, TextPart.SENTENCE);

        sentences = sentences.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return new Composite(sentences, TextPart.TEXT);
    }

    @Override
    public java.awt.Composite sortText(java.awt.Composite text, Comparator<TextComponent> comparator) {
        return null;
    }
}
