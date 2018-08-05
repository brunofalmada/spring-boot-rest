package com.brunoalmada.springbootrest.entity;

import java.util.HashMap;
import java.util.Map;

import com.brunoalmada.springbootrest.entity.helper.Message;

public class Backpack {

	Map<Integer, CapturedPokemon> capturedPokemons;

	public Backpack() {
		capturedPokemons = new HashMap<Integer, CapturedPokemon>();
	}

	public Map<Integer, CapturedPokemon> getCapturedPokemons() {
		return capturedPokemons;
	}

	public void setCapturedPokemon(Map<Integer, CapturedPokemon> capturedPokemons) {
		this.capturedPokemons = capturedPokemons;
	}

	public Message addCapturedPokemon(CapturedPokemon capturedPokemon) {
		if (capturedPokemons.size() < 6) {
			int id = capturedPokemons.size() + 1;
			capturedPokemons.put(id, capturedPokemon);
			return new Message(true, String.valueOf(id));
		}
		return new Message(false, "Backpack is full");
	}
}
