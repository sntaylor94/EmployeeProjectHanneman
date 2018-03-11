package tests;

import controller.BuildingHelper;

public class RemoveBuildingTester {
	public static void main(String[] args) {
		BuildingHelper bHelp = new BuildingHelper();
		
		//need to change ID each time this is run. May also need to add new buildings
		bHelp.removeBuilding(2);
	}
}
