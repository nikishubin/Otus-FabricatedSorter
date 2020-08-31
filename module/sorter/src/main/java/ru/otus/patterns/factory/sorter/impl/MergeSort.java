package ru.otus.patterns.factory.sorter.impl;

import ru.otus.patterns.factory.sorter.Sorter;

public class MergeSort implements Sorter {

    @Override
    public void sort(int[] target) {
        int[] temp = new int[target.length];

        for (int width = 1; width < target.length; width = 2 * width) {
            for (int left = 0; left < target.length; left = left + 2 * width) {
                bottomUpMerge(target, temp, left, Math.min(left + width, target.length), Math.min(left + 2 * width, target.length));
            }

            System.arraycopy(temp, 0, target, 0, target.length);
        }
    }

    private void bottomUpMerge(int[] target, int[] temp, int left, int right, int end) {
        int leftIterator = left;
        int rightIterator = right;

        for (int batchIterator = left; batchIterator < end; batchIterator++) {
            if (leftIterator < right && (rightIterator >= end || target[leftIterator] <= target[rightIterator])) {
                temp[batchIterator] = target[leftIterator];
                leftIterator++;
            } else {
                temp[batchIterator] = target[rightIterator];
                rightIterator++;
            }
        }
    }
}
