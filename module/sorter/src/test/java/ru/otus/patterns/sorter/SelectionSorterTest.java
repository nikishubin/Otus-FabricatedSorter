package ru.otus.patterns.sorter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.patterns.factory.sorter.Sorter;
import ru.otus.patterns.factory.sorter.impl.SelectionSort;

class SelectionSorterTest {

    private static Sorter selectionSorter;

    @BeforeAll
    static void beforeAll() {
        selectionSorter = new SelectionSort();
    }

    @MethodSource("ru.otus.patterns.sorter.args.SorterTestArgs#getInitialAndExpectedSorterArgs")
    @ParameterizedTest
    void whenSelectionSortingIsDoneThenArraySorted(int[] initial, int[] expected) {
        selectionSorter.sort(initial);
        Assertions.assertThat(initial).containsExactly(expected);
    }
}
