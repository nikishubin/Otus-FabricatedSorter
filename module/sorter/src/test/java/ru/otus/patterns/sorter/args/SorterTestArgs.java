package ru.otus.patterns.sorter.args;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Collections;
import java.util.stream.Stream;

public final class SorterTestArgs {

    private SorterTestArgs() {
    }

    public static Stream<Arguments> getInitialAndExpectedSorterArgs() {
        int[] firstInitial = {4, 5, 3, 2, 1};
        int[] firstExpected = {1, 2, 3, 4, 5};

        int[] secondInitial = {-4, -5, -2, -3, -1};
        int[] secondExpected = {-5, -4, -3, -2, -1};

        int[] thirdInitial = {1, 2, 1, 2, 1};
        int[] thirdExpected = {1, 1, 1, 2, 2};

        return Stream.of(
                Arguments.arguments(
                        firstInitial,
                        firstExpected
                ),
                Arguments.arguments(
                        secondInitial,
                        secondExpected
                ),
                Arguments.arguments(
                        thirdInitial,
                        thirdExpected
                )
        );
    }
}
