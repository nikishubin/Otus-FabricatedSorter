package ru.otus.patterns.factory.sorter.usecase;

import java.io.IOException;

public interface SorterInput {

    int[] read() throws IOException;
}
