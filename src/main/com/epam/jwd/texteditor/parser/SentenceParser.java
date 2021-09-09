package main.com.epam.jwd.texteditor.parser;

import main.com.epam.jwd.texteditor.model.Symbol;
import main.com.epam.jwd.texteditor.model.TextPart;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends TextParser {

    private static final Logger LOG = LogManager.getLogger(String.valueOf(SentenceParser.class));

    private static final String SENTENCE_REGEX = "[.?!]+\\s?";
    private static final String SENTENCE_ENDING_REGEX = "[.?!]+";
    private static final String SENTENCE_PARSER_IS_WORKING_MSG =
            String.format("%s is working", SentenceParser.class);

    private static SentenceParser instance;

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        if (instance == null) {
            instance = new SentenceParser();
        }
        return instance;
    }

    @Override
    public List<Component> parse(String text) {
        LOG.trace(SENTENCE_PARSER_IS_WORKING_MSG);

        List<String> endingsOfSentences = getSentencesEndings(text);

        return makeSentencesWithEndings(text, endingsOfSentences);
    }

    private List<TextComponent> makeSentencesWithEndings(String text, List<String> endingsOfSentences) {
        String[] sentences = text.split(SENTENCE_REGEX);
        List<TextComponent> textComponents = new ArrayList<>();

        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].equals("\n")) {
                continue;
            }
            textComponents.add(new Composite(parseNext(sentences[i]),
                    TextPart.SENTENCE));
            textComponents.add(new Symbol(endingsOfSentences.get(i)));
        }
        return textComponents;
    }

    private List<String> getSentencesEndings(String text) {
        Matcher matcher = Pattern.compile(SENTENCE_ENDING_REGEX).matcher(text);
        List<String> endingsOfSentences = new ArrayList<>();


        while (matcher.find()) {
            endingsOfSentences.add(matcher.group());
        }
        return endingsOfSentences;
    }
}
