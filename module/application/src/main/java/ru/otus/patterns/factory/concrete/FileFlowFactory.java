package ru.otus.patterns.factory.concrete;

import ru.otus.patterns.adapter.FileToSorterInput;
import ru.otus.patterns.adapter.SorterOutputToFile;
import ru.otus.patterns.factory.SorterFlowFactory;
import ru.otus.patterns.factory.external.reader.impl.FileStreamReader;
import ru.otus.patterns.factory.external.writer.impl.OutputStreamWriter;
import ru.otus.patterns.factory.sorter.usecase.SorterInput;
import ru.otus.patterns.factory.sorter.usecase.SorterOutput;

abstract class FileFlowFactory implements SorterFlowFactory {

    protected final String inputFilePath;
    protected final String outputFilePath;

    public FileFlowFactory(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    @Override
    public SorterInput getReader() {
        return new FileToSorterInput(inputFilePath, new FileStreamReader());
    }

    @Override
    public SorterOutput getWriter() {
        return new SorterOutputToFile(new OutputStreamWriter(outputFilePath));
    }
}
