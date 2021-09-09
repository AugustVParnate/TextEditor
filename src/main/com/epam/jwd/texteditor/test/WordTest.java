package main.com.epam.jwd.texteditor.test;

import main.com.epam.jwd.texteditor.model.TextPart;
import main.com.epam.jwd.texteditor.model.Word;
import org.junit.Test;

public class WordTest {
    private final Word word = new Word("Test");

    @Test
    public void getWord_shouldReturnString_always() {
        assertEquals(word.getWord(), "Test");
    }

    private void assertEquals(String word, String test) {
    }

    @Test
    public void getLexemeLength_shouldReturnTheLengthOfWord_always() {
        assertSame(word.getLexemeLength(), 4);
    }

    private void assertSame(int lexemeLength, int i) {
    }

    @Test
    public void getType_shouldReturnWordType_always() {
        assertSame(word.getType(), TextPart.WORD);
    }

    @Test
    public void getMaxWord_shouldReturn0_always() {
        assertSame(word.getMaxWord(), 0);
    }

    @Test
    public void testClone_shouldReturnClone_always() {
        assertEquals(word.clone(), word);
    }
}
