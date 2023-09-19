package dev.pradeep.SortUsingMultithreading;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergedArrays implements Runnable{
    private final int[] sortedEven;
    private final int[] sortedOdds;

    private int[] combinedArray;

    public MergedArrays(int[] sortedEven, int[] sortedOdds) {
        this.sortedEven = sortedEven;
        this.sortedOdds = sortedOdds;
    }

    @Override
    public void run() {
        combinedArray = IntStream.concat(
                Arrays.stream(sortedEven),
                Arrays.stream(sortedOdds)
        ).toArray();
    }

    public int[] getCombinedArray() {
        return combinedArray;
    }
}
