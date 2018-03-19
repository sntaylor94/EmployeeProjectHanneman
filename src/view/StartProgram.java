package view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.Building;
import model.Position;
import model.Employee;
import model.Job;
import controller.BuildingHelper;
import controller.EmployeeHelper;
import controller.JobHelper;
import controller.PositionHelper;

public class StartProgram {
	static Scanner scan = new Scanner(System.in);
	static BuildingHelper bh = new BuildingHelper();
	static EmployeeHelper eh = new EmployeeHelper();
	static JobHelper jh = new JobHelper();
	static PositionHelper ph = new PositionHelper();

	public static void main(String[] args) {
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("---Employement Details System---");
		while (goAgain) {
			System.out.println("*  Select a Transaction:");
			System.out.println("*  1 -- Add Building");
			System.out.println("*  2 -- Remove Building");
			System.out.println("*  3 -- Add Position");
			System.out.println("*  4 -- Remove Position");
			System.out.println("*  5 -- Add Employee");
			System.out.println("*  6 -- Terminate Employee");
			System.out.println("*  7 -- Assign Job");
			System.out.println("*  8 -- Terminate Job");
			System.out.println("*  9 -- View All");
			System.out.println("* 10 -- Exit Program");
			System.out.print("*  Your selection: ");
			int selection = scan.nextInt();
			scan.nextLine();
			
//Add remove buildings separate - removes building from job assignment if deleted, add remove position separate - if position is removed, adds termination date to job
//Add employee separate - asks for job assignment
//Terminate employee adds termination date for employee and all jobs they worked
//assign job separate
//terminate job separate
//view alls will lead into the other functions

			if (selection == 1) {
				addBuilding();
			} else if (selection == 2) {
				removeBuilding();
			} else if (selection == 3) {
				addPosition();
			} else if (selection == 4) {
				removePosition();
			} else if (selection == 5) {
				addEmployee();
			} else if (selection == 6) {
				terminateEmployee();
			} else if (selection == 7) {
				assignJob();
			} else if (selection == 8) {
				terminateJob();
			} else if (selection == 9) {
				viewAll();
			} else {
				System.out.println("   Exiting   ");
				goAgain = false;
			}

		}
	}

	private static void viewAll() {
		System.out.println("What would you like to view?");
		System.out.println("*  1 -- Employees");
		System.out.println("*  2 -- Buildings");
		System.out.println("*  3 -- Positions");
		System.out.println("*  4 -- Jobs");
		int selection = scan.nextInt();
		scan.nextLine();
		if (selection == 1) {
			List<Employee> allEmployees = eh.showAll();
			for (Employee e : allEmployees) {
				System.out.println(e.getEmployeeDetails());
				System.out.println("------------------");
			}
		} else if (selection == 2) {
			List<Building> allBuildings = bh.showAll();
			for (Building b : allBuildings) {
				System.out.println(b.getBuildingDetails());
				System.out.println("------------------");
			}
		} else if (selection == 3) {
			List<Position> allPositions = ph.showAll();
			for (Position p : allPositions) {
				System.out.println(p.getPositionDetails());
				System.out.println("------------------");
			}
		} else if (selection == 4) {
			List<Job> allJobs = jh.showAll();
			for (Job j : allJobs) {
				if (hasBuilding(j) == true) {
					System.out.println(j.getJobDetailsWithBuilding());
					System.out.println("------------------");
				} else {
					System.out.println(j.getJobDetails());
					System.out.println("------------------");
				}
			}
		}
	}

	private static void terminateJob() {
		List<Job> allJobs = jh.showAllActive();
		if (allJobs.size() > 0) {
			for (Job j : allJobs) {
				if (hasBuilding(j) == true) {
					System.out.println(j.getJobDetailsWithBuilding());
					System.out.println("------------------");
				} else {
					System.out.println(j.getJobDetails());
					System.out.println("------------------");
				}
			}
			System.out.println("Enter ID of Job to Terminate: ");
			int jobId = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Termination Date(IE 12 for the 12th):: ");
			int termDay = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Termination Month: ");
			int termMonth = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Termination Year: ");
			int termYear = scan.nextInt();
			scan.nextLine();
			LocalDate termDate = LocalDate.of(termYear, termMonth, termDay);
			jh.terminateJob(jobId, termDate);
		} else {
			System.out.println("No Active Jobs");
		}
	}

	private static void assignJob() {
		List<Employee> allEmployees = eh.showAllActive();
		if (allEmployees.size() > 0) {
			for (Employee e : allEmployees) {
				System.out.println(e.getEmployeeDetails());
				System.out.println("------------------");
			}
			System.out.println("Enter Employee ID Being Assigned to Job: ");
			int eId = scan.nextInt();
			scan.nextLine();
			Employee employee = eh.searchForEmployeeById(eId);
			System.out.println("Enter Start Day: ");
			int startDay = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Start Month: ");
			int startMonth = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Start Year: ");
			int startYear = scan.nextInt();
			scan.nextLine();
			LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
			List<Position> allPositions = ph.showAll();
			for (Position p : allPositions) {
				System.out.println(p.getPositionDetails());
				System.out.println("------------------");
			}
			System.out.println("Enter Position ID for the Job: ");
			int posId = scan.nextInt();
			Position position = ph.getPosition(posId);
			scan.nextLine();
			System.out.println("Is There a Buidling Assignment for this Job? y/n");
			String buildAssign = scan.nextLine();
			if (buildAssign.equalsIgnoreCase("y")) {
				List<Building> allBuildings = bh.showAll();
				for (Building b : allBuildings) {
					System.out.println(b.getBuildingDetails());
					System.out.println("------------------");
				}
				System.out.println("Enter Building ID for Building Assigned to Job: ");
				int buildId = scan.nextInt();
				Building building = bh.getBuilding(buildId);
				scan.nextLine();
				Job toAdd = new Job(startDate, employee, position, building);
				jh.addJob(toAdd);
			} else {
				Job toAdd = new Job(startDate, employee, position);
				jh.addJob(toAdd);
			}
		}
	}

	private static void terminateEmployee() {
		List<Employee> allEmployees = eh.showAllActive();
		if (allEmployees.size() != 0) {
			for (Employee e : allEmployees) {
				System.out.println(e.getEmployeeDetails());
				System.out.println("------------------");
			}
			System.out.println("Enter ID of Employee to Terminate: ");
			int employeeId = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Termination Date(IE 12 for the 12th): ");
			int termDay = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Termination Month: ");
			int termMonth = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Termination Year: ");
			int termYear = scan.nextInt();
			scan.nextLine();
			LocalDate termDate = LocalDate.of(termYear, termMonth, termDay);
			eh.terminateEmployee(employeeId, termDate);
		} else {
			System.out.println("No Active Employees");
		}

	}

	private static void addEmployee() {
		System.out.println("Enter Employee First Name: ");
		String firstName = scan.nextLine();
		System.out.println("Enter Employee Last Name: ");
		String lastName = scan.nextLine();
		System.out.println("Enter Employee Phone: ");
		String phone = scan.nextLine();
		System.out.println("Enter Employee Home Address: ");
		String homeAddress = scan.nextLine();
		System.out.println("Enter Employee Email: ");
		String email = scan.nextLine();
		Employee toAdd = new Employee(firstName, lastName, phone, homeAddress, email);
		System.out.println(toAdd.getEmployeeDetails());
		eh.addEmployee(toAdd);

	}

	private static void removePosition() {
		List<Position> allPositions = ph.showAll();
		for (Position p : allPositions) {
			System.out.println(p.getPositionDetails());
			System.out.println("------------------");
		}
		System.out.println("Enter ID of Job to Remove: ");
		int toRemove = scan.nextInt();
		scan.nextLine();
		;
		ph.removePosition(toRemove);
	}

	private static void addPosition() {
		int hours;
		System.out.println("Enter Job Description: ");
		String description = scan.nextLine();
		System.out.println("Is the position [f]ull time or [p]art time?");
		String fullOrPart = scan.nextLine();
		if (fullOrPart.equalsIgnoreCase("f")) {
			hours = 40;
		} else {
			hours = 20;
		}
		System.out.println("Enter the amount this position will be paid: ");
		double payRate = scan.nextDouble();
		scan.nextLine();
		Position toAdd = new Position(description, hours, payRate);
		System.out.println(toAdd.getPositionDetails());
		ph.addPosition(toAdd);
	}

	private static void removeBuilding() {
		System.out.println("-----Buildings Registered-----");
		List<Building> allBuildings = bh.showAll();
		for (Building b : allBuildings) {
			System.out.println(b.getBuildingDetails());
			System.out.println("------------------");
		}
		System.out.println("Enter ID of building to remove: ");
		int toRemove = scan.nextInt();
		scan.nextLine();
		bh.removeBuilding(toRemove);
	}

	private static void addBuilding() {
		System.out.println("Enter Building Address: ");
		String address = scan.nextLine();
		System.out.println("Do you have additional building details to enter? y/n");
		String additionalDetails = scan.nextLine();
		if (additionalDetails.equalsIgnoreCase("y")) {
			System.out.println("Enter Square Footage: ");
			int squareFeet = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Number of Rooms: ");
			int rooms = scan.nextInt();
			scan.nextLine();
			Building toAdd = new Building(address, squareFeet, rooms);
			System.out.println(toAdd.getBuildingDetails());
			bh.addBuilding(toAdd);
		} else {
			Building toAdd = new Building(address);
			System.out.println(toAdd.getBuildingDetails());
			bh.addBuilding(toAdd);
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
