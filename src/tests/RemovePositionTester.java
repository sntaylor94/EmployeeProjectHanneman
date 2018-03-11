package tests;

import controller.PositionHelper;

public class RemovePositionTester {
	public static void main(String[] args) {
		PositionHelper pHelp = new PositionHelper();
		
		//Will have to change ID in removePosition each time this is run. May also need to add new positions
		pHelp.removePosition(3);
	}
}
