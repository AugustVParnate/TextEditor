package main.com.epam.jwd.texteditor.model;

import java.awt.*;

public interface Component {
    String toString();

    TextPart getType();

    int getLexemeLength();

    int getMaxWord();

    TextComponent clone();

}

