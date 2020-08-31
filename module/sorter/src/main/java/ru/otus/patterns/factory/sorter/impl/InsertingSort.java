package ru.otus.patterns.factory.sorter.impl;

import ru.otus.patterns.factory.sorter.Sorter;
import ru.otus.patterns.factory.sorter.functions.SorterFunctions;

public class InsertingSort implements Sorter {

    @Override
    public void sort(int[] target) {
        for (int i = 0; i < target.length; i++) {
            int current = target[i];

            for (int j = i - 1; j >= 0 && target[j] > current; j--) {
                SorterFunctions.swap(target, j + 1, j);
            }
        }
    }
}
