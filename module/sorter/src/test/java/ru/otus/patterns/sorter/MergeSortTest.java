package ru.otus.patterns.sorter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.patterns.sorter.impl.MergeSort;

class MergeSortTest {

    private static Sorter mergeSorter;

    @BeforeAll
    static void beforeAll() {
        mergeSorter = new MergeSort();
    }

    @MethodSource("ru.otus.patterns.sorter.args.SorterTestArgs#getInitialAndExpectedSorterArgs")
    @ParameterizedTest
    void whenMergeSortingIsDoneThenArraySorted(int[] initial, int[] expected) {
        mergeSorter.sort(initial);
        Assertions.assertThat(initial).containsExactly(expected);
    }
}
