package main.com.epam.jwd.texteditor.exception;

public class InvalidExpressionException extends Exception {
    public InvalidExpressionException() {
    }

    public InvalidExpressionException(String message) {
        super(message);
    }
}
