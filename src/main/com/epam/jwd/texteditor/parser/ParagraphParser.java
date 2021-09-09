package main.com.epam.jwd.texteditor.parser;


import main.com.epam.jwd.texteditor.model.Component;
import main.com.epam.jwd.texteditor.model.Composite;
import main.com.epam.jwd.texteditor.model.TextPart;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ParagraphParser extends TextParser {

    private static final Logger LOG = LogManager.getLogger(ParagraphParser.class);

    private static final String TABULATION_REGEX = "[ ]{4}";
    private static final String PARAGRAPH_REGEX = "\n[ ]{4}";
    private static final String PARAGRAPH_PARSER_IS_WORKING_MSG = String.format("%s is working", ParagraphParser.class);

    private static ParagraphParser instance;

    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
        if (instance == null) {
            instance = new ParagraphParser();
        }
        return instance;
    }

    @Override
    public List<Component> parse(String text) {
        LOG.trace(PARAGRAPH_PARSER_IS_WORKING_MSG);

        String[] paragraphs = text.split(PARAGRAPH_REGEX);
        List<Component> paragraphList = new ArrayList<>();


        paragraphs[0] = paragraphs[0].replaceAll(TABULATION_REGEX, "");

        for (String paragraph : paragraphs) {
            paragraphList.add(
                    new Composite(parseNext(paragraph), TextPart.PARAGRAPH)); // add paragraphs into text entity
        }
        return paragraphList;
    }
}