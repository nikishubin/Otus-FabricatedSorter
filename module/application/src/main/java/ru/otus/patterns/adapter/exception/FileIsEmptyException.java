package ru.otus.patterns.adapter.exception;

public final class FileIsEmptyException extends RuntimeException {

    public FileIsEmptyException(String message) {
        super(message);
    }
}
