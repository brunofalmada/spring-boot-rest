package com.brunoalmada.springbootrest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunoalmada.springbootrest.entity.Pokemon;
import com.brunoalmada.springbootrest.service.PokemonService;

/**
 * This is the rest controller responsible for the pokemon entities.
 *
 * @author Bruno Faria Almada
 * 
 */
@RestController
@RequestMapping("/pokemons")
public class PokemonController {
	@Autowired
	PokemonService service;

	/**
	 * @param pokemon JSON of a pokemon entity
	 * @return URI for the newly created resource
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Long> postPokemon(@RequestBody Pokemon pokemon) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.location(new URI("/pokemons/" + service.addPokemon(pokemon))).build();
		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * @param id of pokemon entry
	 * @return pokemon entity linked with provided id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pokemon> getPokemon(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getPokemon(id));
	}

	/**
	 * @return list of all stored pokemon
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> getAllPokemon() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	/**
	 * @param id      of pokemon entry
	 * @param pokemon JSON of a pokemon entity
	 * @return no content
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updatePokemon(@PathVariable long id, @RequestBody Pokemon pokemon) {
		if (service.updatePokemon(id, pokemon)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID does not exist.");
	}

	/**
	 * @param id of pokemon entry
	 * @return no content
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePokemon(@PathVariable long id) {
		if (service.removePokemon(id)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID does not exist.");
	}
}
