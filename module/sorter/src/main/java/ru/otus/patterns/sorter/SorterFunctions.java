package ru.otus.patterns.sorter;

public final class SorterFunctions {

    private SorterFunctions() {}

    public static void swap(int[] target, int first, int second) {
        int temp = target[first];
        target[first] = target[second];
        target[second] = temp;
    }
}
