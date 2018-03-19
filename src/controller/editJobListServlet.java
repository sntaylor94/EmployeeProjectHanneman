package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Job;

/**
 * Servlet implementation class editJobsListServlet
 */
@WebServlet("/editJobListServlet")
public class editJobListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editJobListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("doThis");
		JobHelper jh = new JobHelper();
		BuildingHelper bh = new BuildingHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewJobsServlet").forward(request, response);
		} else if(act.equals("Terminate Job")) {
			LocalDate termDate = LocalDate.now();
			jh.terminateJob(tempId, termDate);
			getServletContext().getRequestDispatcher("/viewJobsServlet").forward(request, response);
		} else if(act.equals("Edit Job")) {
			Job jobToEdit = jh.getJob(tempId);
			request.setAttribute("jobToEdit", jobToEdit);
			request.setAttribute("allBuildings", bh.showAll());
			getServletContext().getRequestDispatcher("/editJob.jsp").forward(request, response);
		}
	}

}
