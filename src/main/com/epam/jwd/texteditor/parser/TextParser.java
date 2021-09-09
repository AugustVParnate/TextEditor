package main.com.epam.jwd.texteditor.parser;

import main.com.epam.jwd.texteditor.model.Component;

import java.util.Collections;
import java.util.List;

public abstract class TextParser {
    private TextParser next;

    public abstract List<Component> parse(String text);

    public TextParser linkWith(TextParser next) {
        this.next = next;
        return next;
    }

    protected List<Component> parseNext(String text) {
        if (next == null) {
            return Collections.emptyList();
        }
        return next.parse(text);
    }
}
