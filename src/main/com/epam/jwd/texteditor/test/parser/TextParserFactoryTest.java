package main.com.epam.jwd.texteditor.test.parser;

import main.com.epam.jwd.texteditor.parser.*;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TextParserFactoryTest {
    private final TextParserFactory parserFactory = TextParserFactory.getInstance();

    @Test
    public void getInstance_shouldReturnInstanceOfClass_always() {
        assertNotNull(TextParserFactory.getInstance());
        assertSame(TextParserFactory.getInstance(), TextParserFactory.getInstance());
    }

    private void assertNotNull(TextParserFactory instance) {
    }

    @Test
    public void of_shouldReturnChainOfParsers_always() {
        TextParser textParser = ParagraphParser.getInstance();
        textParser.linkWith(SentenceParser.getInstance())
                .linkWith(WordParser.getInstance());

        assertNotNull(parserFactory.of());
        assertEquals(parserFactory.of(), textParser);
    }

    private void assertEquals(TextParser of, TextParser textParser) {
    }
}
