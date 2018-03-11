package tests;

import controller.PositionHelper;
import model.Position;

public class AddPositionTester {
	public static void main(String[] args) {
		PositionHelper pHelp = new PositionHelper();
		
		Position p1 = new Position("Boss",40,40.00);
		
		pHelp.addPosition(p1);
		
	}
}
