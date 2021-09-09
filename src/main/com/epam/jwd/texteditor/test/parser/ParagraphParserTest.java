package main.com.epam.jwd.texteditor.test.parser;

import main.com.epam.jwd.texteditor.model.TextPart;
import main.com.epam.jwd.texteditor.parser.ParagraphParser;
import main.com.epam.jwd.texteditor.parser.SentenceParser;
import main.com.epam.jwd.texteditor.parser.WordParser;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ParagraphParserTest {
    private final ParagraphParser parser = ParagraphParser.getInstance();

    @Test
    public void getInstance_shouldReturnInstanceOfClass_always() {
        assertNotNull(ParagraphParser.getInstance());
        assertSame(ParagraphParser.getInstance(), ParagraphParser.getInstance());
    }

    private void assertNotNull(ParagraphParser instance) {
    }

    @Test
    public void parse_shouldReturnListOfParagraphs_always() {
        parser.linkWith(SentenceParser.getInstance())
                .linkWith(WordParser.getInstance());
        String text = "It is a (^5|1&2<<(2|5>>2&71))|1200 established " +
                "fact that a reader will be of a page when\n" +
                "looking at its layout...";

        assertNotNull(parser.parse(text));
        assertSame(parser.parse(text).size(), 1);
        assertSame(parser.parse(text).get(0).getType(), TextPart.PARAGRAPH);
    }

}
