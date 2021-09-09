package main.com.epam.jwd.texteditor.sort;

import main.com.epam.jwd.texteditor.model.Component;
import main.com.epam.jwd.texteditor.model.Composite;
import main.com.epam.jwd.texteditor.model.TextPart;
import main.com.epam.jwd.texteditor.parser.TextPartExtractor;

import java.awt.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortingByParagraphs implements SortService {

    private static SortingByParagraphs instance;

    private SortTextByParagraphs() {
    }

    public static SortingByParagraphs getInstance() {
        if (instance == null) {
            instance = new SortingByParagraphs();
        }
        return instance;
    }

    @Override
    public Composite sortText(Composite text, Comparator<Component> comparator) {
        List<Component> paragraphs = TextPartExtractor.extractParts(text, TextPart.PARAGRAPH);
        paragraphs = paragraphs.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return new Composite(paragraphs, TextPart.TEXT);
    }
}
