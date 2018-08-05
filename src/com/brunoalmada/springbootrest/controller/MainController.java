package com.brunoalmada.springbootrest.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunoalmada.springbootrest.entity.helper.CaptureRequest;
import com.brunoalmada.springbootrest.entity.helper.Message;
import com.brunoalmada.springbootrest.service.MainService;

@RestController
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/capture", method = RequestMethod.POST)
	public ResponseEntity<String> capturePokemon(@RequestBody CaptureRequest captureRequest) {
		int trainerId = captureRequest.getTrainerId();
		Message result = mainService.capturePokemon(trainerId, captureRequest.getPokemonId(),
				captureRequest.getNickname());
		if (result.isSuccessful()) {
			try {
				return ResponseEntity.status(HttpStatus.CREATED)
						.location(new URI("/trainers/" + trainerId + "/backpack/" + result.getMessage())).build();
			} catch (URISyntaxException e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(result.getMessage());
	}

}
