package com.brunoalmada.springbootrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunoalmada.springbootrest.entity.CapturedPokemon;
import com.brunoalmada.springbootrest.entity.helper.Message;

/**
 * @author Bruno Faria Almada
 *
 */
@Service
public class MainService {

	@Autowired
	PokemonService pokemonService;

	@Autowired
	TrainerService trainerService;

	public Message capturePokemon(int trainerId, int pokemonId, String pokemonNickname) {
		if (pokemonService.getPokemon(pokemonId) != null && trainerService.getTrainer(trainerId) != null) {
			CapturedPokemon capturedPokemon = new CapturedPokemon(pokemonId, pokemonNickname);
			return trainerService.getTrainer(trainerId).getBackpack().addCapturedPokemon(capturedPokemon);
		}
		return new Message(false, "ID does not exist");
	}

}
