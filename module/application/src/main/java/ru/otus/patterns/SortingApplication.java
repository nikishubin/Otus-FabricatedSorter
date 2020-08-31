package ru.otus.patterns;

import ru.otus.patterns.factory.SorterFlowFactory;
import ru.otus.patterns.factory.concrete.InsertionFactory;
import ru.otus.patterns.factory.concrete.MergeFactory;
import ru.otus.patterns.factory.concrete.SelectionFactory;
import ru.otus.patterns.factory.sorter.Algorithm;
import ru.otus.patterns.factory.sorter.Sorter;
import ru.otus.patterns.factory.sorter.usecase.SorterInput;
import ru.otus.patterns.factory.sorter.usecase.SorterOutput;

import java.io.IOException;

public class SortingApplication {

    public static void main(String[] args) throws IOException {
        Algorithm algorithm = Algorithm.getAlgorithm(args[0]);
        String inputPath = args[1];
        String outputPath = args[2];

        SorterFlowFactory flow = getFlowByAlgorithm(algorithm, inputPath, outputPath);

        SorterInput reader = flow.getReader();
        Sorter sorter = flow.getSorter();
        SorterOutput writer = flow.getWriter();

        int[] input = reader.read();
        sorter.sort(input);
        writer.write(algorithm, input);
    }

    private static SorterFlowFactory getFlowByAlgorithm(Algorithm algorithm, String inputFilePath, String outputFilePath) {
        return switch (algorithm) {
            case MERGE -> new MergeFactory(inputFilePath, outputFilePath);
            case INSERTING -> new InsertionFactory(inputFilePath, outputFilePath);
            case SELECTION -> new SelectionFactory(inputFilePath, outputFilePath);
        };
    }
}
