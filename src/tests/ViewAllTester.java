package tests;

import java.util.List;

import controller.BuildingHelper;
import controller.EmployeeHelper;
import controller.JobHelper;
import controller.PositionHelper;
import model.Building;
import model.Employee;
import model.Job;
import model.Position;

public class ViewAllTester {
	public static void main(String[] args) {
		JobHelper jHelp = new JobHelper();
		BuildingHelper bHelp = new BuildingHelper();
		EmployeeHelper eHelp = new EmployeeHelper();
		PositionHelper pHelp = new PositionHelper();
		
		List<Job> allJobs = jHelp.showAll();
		for (Job j : allJobs) {
			if (hasBuilding(j) == true) {
				System.out.println(j.getJobDetailsWithBuilding());
				System.out.println("------------------");
			} else {
				System.out.println(j.getJobDetails());
				System.out.println("------------------");
			}
		}
		
		System.out.println("---------------------------------------------------------------------------------------");
		
		List<Job> allActiveJobs = jHelp.showAllActive();
		for (Job j : allActiveJobs) {
			if (hasBuilding(j) == true) {
				System.out.println(j.getJobDetailsWithBuilding());
				System.out.println("------------------");
			} else {
				System.out.println(j.getJobDetails());
				System.out.println("------------------");
			}
		}
		
		System.out.println("---------------------------------------------------------------------------------------");
		
		List<Building> allBuildings = bHelp.showAll();
		for (Building b : allBuildings) {
			System.out.println(b.getBuildingDetails());
			System.out.println("------------------");
		}
		
		System.out.println("---------------------------------------------------------------------------------------");
		
		List<Employee> allEmployees = eHelp.showAll();
		for (Employee e : allEmployees) {
			System.out.println(e.getEmployeeDetails());
			System.out.println("------------------");
		}
		
		System.out.println("---------------------------------------------------------------------------------------");
		
		List<Employee> allActiveEmployees = eHelp.showAllActive();
		for (Employee e : allActiveEmployees) {
			System.out.println(e.getEmployeeDetails());
			System.out.println("------------------");
		}

		System.out.println("---------------------------------------------------------------------------------------");
		
		List<Position> allPositions = pHelp.showAll();
		for (Position p : allPositions) {
			System.out.println(p.getPositionDetails());
			System.out.println("------------------");
		}
	}
	
	public static boolean hasBuilding(Job j) {
		boolean building = true;
		if (j.getBuilding() == null) {
			building = false;
		}
		return building;
	}

}
