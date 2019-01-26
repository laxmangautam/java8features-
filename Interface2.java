package com.knowledge.laxmang.java8.foreach;
@FunctionalInterface
public interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("Interface1  logging::"+str);
	}

}