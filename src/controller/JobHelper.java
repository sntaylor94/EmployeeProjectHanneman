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

	public List<Job> showAllForEmployee(int tempId) {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Job> allResults = em.createQuery("Select c from Job c" + " where c.employee.id = :selectedId", Job.class);
		allResults.setParameter("selectedId", tempId);
		List<Job> allJobsForEmployee = allResults.getResultList();
		em.close();
		return allJobsForEmployee;
	}

	public void terminateAllJobsForEmployee(Integer tempId, LocalDate termDate) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Job> terminateJob = em.createQuery("UPDATE Job j SET j.endDate = :terminationDate " + "WHERE j.employee.id = :selectedId", Job.class);
		terminateJob.setParameter("terminationDate", termDate);
		terminateJob.setParameter("selectedId", tempId);
		int updateCount = terminateJob.executeUpdate();
		if(updateCount>0) {
			System.out.println("Job Terminated");
		}
		em.getTransaction().commit();
		em.close();
	}

	public List<Job> getJobsWithBuilding(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Job> allResults = em.createQuery("Select c from Job c where c.building.id = :selectedId", Job.class);
		allResults.setParameter("selectedId", tempId);
		List<Job> allJobs = allResults.getResultList();
		em.close();
		return allJobs;
	}
	
	public void updateJobBuilding(Job j) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Job> updateBuilding = em.createQuery("UPDATE Job j SET j.building = :selectedBuilding " + "WHERE j.id = :selectedId", Job.class);
		updateBuilding.setParameter("selectedBuilding", j.getBuilding());
		updateBuilding.setParameter("selectedId", j.getId());
		int updateCount = updateBuilding.executeUpdate();
		if(updateCount>0) {
			System.out.println("Building References Removed");
		}
		em.getTransaction().commit();
		em.close();
	}

	public Job getJob(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		Job foundJob = em.find(Job.class, tempId);
		em.close();
		return foundJob;
	}

	public void updateJob(Job j) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Job> updateJob = em.createQuery("UPDATE Job j SET j.startDate = :selectedSD, j.endDate = :selectedED, j.building = :selectedBuilding " + "WHERE j.id = :selectedId", Job.class);
		updateJob.setParameter("selectedSD", j.getStartDate());
		updateJob.setParameter("selectedED", j.getEndDate());
		updateJob.setParameter("selectedBuilding", j.getBuilding());
		updateJob.setParameter("selectedId", j.getId());
		int updateCount = updateJob.executeUpdate();
		if(updateCount>0) {
			System.out.println("Job Updated");
		}
		em.getTransaction().commit();
		em.close();
	}

	public void terminateJobByPosition(Integer tempId, LocalDate termDate) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Job> terminateJob = em.createQuery("UPDATE Job j SET j.endDate = :terminationDate " + "WHERE j.position.id = :selectedId", Job.class);
		terminateJob.setParameter("terminationDate", termDate);
		terminateJob.setParameter("selectedId", tempId);
		int updateCount = terminateJob.executeUpdate();
		if(updateCount>0) {
			System.out.println("Job Terminated");
		}
		em.getTransaction().commit();
		em.close();
	}

}
