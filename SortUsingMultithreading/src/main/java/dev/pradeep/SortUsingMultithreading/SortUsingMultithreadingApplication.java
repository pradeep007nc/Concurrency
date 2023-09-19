package dev.pradeep.SortUsingMultithreading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SortUsingMultithreadingApplication {

	private int[] array;

	public void setArray(int[] array) {
		this.array = array;
	}

	public void sortAndMergeUsingThreads() throws InterruptedException{
		if (array == null || array.length == 0)
			return;

		//can use var locally no need to explicitly declare object
		final var sortEvens = new SortOrEvens(array, false);
		final var sortOdds = new SortOrEvens(array, true);

		Thread thread1 = new Thread(sortEvens);
		Thread thread2 = new Thread(sortOdds);

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		int[] sortedEven = sortEvens.getArray();
		int[] sortedOdds = sortOdds.getArray();

		final var mergedSorted = new MergedArrays(sortedEven, sortedOdds);
		Thread thread3 = new Thread(mergedSorted);
		thread3.start();
		thread3.join();

		final var mergedArray = mergedSorted.getCombinedArray();

		System.out.println("Sorted Even");
		printArray(sortedEven);

		System.out.println("Sorted odd");
		printArray(sortedOdds);

		System.out.println("Sorted merged");
		printArray(mergedArray);
	}

	public void printArray(int[] arr){

		for (int i: arr){
			System.out.print(i+ " ");
		}
		System.out.println();
	}
}
