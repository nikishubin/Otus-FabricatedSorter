package ru.otus.patterns.factory.sorter.usecase;

import ru.otus.patterns.factory.sorter.Algorithm;

import java.io.IOException;

public interface SorterOutput {

    void write(Algorithm used, int[] data) throws IOException;
}
