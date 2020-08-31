package ru.otus.patterns.factory.external.reader;

import java.io.IOException;

public interface FileReader {

    byte[] read(String path) throws IOException;
}
