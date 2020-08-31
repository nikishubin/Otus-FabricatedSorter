package ru.otus.patterns.factory.concrete;

import ru.otus.patterns.factory.sorter.Sorter;
import ru.otus.patterns.factory.sorter.impl.MergeSort;

public class MergeFactory extends FileFlowFactory {

    public MergeFactory(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    public Sorter getSorter() {
        return new MergeSort();
    }
}
