package com.brunoalmada.springbootrest.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunoalmada.springbootrest.entity.CapturedPokemon;
import com.brunoalmada.springbootrest.entity.Evolution;
import com.brunoalmada.springbootrest.entity.helper.Message;

/**
 * @author Bruno Faria Almada
 *
 */
@Service
public class EvolutionService {
	List<Evolution> evolutionHistory = new ArrayList<Evolution>();

	@Autowired
	TrainerService trainerService;

	@Autowired
	PokemonService pokemonService;

	public Message evolvePokemon(int trainerId, int backpackId) {
		CapturedPokemon capturedPokemon = trainerService.getCapturedPokemon(trainerId, backpackId);
		if (capturedPokemon != null) {
			int pokemonId = capturedPokemon.getPokemonId();
			if (pokemonService.getPokemon(pokemonId).getEvolutionId() != 0) {
				Evolution evolution = new Evolution(new Date(System.currentTimeMillis()), trainerId, backpackId,
						pokemonId);
				capturedPokemon.setPokemonId(pokemonService.getPokemon(pokemonId).getEvolutionId());
				evolutionHistory.add(evolution);
				return new Message(true, evolutionToString(evolution));
			}
			return new Message(false, "This pokemon can't evolve");
		}
		return new Message(false, "ID does not exist");
	}

	public List<String> getEvolutionHistory() {
		List<String> history = new ArrayList<String>();
		for (Evolution evolution : evolutionHistory) {
			history.add(evolutionToString(evolution));
		}
		return history;
	}

	public String evolutionToString(Evolution evolution) {
		return ("O Pokemon "
				+ trainerService.getTrainer(evolution.getTrainerId()).getBackpack().getCapturedPokemons()
						.get(evolution.getBackpackId()).getPokemonNickname()
				+ " do treinador " + trainerService.getTrainer(evolution.getTrainerId()).getName() + " evoluiu de "
				+ pokemonService.getPokemon(evolution.getOriginPokemonId()).getName() + " para " + pokemonService
						.getPokemon(pokemonService.getPokemon(evolution.getOriginPokemonId()).getEvolutionId()).getName()
				+ " no dia " + new SimpleDateFormat("dd/MM/yyyy").format(evolution.getDate()) + ".");
	}

}
