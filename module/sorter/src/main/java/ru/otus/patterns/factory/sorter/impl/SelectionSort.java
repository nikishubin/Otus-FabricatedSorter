package ru.otus.patterns.factory.sorter.impl;

import ru.otus.patterns.factory.sorter.Sorter;
import ru.otus.patterns.factory.sorter.functions.SorterFunctions;

public class SelectionSort implements Sorter {

    @Override
    public void sort(int[] target) {
        for (int i = 0; i < target.length; i++) {
            int maxIndex = 0;

            for (int j = 0; j < target.length - i; j++) {
                maxIndex = target[maxIndex] <= target[j] ? j : maxIndex;
            }

            SorterFunctions.swap(target, maxIndex, target.length - i - 1);
        }
    }
}
