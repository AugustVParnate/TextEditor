package main.com.epam.jwd.texteditor.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.OptionalInt;

public class Composite implements main.com.epam.jwd.texteditor.model.Component, Cloneable {
    private static final String NEW_LINE = "\n";

    private final List<main.com.epam.jwd.texteditor.model.Component> textComponents;
    private final TextPart type;

    public Composite(List<main.com.epam.jwd.texteditor.model.Component> textComponents, TextPart type) {
        this.textComponents = textComponents;
        this.type = type;
    }

    public TextPart getType() {
        return type;
    }

    public List<main.com.epam.jwd.texteditor.model.Component> getParts() {
        return new ArrayList<>(textComponents);
    }

    public void addPart(Component Component) {
        textComponents.add(Component);
    }

    @Override
    public int getMaxWord() { // only for sentence
        if (type == TextPart.SENTENCE) {
            OptionalInt max = Components.stream().mapToInt(TextComponent::getLexemeLength).max();
            if (max.isPresent()) {
                return max.getAsInt();
            }
        }
        return 0;
    }

    @Override
    public int getLexemeLength() {
        return Components.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (type == TextPart.PARAGRAPH) {
            stringBuilder.append(PARAGRAPH_TABULATION);
        }
        Components.forEach(stringBuilder::append);
        if (type == TextPart.PARAGRAPH) {
            stringBuilder.append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    @Override
    public Composite clone() {
        Composite clone = new Composite(new ArrayList<>(), type);
        for (TextComponent textComponent : Components) {
            clone.addPart(textComponent.clone());
        }
        return clone;
    }

}
