package ru.otus.patterns.adapter;

import ru.otus.patterns.factory.external.writer.FileWriter;
import ru.otus.patterns.factory.sorter.usecase.SorterOutput;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

public class SorterOutputToFile implements SorterOutput {
    private final FileWriter writer;

    public SorterOutputToFile(FileWriter writer) {
        this.writer = writer;
    }

    @Override
    public void write(int[] data) throws IOException {
        StringJoiner joiner = new StringJoiner(" ");
        Arrays.stream(data).boxed().map(String::valueOf).forEach(joiner::add);

        writer.write(joiner.toString().getBytes());
    }
}
