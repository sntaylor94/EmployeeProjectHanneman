package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Building;

/**
 * Servlet implementation class addBuildingServlet
 */
@WebServlet("/addBuildingServlet")
public class addBuildingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBuildingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BuildingHelper bh = new BuildingHelper();
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String buildingAddress = streetAddress + " - " + city + ", " + state + " " + zip;
		int squareFeet = Integer.parseInt(request.getParameter("squareFeet"));
		int numRooms = Integer.parseInt(request.getParameter("numberOfRooms"));
		Building building = new Building(buildingAddress, squareFeet, numRooms);
		bh.addBuilding(building);
		getServletContext().getRequestDispatcher("/employeeHome.html").forward(request, response);
	}

}
