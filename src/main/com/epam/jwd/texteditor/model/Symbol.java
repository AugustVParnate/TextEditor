package main.com.epam.jwd.texteditor.model;

import java.awt.*;

public class Symbol extends TextComponent implements Cloneable {

    private final String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int getLexemeLength() {
        return 0;
    }

    @Override
    public String toString() {
        return symbol;
    }

    @Override
    public TextPart getType() {
        return TextPart.SYMBOL;
    }

    @Override
    public int getMaxWord() { // ignore
        return 0;
    }

    @Override
    public Symbol clone() {
        return new Symbol(symbol);
    }
}