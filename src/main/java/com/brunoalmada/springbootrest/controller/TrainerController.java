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

import com.brunoalmada.springbootrest.entity.Trainer;
import com.brunoalmada.springbootrest.service.TrainerService;

/**
 * This is the rest controller responsible for the trainer entries.
 *
 * @author Bruno Faria Almada
 * 
 */
@RestController
@RequestMapping("/trainers")
public class TrainerController {
	@Autowired
	TrainerService service;

	/**
	 * @param trainer JSON of a trainer entity
	 * @return URI for the newly created resource
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Integer> postTrainer(@RequestBody Trainer trainer) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.location(new URI("/trainers/" + service.addTrainer(trainer))).build();
		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * @param id of trainer entry
	 * @return trainer entity linked with provided id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Trainer> getTrainer(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getTrainer(id));
	}

	/**
	 * @return list of all stored trainers
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Trainer>> getAllTrainers() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	/**
	 * @param id      of trainer entry
	 * @param trainer JSON of a trainer entity
	 * @return no content
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateTrainer(@PathVariable long id, @RequestBody Trainer trainer) {
		if (service.updateTrainer(id, trainer)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID does not exist.");
	}

	/**
	 * @param id of trainer entry
	 * @return no content
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTrainer(@PathVariable long id) {
		if (service.removeTrainer(id)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID does not exist.");
	}

}
