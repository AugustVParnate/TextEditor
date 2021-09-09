package main.com.epam.jwd.texteditor.sort;

import main.com.epam.jwd.texteditor.model.TextPart;

import java.awt.*;
import java.util.Comparator;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public interface SortService {
    Logger LOG = LogManager.getLogger(SortService.class);

    String WRONG_TEXT_COMPONENT_MSG = "%s can't be applied to %s entity";

    default Composite sort(Composite text, Comparator<TextComponent> comparator) {
        try {
            if (text.getParts().get(0).getType() == TextPart.PARAGRAPH) {
                return sortText(text, comparator);
            } else {
                generateException(text, text.getClass());
            }
        } catch (WrongTextComponentException e) {
            LOG.warn(e);
        }
        return text;
    }

    Composite sortText(Composite text, Comparator<TextComponent> comparator);

    default void generateException(Composite text, Class<?> clazz) {
        String msg = String.format(WRONG_TEXT_COMPONENT_MSG,
                clazz.getSimpleName(),
                text.getType());
        throw new WrongTextComponentException(msg);
    }
}
