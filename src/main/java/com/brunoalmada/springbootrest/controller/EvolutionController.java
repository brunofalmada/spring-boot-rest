package com.brunoalmada.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunoalmada.springbootrest.entity.helper.EvolutionRequest;
import com.brunoalmada.springbootrest.entity.helper.Message;
import com.brunoalmada.springbootrest.service.EvolutionService;

/**
 * This is the rest controller responsible for the pokemon evolutions.
 *
 * @author Bruno Faria Almada
 * 
 */
@RestController
@RequestMapping("/evolutions")
public class EvolutionController {

	@Autowired
	EvolutionService evolutionService;

	/**
	 * @param evolutionRequest JSON containing trainerId and backpackId
	 * @return result of the evolution requisition
	 */
	@RequestMapping(value = "/evolve", method = RequestMethod.POST)
	public ResponseEntity<String> evolvePokemon(@RequestBody EvolutionRequest evolutionRequest) {
		int backpackId = evolutionRequest.getBackpackId();
		int trainerId = evolutionRequest.getTrainerId();
		Message result = evolutionService.evolvePokemon(trainerId, backpackId);
		if (result.isSuccessful()) {
			return ResponseEntity.status(HttpStatus.OK).body(result.getMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(result.getMessage());
	}

	/**
	 * @return list of all stored evolutions
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(evolutionService.getEvolutionHistory());
	}

}
