package com.mtit.service;

public class ServiceManager {
	private static EmployeeService mEmployeeService = null;
	
	public static EmployeeService getEmployeeService() {
		if(mEmployeeService == null) {
			mEmployeeService = new EmployeeServiceImpl();
		}
		
		return mEmployeeService;
	}
}
