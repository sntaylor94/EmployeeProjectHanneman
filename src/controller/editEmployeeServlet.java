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
@WebServlet("/editEmployeeServlet")
public class editEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editEmployeeServlet() {
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
		String address = request.getParameter("homeAddress");
		String email = request.getParameter("email");
		LocalDate termDate = LocalDate.parse(request.getParameter("termDate"));
		int tempId = Integer.parseInt(request.getParameter("id"));
		
		Employee employeeToUpdate = eh.searchForEmployeeById(tempId);
		employeeToUpdate.setFirstName(firstName);
		employeeToUpdate.setLastName(lastName);
		employeeToUpdate.setPhone(phone);
		employeeToUpdate.setHomeAddress(address);
		employeeToUpdate.setEmail(email);
		employeeToUpdate.setTerminationDate(termDate);
		
		eh.updateEmployee(employeeToUpdate);
		
		getServletContext().getRequestDispatcher("/viewEmployeesServlet").forward(request, response);
	}

}
