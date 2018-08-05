package com.brunoalmada.springbootrest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunoalmada.springbootrest.entity.CapturedPokemon;
import com.brunoalmada.springbootrest.entity.Trainer;
import com.brunoalmada.springbootrest.service.TrainerService;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
	@Autowired
	TrainerService service;

	@RequestMapping(value = "/add/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> putTrainer(@PathVariable int id, @RequestBody Trainer trainer) {
		if (service.addTrainer(id, trainer)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID is no empty.");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Integer> postTrainer(@RequestBody Trainer trainer) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.location(new URI("/trainers/" + service.addTrainer(trainer))).build();
		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Trainer> getTrainer(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getTrainer(id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Hashtable<Integer, Trainer>> getAllTrainers() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateTrainer(@PathVariable int id, @RequestBody Trainer trainer) {
		if (service.updateTrainer(id, trainer)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID does not exist.");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTrainer(@PathVariable int id) {
		if (service.removeTrainer(id)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID does not exist.");
	}

	@RequestMapping(value = "/{trainerId}/backpack/{backpackId}", method = RequestMethod.GET)
	public ResponseEntity<CapturedPokemon> getCapturedPokemon(@PathVariable int trainerId,
			@PathVariable int backpackId) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getCapturedPokemon(trainerId, backpackId));
	}
}
