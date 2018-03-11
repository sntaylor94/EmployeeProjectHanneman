package tests;

import controller.EmployeeHelper;
import model.Employee;

public class AddAnEmployeeTester {
	public static void main(String[] args) {
		EmployeeHelper eHelp = new EmployeeHelper();

		Employee e1 = new Employee("Shannon", "Hanneman", "5155555555", "801 Grand Ave, Des Moines, IA 50309",
				"hanneman@abc.com");
		eHelp.addEmployee(e1);
	}
}
