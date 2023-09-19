package dev.pradeep.SortUsingMultithreading;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class SortUsingMultithreadingApplicationTests {

	private SortUsingMultithreadingApplication sortUsingMultithreadingApplication =
			new  SortUsingMultithreadingApplication();

	@ParameterizedTest
	@MethodSource("getInputArrays")
	@DisplayName("Sort and merge using Thread object")
	void sortAndMergeUsingThreads(final int[] arr) throws InterruptedException{
		sortUsingMultithreadingApplication.setArray(arr);
		sortUsingMultithreadingApplication.sortAndMergeUsingThreads();
	}

	private static Stream<Arguments> getInputArrays(){
		return Stream.of(
				Arguments.of(new int[]{2, 29, 3, 0, 11, 8, 32, 94, 9, 1, 7}),
				Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}),
				Arguments.of(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1})
		);
	}

}
