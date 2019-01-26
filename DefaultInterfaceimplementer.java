package com.knowledge.laxmang.java8.foreach;
public class DefaultInterfaceimplementer implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
		
	}

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		System.out.println("Current Class implementer  logging::"+str);
		Interface1.print("abc");
	}
	
	public static void main(String a[]) {
		DefaultInterfaceimplementer selfRef = new DefaultInterfaceimplementer();
		selfRef.method1("Self Ref");
		selfRef.method2();
		selfRef.log("Logging from selfRef ");
		
		System.out.println("-");
		
		Interface1 Interface1Ref = new DefaultInterfaceimplementer();
		Interface1Ref.method1("Interface1 Ref");
		//Interface1Ref.method2();
		Interface1Ref.log("Logging from Interface1 Ref ");
		Interface1.print("Interface1");
		System.out.println("-");
		
		Interface1 newRef = new Interface1() {
			
			@Override
			public void method1(String str) {
				log(str);
				
			}
		};
		newRef.method1("I am Calling from Inner calss - newRef");
		
		System.out.println("-");
		
		Interface2 Interface2Ref = new DefaultInterfaceimplementer();
		///Interface2Ref.method1("Interface1 Ref");
		Interface2Ref.method2();
		Interface2Ref.log("Logging from Interface2Ref Ref ");
		
		
		
	}
	
}