package com.knowledge.laxmang.java8.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Java8ForEachExample {

	public static void main(String[] args) {

		// creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			myList.add(i);
			if (i == 6) {
				myList.add(null);
			}

		}

		// traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println("Iterator Value::" + i);
			// Below line produce : Iterator Value::0 Exception in thread "main"
			// java.util.ConcurrentModificationException
			// myList.remove(2);
		}

		// traversing through forEach method of Iterable with anonymous class
		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::" + t);
				// If we have element in the collection is null and iterate through null
				// element. we get error Exception in thread "main" java.lang.NullPointerException.
				// Objects.requireNonNull(t);
			}

		});

		// traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
	}
}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::" + t);
	}

}
