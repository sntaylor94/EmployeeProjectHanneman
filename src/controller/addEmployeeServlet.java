package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class addEmployeeServlet
 */
@WebServlet("/addEmployeeServlet")
public class addEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeHelper eh = new EmployeeHelper();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String email = request.getParameter("email");
		String homeAddress = streetAddress + " - " + city + ", " + state + " " + zip;
		String assignPos = request.getParameter("assignPos");
		
		Employee employee = new Employee(firstName, lastName, phone, homeAddress, email);
		eh.addEmployee(employee);
		if(assignPos.equals("yes")) {
			getServletContext().getRequestDispatcher("assignPositionServlet").forward(request, response);
		} else {
		getServletContext().getRequestDispatcher("/employeeHome.html").forward(request, response);
		}
	}

}
