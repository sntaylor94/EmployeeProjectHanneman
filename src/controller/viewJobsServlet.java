package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewJobsServlet
 */
@WebServlet("/viewJobsServlet")
public class viewJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewJobsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tempId = Integer.parseInt(request.getParameter("id"));
		JobHelper jh = new JobHelper();
		BuildingHelper bh = new BuildingHelper();
		PositionHelper ph = new PositionHelper();
		EmployeeHelper eh = new EmployeeHelper();
		request.setAttribute("allJobsForEmployee", jh.showAllForEmployee(tempId));
		request.setAttribute("employee", eh.searchForEmployeeById(tempId));
		if (jh.showAllForEmployee(tempId).isEmpty()) {
			request.setAttribute("allPositions", ph.showAll());
			request.setAttribute("allBuildings", bh.showAll());
			getServletContext().getRequestDispatcher("/assignJob.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/viewJobs.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
