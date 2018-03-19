package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Position;

public class PositionHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeProjectHanneman");

	
	public Position getPosition(int positionId) {
		EntityManager em = emfactory.createEntityManager();
		Position foundPosition = em.find(Position.class, positionId);
		em.close();
		return foundPosition;
	}


	public List<Position> showAll() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Position> allResults = em.createQuery("Select c from Position c", Position.class);
		List<Position> allPositions = allResults.getResultList();
		em.close();
		return allPositions;
		
	}


	public void removePosition(int toRemove) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Position> removePosition = em.createQuery("select p from Position p where p.id = :selectedId",
				Position.class);
		removePosition.setParameter("selectedId", toRemove);
		removePosition.setMaxResults(1);
		Position toDelete = removePosition.getSingleResult();
		em.remove(toDelete);
		System.out.println("Position Removed");
		em.getTransaction().commit();
		em.close();
		
	}


	public void addPosition(Position toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		System.out.println("Position Added");
		em.getTransaction().commit();
		em.close();
		
	}


	public void updatePosition(Position p) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Position> updatePosition = em.createQuery("UPDATE Position p SET p.description = :selectedDesc, p.hours = :selectedHours, p.payRate = :selectedPR, p.activeJob = :selectedActive " + "WHERE p.id = :selectedId", Position.class);
		updatePosition.setParameter("selectedDesc", p.getDescription());
		updatePosition.setParameter("selectedHours", p.getHours());
		updatePosition.setParameter("selectedPR", p.getPayRate());
		updatePosition.setParameter("selectedActive", p.getActiveJob());
		updatePosition.setParameter("selectedId", p.getId());
		int updateCount = updatePosition.executeUpdate();
		if(updateCount>0) {
			System.out.println("Position Updated");
		}
		em.getTransaction().commit();
		em.close();
	}

}
