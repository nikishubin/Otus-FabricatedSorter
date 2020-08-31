package ru.otus.patterns.factory.sorter.usecase;

import java.io.IOException;

public interface SorterOutput {

    void write(int[] data) throws IOException;
}
