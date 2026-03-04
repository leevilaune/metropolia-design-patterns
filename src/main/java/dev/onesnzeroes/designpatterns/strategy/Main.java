package dev.onesnzeroes.designpatterns.strategy;

import dev.onesnzeroes.designpatterns.strategy.sorter.BubbleSort;
import dev.onesnzeroes.designpatterns.strategy.sorter.HeapSort;
import dev.onesnzeroes.designpatterns.strategy.sorter.InsertionSort;
import dev.onesnzeroes.designpatterns.strategy.sorter.Sorter;


import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(100000);

        SortContext context = new SortContext();

        System.out.println("Array with 30");
        testAllSorters(smallArray, context);

        System.out.println("Array with 100k");
        testAllSorters(largeArray, context);
    }

    public static int[] generateRandomArray(int size){
        Random random = new Random();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }

    public static void testAllSorters(int[] array, SortContext context) {
        Sorter[] sorters = {new BubbleSort(), new InsertionSort(), new HeapSort()};
        String[] sorterNames = {"Bubble Sort", "Insertion Sort", "Heap Sort"};

        for (int i = 0; i < sorters.length; i++) {
            context.setSorter(sorters[i]);
            int[] arrCopy = array.clone();

            long startTime = System.nanoTime();
            context.sort(arrCopy);
            long endTime = System.nanoTime();

            double elapsedMillis = (double) (endTime - startTime) / 1000000;
            System.out.printf("%s took %.3f ms%n", sorterNames[i], elapsedMillis);
        }
    }
}