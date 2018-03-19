package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Position;

/**
 * Servlet implementation class editPositionListServlet
 */
@WebServlet("/editPositionListServlet")
public class editPositionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPositionListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThis");
		PositionHelper ph = new PositionHelper();
		JobHelper jh = new JobHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewPositionsServlet").forward(request, response);
		} else if (act.equals("Edit Position")) {
			Position positionToEdit = ph.getPosition(tempId);
			request.setAttribute("positionToEdit", positionToEdit);
			getServletContext().getRequestDispatcher("/editPosition.jsp").forward(request, response);
		} else if (act.equals("Remove Position")) {
			Position positionToEdit = ph.getPosition(tempId);
			positionToEdit.setActiveJob('N');
			ph.updatePosition(positionToEdit);
			LocalDate termDate = LocalDate.now();
			jh.terminateJobByPosition(tempId, termDate);
			getServletContext().getRequestDispatcher("/viewPositionsServlet").forward(request, response);
		} else if (act.equals("Add Position")) {
			getServletContext().getRequestDispatcher("/addPosition.html").forward(request, response);
		}
	}

}
