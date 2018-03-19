package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Building;
import model.Job;

/**
 * Servlet implementation class editBuildingListServlet
 */
@WebServlet("/editBuildingListServlet")
public class editBuildingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBuildingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThis");
		BuildingHelper bh = new BuildingHelper();
		JobHelper jh = new JobHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewBuildingsServlet").forward(request, response);
		} else if (act.equals("Edit Building")) {
			Building buildingToEdit = bh.getBuilding(tempId);
			request.setAttribute("buildingToEdit", buildingToEdit);
			getServletContext().getRequestDispatcher("/editBuilding.jsp").forward(request, response);
		} else if (act.equals("Remove Building")) {
			List<Job> jobs = jh.getJobsWithBuilding(tempId);
			for(Job job: jobs) {
				job.setBuilding(null);
				jh.updateJobBuilding(job);
			}
			bh.removeBuilding(tempId);
			getServletContext().getRequestDispatcher("/viewBuildingsServlet").forward(request, response);
		} else if (act.equals("Add Building")) {
			getServletContext().getRequestDispatcher("/addBuilding.html").forward(request, response);
		}
	}

}
