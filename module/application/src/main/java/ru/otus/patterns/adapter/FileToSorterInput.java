package ru.otus.patterns.adapter;

import ru.otus.patterns.adapter.exception.FileIsEmptyException;
import ru.otus.patterns.factory.external.reader.FileReader;
import ru.otus.patterns.factory.sorter.usecase.SorterInput;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileToSorterInput implements SorterInput {

    private static final String DEFAULT_ELEMENT_DELIMITER = "([\\s,.;]+)";
    private static final String DEFAULT_ROW_DELIMITER = "(\\n)";

    private final String pathToFile;
    private final FileReader fileReader;

    private final String elementDelimiter;
    private final String rowDelimiter;

    public FileToSorterInput(String pathToFile, FileReader fileReader) {
        this.pathToFile = pathToFile;
        this.fileReader = fileReader;
        this.elementDelimiter = DEFAULT_ELEMENT_DELIMITER;
        this.rowDelimiter = DEFAULT_ROW_DELIMITER;
    }

    public FileToSorterInput(String pathToFile, String elementDelimiterRegex, String rowDelimiterRegex, FileReader fileReader) {
        this.pathToFile = pathToFile;
        this.elementDelimiter = elementDelimiterRegex;
        this.rowDelimiter = rowDelimiterRegex;
        this.fileReader = fileReader;
    }


    @Override
    public int[] read() throws IOException {
        String source = getSourceFromFile();

        return getInputFromUnparsedString(source);
    }


    private String getSourceFromFile() throws IOException {
        String source = new String(fileReader.read(pathToFile), Charset.defaultCharset());
        if (source.isBlank()) {
            throw new FileIsEmptyException("Source file is empty!");
        }

        return source;
    }

    private int[] getInputFromUnparsedString(String source) {
        List<Integer> input = new ArrayList<>();
        Arrays.stream(source.split(rowDelimiter))
                .map(row -> Arrays.stream(row.split(elementDelimiter)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()))
                .forEach(input::addAll);
        return input.stream().mapToInt(Integer::intValue).toArray();
    }
}
