package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Building;
import model.Employee;
import model.Job;
import model.Position;

/**
 * Servlet implementation class assignJobServlet
 */
@WebServlet("/assignJobServlet")
public class assignJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobHelper jh = new JobHelper();
		EmployeeHelper eh = new EmployeeHelper();
		PositionHelper ph = new PositionHelper();
		BuildingHelper bh = new BuildingHelper();
		
		int tempEmpId = Integer.parseInt(request.getParameter("employeeId"));
		Employee employee = eh.searchForEmployeeById(tempEmpId);
		int startDay = Integer.parseInt(request.getParameter("day"));
		int startYear = Integer.parseInt(request.getParameter("year"));
		String stringMonth = request.getParameter("month");
		int startMonth = 1;
		if(stringMonth.equals("jan")) {
			startMonth = 1;
		} else if(stringMonth.equals("feb")) {
			startMonth = 2;
		} else if(stringMonth.equals("mar")) {
			startMonth = 3;
		} else if(stringMonth.equals("april")) {
			startMonth = 4;
		} else if(stringMonth.equals("may")) {
			startMonth = 5;
		} else if(stringMonth.equals("june")) {
			startMonth = 6;
		} else if(stringMonth.equals("july")) {
			startMonth = 7;
		} else if(stringMonth.equals("aug")) {
			startMonth = 8;
		} else if(stringMonth.equals("sep")) {
			startMonth = 9;
		} else if(stringMonth.equals("oct")) {
			startMonth = 10;
		} else if(stringMonth.equals("nov")) {
			startMonth = 11;
		} else if(stringMonth.equals("dec")) {
			startMonth = 12;
		}
		LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
		int tempPosId = Integer.parseInt(request.getParameter("positionId"));
		Position position = ph.getPosition(tempPosId);
		int tempBuildId = Integer.parseInt(request.getParameter("buildingId"));
		Building building = bh.getBuilding(tempBuildId);
		Job job = new Job(startDate, employee, position, building);
		jh.addJob(job);
		getServletContext().getRequestDispatcher("/employeeHome.html").forward(request, response);
	}

}
