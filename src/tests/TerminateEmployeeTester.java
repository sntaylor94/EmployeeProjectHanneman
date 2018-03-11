package tests;

import java.time.LocalDate;

import controller.EmployeeHelper;

public class TerminateEmployeeTester {
	public static void main(String[] args) {
		EmployeeHelper eHelp = new EmployeeHelper();
		
		//updates term date, can use same ID multiple times.
		eHelp.terminateEmployee(2, LocalDate.of(2012, 9, 10));
	}
}
