package com.brunoalmada.springbootrest.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunoalmada.springbootrest.entity.CapturedPokemon;
import com.brunoalmada.springbootrest.entity.Pokemon;
import com.brunoalmada.springbootrest.entity.Trainer;
import com.brunoalmada.springbootrest.entity.helper.Message;

/**
 * @author Bruno Faria Almada
 *
 */
@Service
public class MainService {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

	@Autowired
	PokemonService pokemonService;

	@Autowired
	TrainerService trainerService;

	@Transactional
	public Message capturePokemon(long trainerId, long pokemonId, String pokemonNickname) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Trainer trainer = entityManager.find(Trainer.class, trainerId);
		Pokemon pokemon = entityManager.find(Pokemon.class, pokemonId);
		if (trainer != null && pokemon != null) {
			CapturedPokemon capturedPokemon = new CapturedPokemon(pokemonId, pokemonNickname);
			entityManager.persist(capturedPokemon);
			trainer.getBackpack().addCapturedPokemon(capturedPokemon);
			entityManager.getTransaction().commit();
			return new Message(true, Long.toString(capturedPokemon.getId()));
		}
		return new Message(false, "ID does not exist");
	}

}
