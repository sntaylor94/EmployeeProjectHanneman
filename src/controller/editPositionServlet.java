package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Position;

/**
 * Servlet implementation class editPositionServlet
 */
@WebServlet("/editPositionServlet")
public class editPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPositionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PositionHelper ph = new PositionHelper();
		String description = request.getParameter("description");
		int hours = Integer.parseInt(request.getParameter("hours"));
		double payRate = Double.parseDouble(request.getParameter("payRate"));
		char active = request.getParameter("active").charAt(0);
		int tempId = Integer.parseInt(request.getParameter("id"));
		
		Position positionToUpdate = ph.getPosition(tempId);
		positionToUpdate.setDescription(description);
		positionToUpdate.setHours(hours);
		positionToUpdate.setPayRate(payRate);
		positionToUpdate.setActiveJob(active);
		
		ph.updatePosition(positionToUpdate);
		getServletContext().getRequestDispatcher("/viewPositionsServlet").forward(request, response);
	}

}
