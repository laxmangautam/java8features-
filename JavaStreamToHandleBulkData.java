package com.knowledge.laxmang.java8.foreach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreamToHandleBulkData {

	public static void main(String[] args) throws InterruptedException {
		
		long heapSize = Runtime.getRuntime().totalMemory();
		System.out.println("Heap Size Before  = " + heapSize);
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100000000; i++) myList.add(i);
		
		//sequential stream
		Stream<Integer> sequentialStream = myList.stream();
		
		//parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();
		heapSize = Runtime.getRuntime().totalMemory();
		System.out.println("Heap Size after number process = " + heapSize);
		
		//using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p < 9);
		//using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel= "+p));
		System.out.println("--");
		
		parallelStream.close();
		
		heapSize = Runtime.getRuntime().totalMemory();
		System.out.println("Heap Size parallel close = " + heapSize);
		Thread.sleep(1000);
		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 99999989);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));
		
		sequentialStream.close();
		
		heapSize = Runtime.getRuntime().totalMemory();
		System.out.println("Heap Size sequential = " + heapSize);
		myList.clear();
		
		System.out.println("Heap Size sequential = " + heapSize);
		

	}

}