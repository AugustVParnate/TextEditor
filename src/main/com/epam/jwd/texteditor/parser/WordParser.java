package main.com.epam.jwd.texteditor.parser;

import main.com.epam.jwd.texteditor.model.Component;
import main.com.epam.jwd.texteditor.model.Symbol;
import main.com.epam.jwd.texteditor.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends TextParser {

    private static final Logger LOG = LogManager.getLogger(WordParser.class);

    private static final String WORD_REGEX = "\\s";
    private static final String WORD_IS_WORKING_MSG = String.format("%s is working", WordParser.class);
    private static final String WORD_WITH_SYMBOLS_REGEX = ".+([,:]?)";

    private static WordParser instance;

    private WordParser() {
    }

    public static WordParser getInstance() {
        if (instance == null) {
            instance = new WordParser();
        }
        return instance;
    }

    @Override
    public List<Component> parse(String text) {
        LOG.trace(WORD_IS_WORKING_MSG);

        String[] words = text.split(WORD_REGEX);
        List<Component> wordList = new ArrayList<>();

        for (String word : words) {
            wordList.add(new Word(word));
            wordList.add(new Symbol(getSymbolAfterWord(word)));
        }
        return wordList;
    }

    private String getSymbolAfterWord(String word) {
        Matcher matcher = Pattern.compile(WORD_WITH_SYMBOLS_REGEX).matcher(word);

        if (matcher.find()) {
            return matcher.group(1); // extract symbol
        }
        return "";
    }
}
