package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Position;

/**
 * Servlet implementation class addPositionServlet
 */
@WebServlet("/addPositionServlet")
public class addPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addPositionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PositionHelper ph = new PositionHelper();
		String description = request.getParameter("description");
		String jobType = request.getParameter("hours");
		int hours;
		if (jobType.equals("full time")) {
			hours = 40;
		} else {
			hours = 20;
		}
		double payRate = Double.parseDouble(request.getParameter("payrate"));
		Position position = new Position(description, hours, payRate);
		ph.addPosition(position);
		getServletContext().getRequestDispatcher("/employeeHome.html").forward(request, response);
	}

}
