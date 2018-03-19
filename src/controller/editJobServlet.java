package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Building;
import model.Job;

/**
 * Servlet implementation class editJobServlet
 */
@WebServlet("/editJobServlet")
public class editJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JobHelper jh = new JobHelper();
		BuildingHelper bh = new BuildingHelper();
		LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
		int tempBuildingId = Integer.parseInt(request.getParameter("futureBuildingId"));
		LocalDate endDate = LocalDate.parse(request.getParameter("termDate"));
		int tempJobId = Integer.parseInt(request.getParameter("id"));
		
		Job jobToUpdate = jh.getJob(tempJobId);
		Building building = bh.getBuilding(tempBuildingId);
		jobToUpdate.setStartDate(startDate);
		jobToUpdate.setEndDate(endDate);
		jobToUpdate.setBuilding(building);
		
		jh.updateJob(jobToUpdate);
		getServletContext().getRequestDispatcher("/viewEmployeesServlet").forward(request, response);
	}

}
