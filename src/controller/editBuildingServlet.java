package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Building;

/**
 * Servlet implementation class editBuildingServlet
 */
@WebServlet("/editBuildingServlet")
public class editBuildingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBuildingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BuildingHelper bh = new BuildingHelper();
		String address = request.getParameter("streetAddress");
		int squareFeet = Integer.parseInt(request.getParameter("squareFeet"));
		int numRooms = Integer.parseInt(request.getParameter("numberOfRooms"));
		int tempId = Integer.parseInt(request.getParameter("id"));
		
		Building buildingToUpdate = bh.getBuilding(tempId);
		buildingToUpdate.setAddress(address);
		buildingToUpdate.setSquareFeet(squareFeet);
		buildingToUpdate.setNumRooms(numRooms);
		
		bh.updateBuilding(buildingToUpdate);
		
		getServletContext().getRequestDispatcher("/viewBuildingsServlet").forward(request, response);
	}

}
