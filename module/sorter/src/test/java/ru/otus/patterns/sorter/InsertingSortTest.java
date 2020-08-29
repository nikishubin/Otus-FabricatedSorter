package ru.otus.patterns.sorter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.patterns.sorter.impl.InsertingSort;

class InsertingSortTest {

    private static Sorter insertingSorter;

    @BeforeAll
    static void beforeAll() {
        insertingSorter = new InsertingSort();
    }

    @MethodSource("ru.otus.patterns.sorter.args.SorterTestArgs#getInitialAndExpectedSorterArgs")
    @ParameterizedTest
    void whenInsertingSortingIsDoneThenArraySorted(int[] initial, int[] expected) {
        insertingSorter.sort(initial);
        Assertions.assertThat(initial).containsExactly(expected);
    }
}
