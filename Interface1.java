package com.knowledge.laxmang.java8.foreach;

@FunctionalInterface
public interface Interface1 {

	void method1(String str);

	default void log(String str) {
		System.out.println("Interface1 logging::" + str);
	}

	static void print(String str) {
		System.out.println("Interface1 Printing " + str);
	}

	// trying to override Object method gives compile time error as
	// "A default method cannot override a method from java.lang.Object"
	/*
	 * default String toString() { return "i1"; }
	 */

}