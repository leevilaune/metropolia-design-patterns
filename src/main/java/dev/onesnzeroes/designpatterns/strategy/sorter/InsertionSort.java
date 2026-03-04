package dev.onesnzeroes.designpatterns.strategy.sorter;

/**
 * Using slightly modified insertion sort from gfg
 * <br>
 * <a href="https://www.geeksforgeeks.org/dsa/insertion-sort-algorithm/">link</a>
 */
public class InsertionSort implements Sorter {

    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
