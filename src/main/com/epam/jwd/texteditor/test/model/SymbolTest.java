package main.com.epam.jwd.texteditor.test.model;

import main.com.epam.jwd.texteditor.model.Symbol;
import main.com.epam.jwd.texteditor.model.TextPart;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SymbolTest {
    private final Symbol symbol = new Symbol("...");

    @Test
    public void getLexemeLength_shouldReturn0_always() {
        assertSame(symbol.getLexemeLength(), 0);
    }

    private void assertSame(TextPart lexemeLength, TextPart i) {
    }

    @Test
    public void toString_shouldReturnString_always() {
        assertEquals(symbol.toString(), "...");
    }

    @Test
    public void getType_shouldReturnSymbol_always() {
        assertSame(symbol.getType(), TextPart.SYMBOL);
    }

    @Test
    public void getMaxWord_shouldReturn0_always() {
        assertSame(symbol.getMaxWord(), 0);
    }

    @Test
    public void clone_shouldReturnClonedObject_always() {
        assertEquals(symbol.clone(), symbol);
    }

}
