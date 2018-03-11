package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JOB_ID")
	private int id;
	@Column(name="START_DATE")
	private LocalDate startDate;
	@Column(name="END_DATE")
	private LocalDate endDate;
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;
	@ManyToOne
	@JoinColumn(name="POSITION_ID")
	private Position position;
	@ManyToOne
	@JoinColumn(name="BUILDING_ID")
	private Building building;

	public Job() {

	}

	public Job(LocalDate start, Employee e, Position p) {
		this.setStartDate(start);
		this.setEmployee(e);
		this.setPosition(p);
	}

	public Job(LocalDate start, Employee e, Position p, Building b) {
		this.setStartDate(start);
		this.setEmployee(e);
		this.setPosition(p);
		this.setBuilding(b);
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public int getId() {
		return id;
	}
	


	public String getJobDetails() {
		return "Job ID: " + id + "\n-------Position Details--------\n" + this.position.getPositionDetails() + " Start Date: " + startDate
				+ " End Date: " + endDate + "\n-------Employee Details--------\n" + this.employee.getEmployeeDetails();
	}
	
	public String getJobDetailsWithBuilding() {
		return "Job ID: " + id + "\n-------Position Details--------" + this.position.getPositionDetails() + " Start Date: " + startDate
				+ " End Date: " + endDate + "\n-------Employee Details--------\n" + this.employee.getEmployeeDetails()
				+ "\n-------Building Assignment Details-------\n" + this.building.getBuildingDetails();
	}

}
