package main.com.epam.jwd.texteditor.test;

import main.com.epam.jwd.texteditor.model.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.invoke.MethodHandleImpl.assertSame;
import static org.junit.Assert.assertEquals;

public class CompositeTest {
    private Composite textComposite;
    private final List<Component> sentences = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        List<Component> words1 = new ArrayList<>();
        List<Component> words2 = new ArrayList<>();

        words1.add(new Word("hello"));
        words1.add(new Word("car"));
        words1.add(new Symbol("..."));

        words2.add(new Word("Best"));
        words2.add(new Word("language"));
        words2.add(new Word("is"));
        words2.add(new Word("java"));
        words2.add(new Symbol("!"));

        Composite sentence1 = new Composite(words1, TextPart.SENTENCE);
        Composite sentence2 = new Composite(words2, TextPart.SENTENCE);

        sentences.add(sentence1);
        sentences.add(sentence2);

        textComposite = new TextComposite(sentences, TextPart.TEXT);
    }

    @Test
    public void getType_shouldReturnType_always() {
        assertSame(textComposite.getType(), TextPart.TEXT);
    }

    @Test
    public void getParts_shouldReturnTextParts_always() {
        assertEquals(textComposite.getParts(), sentences);
    }

    @Test
    public void addPart_shouldAddTextParts_always() {
        textComposite.addPart(new Word("add"));

        assertSame(textComposite.getParts().size(), 3);
    }

    @Test
    public void getMaxWord_shouldReturnTheLongestLengthOfAWord_always() {
        assertSame(textComposite.getParts().get(1).getMaxWord(), 8);
    }

    @Test
    public void getLexemeLength_shouldReturnTheLongestLengthOfASentence_always() {
        assertSame(textComposite.getParts().get(0).getLexemeLength(), 3);
    }

}
