package com.powermock;

public class LogicEx implements LogicI{
	private ServiceI service = new ServiceEx();

	public String getDate() throws Exception{
		return service.selDate();
	}

	public int getId() {
		// inner new object
		ServiceI service_001 = new ServiceEx();
		return service_001.createNewId();
	}
	
	public ServiceI getService() {
		return service;
	}

	public void setService(ServiceI service) {
		this.service = service;
	}

	public boolean isOK() {
		// invoke final method
		return service.getStatus();
	}
	
	public int getCount() {
		// invoke static method
		return ServiceEx.getCount();
	}
	
	public String getMsg() {
		return print();
	}
	
	// private method
	private String print() {
		return "Hello";
	}
}
