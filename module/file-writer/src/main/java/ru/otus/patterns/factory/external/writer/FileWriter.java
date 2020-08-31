package ru.otus.patterns.factory.external.writer;

import java.io.IOException;

public interface FileWriter {

    void write(byte[] target) throws IOException;
}
