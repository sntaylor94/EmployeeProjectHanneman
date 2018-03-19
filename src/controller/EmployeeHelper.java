package controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Employee;

public class EmployeeHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeProjectHanneman");
//
//	public Employee getEmployee(int employeeId) {
//		EntityManager em = emfactory.createEntityManager();
//		Employee foundEmployee = em.find(Employee.class, employeeId);
//		em.close();
//		return foundEmployee;
//	}

	public List <Employee> showAll() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Employee> allResults = em.createQuery("Select c from Employee c", Employee.class);
		List<Employee> allEmployees = allResults.getResultList();
		em.close();
		return allEmployees;
		
	}
	
	public List <Employee> showAllActive() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Employee> allResults = em.createQuery("Select c from Employee c WHERE c.terminationDate = null", Employee.class);
		List<Employee> allEmployees = allResults.getResultList();
		em.close();
		return allEmployees;	
	}

	public void terminateEmployee(int employeeId, LocalDate termDate) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> terminateEmployee = em.createQuery("UPDATE Employee e SET e.terminationDate = :selectedDate " + "WHERE e.id = :selectedId", Employee.class);
		terminateEmployee.setParameter("selectedDate", termDate);
		terminateEmployee.setParameter("selectedId", employeeId);
		int updateCount = terminateEmployee.executeUpdate();
		if(updateCount>0) {
			System.out.println("Employee Terminated");
		}
		em.getTransaction().commit();
		em.close();
		
	}

	public void addEmployee(Employee toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		System.out.println("Employee Added");
		em.getTransaction().commit();
		em.close();
		
	}

	public Employee searchForEmployeeById(int tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		Employee foundEmployee = em.find(Employee.class, tempId);
		em.close();
		return foundEmployee;
	}

	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> updateEmployee = em.createQuery("UPDATE Employee e SET e.firstName = :selectedFN, e.lastName = :selectedLN, e.phone = :selectedPhone, e.homeAddress = :selectedAddress, e.email = :selectedEmail, e.terminationDate = :selectedDate " + "WHERE e.id = :selectedId", Employee.class);
		updateEmployee.setParameter("selectedFN", e.getFirstName());
		updateEmployee.setParameter("selectedLN", e.getLastName());
		updateEmployee.setParameter("selectedPhone", e.getPhone());
		updateEmployee.setParameter("selectedAddress", e.getHomeAddress());
		updateEmployee.setParameter("selectedEmail", e.getEmail());
		updateEmployee.setParameter("selectedDate", e.getTerminationDate());
		updateEmployee.setParameter("selectedId", e.getId());
		int updateCount = updateEmployee.executeUpdate();
		if(updateCount>0) {
			System.out.println("Employee Updated");
		}
		em.getTransaction().commit();
		em.close();
	}

}
