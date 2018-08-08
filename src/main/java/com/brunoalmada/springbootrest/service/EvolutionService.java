package com.brunoalmada.springbootrest.service;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunoalmada.springbootrest.entity.CapturedPokemon;
import com.brunoalmada.springbootrest.entity.Evolution;
import com.brunoalmada.springbootrest.entity.Pokemon;
import com.brunoalmada.springbootrest.entity.Trainer;
import com.brunoalmada.springbootrest.entity.helper.Message;

/**
 * @author Bruno Faria Almada
 *
 */
@Service
public class EvolutionService {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

//	List<Evolution> evolutionHistory = new ArrayList<Evolution>();

	@Autowired
	TrainerService trainerService;

	@Autowired
	PokemonService pokemonService;

	@Transactional
	public Message evolvePokemon(long trainerId, long backpackId) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		CapturedPokemon capturedPokemon = entityManager.find(CapturedPokemon.class, backpackId);
		if (capturedPokemon != null) {
			long pokemonId = capturedPokemon.getPokemonId();
			Pokemon pokemon = entityManager.find(Pokemon.class, pokemonId);
			if (pokemon.getEvolutionId() != 0) {
				Evolution evolution = new Evolution(new Date(System.currentTimeMillis()), trainerId, backpackId,
						pokemonId);
				capturedPokemon.setPokemonId(pokemon.getEvolutionId());
				entityManager.merge(capturedPokemon);
				entityManager.persist(evolution);
				entityManager.getTransaction().commit();
				return new Message(true, evolutionToString(evolution));
			}
			return new Message(false, "This pokemon can't evolve");
		}
		return new Message(false, "ID does not exist");
	}

	@Transactional
	public String evolutionToString(Evolution evolution) {
		EntityManager entityManager = factory.createEntityManager();
		Pokemon pokemon = entityManager.find(Pokemon.class, evolution.getOriginPokemonId());
		Pokemon evolvedPokemon = entityManager.find(Pokemon.class, pokemon.getEvolutionId());
		Trainer trainer = entityManager.find(Trainer.class, evolution.getTrainerId());
		CapturedPokemon capturedPokemon = entityManager.find(CapturedPokemon.class, evolution.getBackpackId());
		return ("O Pokemon " + capturedPokemon.getPokemonNickname() + " do treinador " + trainer.getName()
				+ " evoluiu de " + pokemon.getName() + " para " + evolvedPokemon.getName() + " no dia "
				+ new SimpleDateFormat("dd/MM/yyyy").format(evolution.getDate()) + ".");
	}

	public List<String> getEvolutionHistory() {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Evolution> listEvolutions = entityManager.createQuery("SELECT e FROM Evolution e").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		List<String> evolutionHistory = new ArrayList<String>();
		for (Evolution evolution : listEvolutions) {
			evolutionHistory.add(evolutionToString(evolution));
		}
		return evolutionHistory;
	}

}
