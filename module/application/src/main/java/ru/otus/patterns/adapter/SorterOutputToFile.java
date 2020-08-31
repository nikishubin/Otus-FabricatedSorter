package ru.otus.patterns.adapter;

import ru.otus.patterns.factory.external.writer.FileWriter;
import ru.otus.patterns.factory.sorter.Algorithm;
import ru.otus.patterns.factory.sorter.usecase.SorterOutput;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

public class SorterOutputToFile implements SorterOutput {
    private static final String DEFAULT_ROW_DELIMITER = "\n";
    private static final String DEFAULT_ELEMENT_DELIMITER = " ";

    private final FileWriter writer;

    public SorterOutputToFile(FileWriter writer) {
        this.writer = writer;
    }

    @Override
    public void write(Algorithm used, int[] data) throws IOException {
        StringJoiner rowJoiner = new StringJoiner(DEFAULT_ROW_DELIMITER);
        rowJoiner.add(used.name());
        rowJoiner.add(getFormalizedOutputData(data));

        writer.write(rowJoiner.toString().getBytes());
    }

    private String getFormalizedOutputData(int[] data) {
        StringJoiner elementJoiner = new StringJoiner(DEFAULT_ELEMENT_DELIMITER);
        Arrays.stream(data).boxed().map(String::valueOf).forEach(elementJoiner::add);
        return elementJoiner.toString();
    }
}
