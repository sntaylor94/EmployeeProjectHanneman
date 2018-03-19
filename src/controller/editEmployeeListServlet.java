package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class editEmployeeServlet
 */
@WebServlet("/editEmployeeListServlet")
public class editEmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editEmployeeListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThis");
		EmployeeHelper eh = new EmployeeHelper();
		JobHelper jh = new JobHelper();
		BuildingHelper bh = new BuildingHelper();
		PositionHelper ph = new PositionHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewEmployeesServlet").forward(request, response);
		} else if (act.equals("Edit Employee")) {
			Employee employeeToEdit = eh.searchForEmployeeById(tempId);
			request.setAttribute("employeeToEdit", employeeToEdit);
			getServletContext().getRequestDispatcher("/editEmployee.jsp").forward(request, response);
			//need to add class
		} else if (act.equals("Terminate Employee")) {
			LocalDate termDate = LocalDate.now();
			eh.terminateEmployee(tempId, termDate);
			jh.terminateAllJobsForEmployee(tempId, termDate);
			getServletContext().getRequestDispatcher("/viewEmployeesServlet").forward(request, response);
		} else if (act.equals("Add Employee")) {
			getServletContext().getRequestDispatcher("/addEmployee.html").forward(request, response);
		} else if (act.equals("View this Employees' Jobs")) {
			Employee employeeJobsToView = eh.searchForEmployeeById(tempId);
			request.setAttribute("employeeJobsToView", employeeJobsToView);
			getServletContext().getRequestDispatcher("/viewJobsServlet").forward(request, response);
		} else if (act.equals("Assign Employee New Job")) {
			request.setAttribute("employee", eh.searchForEmployeeById(tempId));
			request.setAttribute("allPositions", ph.showAll());
			request.setAttribute("allBuildings", bh.showAll());
			getServletContext().getRequestDispatcher("/assignJob.jsp").forward(request, response);
		}
	}

}
