package com.knowledge.laxmang.java8.foreach;
@FunctionalInterface
public interface Interface2 {

	void method2();
	
	// Invalid '@FunctionalInterface' annotation; Interface2 is not a functional interface. 
	// Functional interfaces are new concept introduced in Java 8. An interface with exactly one abstract method becomes Functional Interface
	/* void method2(); */
	
	default void log(String str){
		System.out.println("Interface1  logging::"+str);
	}

}