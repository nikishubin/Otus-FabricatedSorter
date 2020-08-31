package ru.otus.patterns.factory.sorter;

import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Algorithm {

    SELECTION("Selection"),
    INSERTING("Inserting"),
    MERGE("Merge");

    private final String name;
    private static final Map<String, Algorithm> algorithms;

    static {
        algorithms = Arrays.stream(values()).collect(Collectors.toUnmodifiableMap(
                next -> next.name.toLowerCase(), Function.identity()
        ));
    }

    Algorithm(String name) {
        this.name = name;
    }

    public static Algorithm getAlgorithm(String name) {
        return Optional.ofNullable(algorithms.get(name))
                .orElseThrow(() -> new NoSuchElementException("Selected algorithm is not supported!"));
    }
}
