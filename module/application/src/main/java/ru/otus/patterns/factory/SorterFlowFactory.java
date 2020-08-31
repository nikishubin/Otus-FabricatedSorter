package ru.otus.patterns.factory;

import ru.otus.patterns.factory.sorter.Sorter;
import ru.otus.patterns.factory.sorter.usecase.SorterInput;
import ru.otus.patterns.factory.sorter.usecase.SorterOutput;

public interface SorterFlowFactory {

    SorterInput getReader();

    SorterOutput getWriter();

    Sorter getSorter();
}
