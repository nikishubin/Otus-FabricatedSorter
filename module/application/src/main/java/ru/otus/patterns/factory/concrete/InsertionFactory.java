package ru.otus.patterns.factory.concrete;

import ru.otus.patterns.factory.sorter.Sorter;
import ru.otus.patterns.factory.sorter.impl.InsertingSort;

public class InsertionFactory extends FileFlowFactory {

    public InsertionFactory(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    public Sorter getSorter() {
        return new InsertingSort();
    }
}
