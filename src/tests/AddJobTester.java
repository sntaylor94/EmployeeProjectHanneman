package tests;

import java.time.LocalDate;

import controller.BuildingHelper;
import controller.EmployeeHelper;
import controller.JobHelper;
import controller.PositionHelper;
import model.Building;
import model.Employee;
import model.Job;
import model.Position;

public class AddJobTester {
	public static void main(String[] args) {
		JobHelper jHelp = new JobHelper();
		BuildingHelper bHelp = new BuildingHelper();
		EmployeeHelper eHelp = new EmployeeHelper();
		PositionHelper pHelp = new PositionHelper();
		
		
		Employee e1 = new Employee("Shannon", "Hanneman", "5155555555", "801 Grand Ave, Des Moines, IA 50309",
				"hanneman@abc.com");
		Building b1 = new Building("801 Grand Ave");
		Position p1 = new Position("Boss",40,40.00);
		Job j1 = new Job(LocalDate.of(2016, 7, 12),e1,p1,b1);
		
		bHelp.addBuilding(b1);
		eHelp.addEmployee(e1);
		pHelp.addPosition(p1);
		jHelp.addJob(j1);
	}
}
