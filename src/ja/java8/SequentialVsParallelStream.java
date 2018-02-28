package ja.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class SequentialVsParallelStream {

	public static void main(String[] args) {
		int nrElements = 100000;
		List<String> list = new ArrayList<>(nrElements);

		for (int i = 0; i < nrElements; i++)
			list.add(UUID.randomUUID().toString());

		long start = System.nanoTime();
		long count = list.stream().sorted().count();
		long stop = System.nanoTime();
		System.out.println(String.format("sort + count:%d time:%d", count, TimeUnit.NANOSECONDS.toMillis(stop - start)));

		start = System.nanoTime();
		count = list.parallelStream().sorted().count();
		stop = System.nanoTime();
		System.out.println(String.format("parallel sort + count:%d time:%d", count, TimeUnit.NANOSECONDS.toMillis(stop - start)));

	}

}
