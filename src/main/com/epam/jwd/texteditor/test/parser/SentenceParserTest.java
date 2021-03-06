package main.com.epam.jwd.texteditor.test.parser;

import main.com.epam.jwd.texteditor.model.TextPart;
import main.com.epam.jwd.texteditor.parser.SentenceParser;
import main.com.epam.jwd.texteditor.parser.WordParser;
import org.junit.Test;

import java.awt.*;

public class SentenceParserTest {
    private final SentenceParser parser = SentenceParser.getInstance();

    @Test
    public void getInstance_shouldReturnInstanceOfClass_always() {
        assertNotNull(SentenceParser.getInstance());
        assertSame(SentenceParser.getInstance(), SentenceParser.getInstance());
    }

    private void assertNotNull(SentenceParser instance) {
    }

    @Test
    public void parse_shouldReturnListOfSentences_always() {
        parser.linkWith(WordParser.getInstance());
        String text = "It is a (^5|1&2<<(2|5>>2&71))|1200 established " +
                "fact that a reader will be of a page when\n" +
                "looking at its layout... Bye.";

        assertNotNull(parser.parse(text));
        assertSame(parser.parse(text).size(), 2);
        assertSame(parser.parse(text).get(0).getType(), TextPart.SENTENCE);
        assertSame(parser.parse(text).get(1).getType(), TextPart.SENTENCE);
    }

    private void assertSame(Dimension size, int i) {
    }
}
