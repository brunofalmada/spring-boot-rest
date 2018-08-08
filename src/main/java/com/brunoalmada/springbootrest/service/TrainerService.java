package com.brunoalmada.springbootrest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.brunoalmada.springbootrest.entity.Trainer;

/**
 * @author Bruno Faria Almada
 *
 */
@Service
public class TrainerService {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

	@Transactional
	public long addTrainer(Trainer trainer) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(trainer);
		entityManager.getTransaction().commit();
		return trainer.getId();
	}

	@Transactional
	public List<Trainer> getAll() {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Trainer> listTrainers = entityManager.createQuery("SELECT t FROM Trainer t").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return listTrainers;
	}

	@Transactional
	public Trainer getTrainer(long id) {
		EntityManager entityManager = factory.createEntityManager();
		return entityManager.find(Trainer.class, id);
	}

	@Transactional
	public boolean updateTrainer(long id, Trainer trainer) {
		EntityManager entityManager = factory.createEntityManager();
		if (entityManager.find(Trainer.class, id) != null) {
			trainer.setId(id);
			entityManager.getTransaction().begin();
			entityManager.merge(trainer);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Transactional
	public boolean removeTrainer(long id) {
		EntityManager entityManager = factory.createEntityManager();
		Trainer trainer = entityManager.find(Trainer.class, id);
		if (trainer != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(trainer);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}

}
