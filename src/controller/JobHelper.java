package controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Job;

public class JobHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeProjectHanneman");
	
	public void addJob(Job toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		System.out.println("Job Added");
		em.getTransaction().commit();
		em.close();
		
	}

	public void terminateJob(int jobId, LocalDate termDate) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Job> terminateJob = em.createQuery("UPDATE Job j SET j.endDate = :terminationDate " + "WHERE j.id = :selectedId", Job.class);
		terminateJob.setParameter("terminationDate", termDate);
		terminateJob.setParameter("selectedId", jobId);
		int updateCount = terminateJob.executeUpdate();
		if(updateCount>0) {
			System.out.println("Job Terminated");
		}
		em.getTransaction().commit();
		em.close();

	}

	public List<Job> showAll() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Job> allResults = em.createQuery("Select c from Job c", Job.class);
		List<Job> allJobs = allResults.getResultList();
		em.close();
		return allJobs;
	}
	
	public List<Job> showAllActive() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Job> allResults = em.createQuery("Select c from Job c where c.endDate = null", Job.class);
		List<Job> allJobs = allResults.getResultList();
		em.close();
		return allJobs;
	}

}
