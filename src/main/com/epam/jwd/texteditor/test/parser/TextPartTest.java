package main.com.epam.jwd.texteditor.test.parser;

import main.com.epam.jwd.texteditor.model.Symbol;
import main.com.epam.jwd.texteditor.model.TextPart;
import main.com.epam.jwd.texteditor.model.Word;

import java.awt.*;
import java.util.ArrayList;

public class TextPartTest {
    @DataProvider(name = "TextPartProvider")
    public Object[][] getTextPartsFromProvider() {
        List<TextComponent> symbols = new ArrayList<>();
        symbols.add(new Symbol("."));
        symbols.add(new Symbol("!"));

        List<TextComponent> words = new ArrayList<>();
        List<TextComponent> words1 = new ArrayList<>();
        List<TextComponent> words2 = new ArrayList<>();
        words1.add(new Word("It"));
        words1.add(new Word("is"));
        words1.add(new Word("a"));
        words1.add(new Word("text"));
        words1.add(new Symbol("."));
        words2.add(new Word("Bye"));
        words2.add(new Symbol("!"));
        words.addAll(words1);
        words.addAll(words2);

        List<TextComponent> sentences = new ArrayList<>();
        sentences.add(new Composite(words1, TextPart.SENTENCE));
        sentences.add(new Composite(words2, TextPart.SENTENCE));

        List<TextComponent> paragraphs = new ArrayList<>();
        paragraphs.add(new Composite(sentences, TextPart.PARAGRAPH));

        return new Object[][] {
                { paragraphs, TextPart.PARAGRAPH },
                { sentences, TextPart.SENTENCE },
                { words, TextPart.WORD },
                { symbols, TextPart.SYMBOL },
        };
    }

    @Test(dataProvider = "TextPartProvider")
    public void extractParts(List<TextComponent> components, TextPart type) {
        String text = "It is a text. Bye!";
        TextParserFactory factory = TextParserFactory.getInstance();
        TextParser parser = factory.of();
        TextComposite allText = new TextComposite(parser.parse(text), TextPart.TEXT);

        assertNotNull(TextPartExtractor.extractParts(allText, type));
        assertTrue(TextPartExtractor.extractParts(allText, type).size() > 0);
        assertEquals(TextPartExtractor.extractParts(allText, type), components);
        assertSame(TextPartExtractor.extractParts(allText, type).get(0).getType(), type);
    }}
