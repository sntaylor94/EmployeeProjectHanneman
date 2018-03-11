package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Building;

public class BuildingHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EmployeeProjectHanneman");
	
	public Building getBuilding(int buildingId) {
		EntityManager em = emfactory.createEntityManager();
		Building foundBuilding = em.find(Building.class, buildingId);
		em.close();
		return foundBuilding;
	}


	public void removeBuilding(int toRemove) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Building> removeBuilding = em.createQuery("select b FROM Building b where b.id = :selectedId",
				Building.class);
		removeBuilding.setParameter("selectedId", toRemove);
		removeBuilding.setMaxResults(1);
		Building toDelete = removeBuilding.getSingleResult();
		em.remove(toDelete);
		System.out.println("Building Removed");
		em.getTransaction().commit();
		em.close();
		
	}

	public List<Building> showAll() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Building> allResults = em.createQuery("Select c from Building c", Building.class);
		List<Building> allBuildings = allResults.getResultList();
		em.close();
		return allBuildings;
	}


	public void addBuilding(Building toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		System.out.println("Building Added");
		em.getTransaction().commit();
		em.close();
	}

}
