package com.brunoalmada.springbootrest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.brunoalmada.springbootrest.entity.Pokemon;

/**
 * @author Bruno Faria Almada
 *
 */
@Service
public class PokemonService {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

	@Transactional
	public long addPokemon(Pokemon pokemon) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(pokemon);
		entityManager.getTransaction().commit();
		return pokemon.getId();
	}

	@Transactional
	public List<Pokemon> getAll() {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Pokemon> listPokemons = entityManager.createQuery("SELECT p FROM Pokemon p").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return listPokemons;
	}

	@Transactional
	public Pokemon getPokemon(long id) {
		EntityManager entityManager = factory.createEntityManager();
		return entityManager.find(Pokemon.class, id);
	}

	@Transactional
	public boolean updatePokemon(long id, Pokemon pokemon) {
		EntityManager entityManager = factory.createEntityManager();
		if (entityManager.find(Pokemon.class, id) != null) {
			pokemon.setId(id);
			entityManager.getTransaction().begin();
			entityManager.merge(pokemon);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Transactional
	public boolean removePokemon(long id) {
		EntityManager entityManager = factory.createEntityManager();
		Pokemon pokemon = entityManager.find(Pokemon.class, id);
		if (pokemon != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(pokemon);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}
}
