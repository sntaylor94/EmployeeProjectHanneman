package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="position_detail")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POSITION_ID")
	private int id;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "HOURS")
	private int hours;
	@Column(name = "PAY_RATE")
	private double payRate;
	
	
	public Position() {
		
	}
	
	public Position(String d, int h) {
		this.setDescription(d);
		this.setHours(h);
	}
	
	public Position(String d, int h, double p) {
		this.setDescription(d);
		this.setHours(h);
		this.setPayRate(p);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public double getPayRate() {
		return payRate;
	}
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}
	public int getId() {
		return id;
	}
	
	public String getPositionDetails() {
		return "Position ID: " + id + "\nJob Description: " + description + "\nHours Per Week: " + hours + "\nPay Rate: " + payRate;
	}
	
}
