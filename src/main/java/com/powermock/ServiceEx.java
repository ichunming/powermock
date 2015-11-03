package com.powermock;

public class ServiceEx implements ServiceI {

	public String selDate() throws Exception{
		return "Test Date";
	}
	
	public int createNewId() {
		return 1;
	}

	// final method
	public final boolean getStatus() {
		return false;
	}
	
	// static method
	public static int getCount() {
		return 0;
	}
}
