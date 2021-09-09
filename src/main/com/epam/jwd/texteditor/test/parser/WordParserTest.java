package main.com.epam.jwd.texteditor.test.parser;

import main.com.epam.jwd.texteditor.model.TextPart;
import main.com.epam.jwd.texteditor.parser.WordParser;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class WordParserTest {
    private final WordParser parser = WordParser.getInstance();

    @Test
    public void getInstance_shouldReturnInstanceOfClass_always() {
        assertNotNull(WordParser.getInstance());
        assertSame(WordParser.getInstance(), WordParser.getInstance());
    }

    private void assertNotNull(WordParser instance) {
    }

    @Test
    public void parse_shouldReturnListOfWords_always() {
        String text = "It is a (^5|1&2<<(2|5>>2&71))|1200 established " +
                "fact that a reader will be of a page when\n" +
                "looking at its layout...";

        assertNotNull(parser.parse(text));
        assertSame(parser.parse(text).size(), 19);
        assertSame(parser.parse(text).get(0).getType(), TextPart.WORD);
    }
}
