package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class Building {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BUILDING_ID")
	private int id;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="SQUARE_FEET")
	private int squareFeet;
	@Column(name="NUM_ROOMS")
	private int numRooms;
	
	public Building() {
		
	}
	
	public Building(String a) {
		this.setAddress(a);
	}
	
	public Building(String a, int s, int n) {
		this.setAddress(a);
		this.setSquareFeet(s);
		this.setNumRooms(n);
	}
	
	public Building(int Id, String a, int s, int n) {
		this.setAddress(a);
		this.setSquareFeet(s);
		this.setNumRooms(n);
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(int squareFeet) {
		this.squareFeet = squareFeet;
	}
	public int getNumRooms() {
		return numRooms;
	}
	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}
	public int getId() {
		return id;
	}
	
	public String getBuildingDetails() {
		return "Building ID: " + id + "\nAddress: " + address + "\nSquare Feet: " + squareFeet + "\nNumber of Rooms: " + numRooms;
	}
	
	
}
