package dev.pradeep.SortUsingMultithreading;

import java.util.Arrays;

public class SortOrEvens implements Runnable{

    private final int[] array;
    private final boolean isOdd;

    private int[] sortedArray;

    public SortOrEvens(final int[] array, final boolean isOdd) {
        this.array = array;
        this.isOdd = isOdd;
    }

    @Override
    public void run() {
        sortedArray = Arrays.stream(array)
                .filter(isOdd ?
                        (i -> i % 2 !=0):       //filter only odd numbers
                        (i -> i % 2 ==0))       //filter only even numbers
                .sorted()
                .toArray(); //converted IntStream to int
    }

    public int[] getArray() {
        return sortedArray;
    }

}
