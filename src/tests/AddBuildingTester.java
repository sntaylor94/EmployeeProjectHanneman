package tests;

import controller.BuildingHelper;
import model.Building;

public class AddBuildingTester {
	public static void main(String[] args) {
		BuildingHelper bHelp = new BuildingHelper();
		
		Building b1 = new Building("801 Grand Ave");
		Building b2 = new Building("711 High Street",7000,100);
		
		bHelp.addBuilding(b1);
		bHelp.addBuilding(b2);
	}
}
