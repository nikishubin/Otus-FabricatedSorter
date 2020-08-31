package ru.otus.patterns.factory.concrete;

import ru.otus.patterns.factory.sorter.Sorter;
import ru.otus.patterns.factory.sorter.impl.SelectionSort;

public class SelectionFactory extends FileFlowFactory {

    public SelectionFactory(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    public Sorter getSorter() {
        return new SelectionSort();
    }
}
