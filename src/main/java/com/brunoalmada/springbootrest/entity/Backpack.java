package com.brunoalmada.springbootrest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.brunoalmada.springbootrest.entity.helper.Message;

/**
 * @author Bruno Faria Almada
 *
 */
@Entity
public class Backpack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(targetEntity = CapturedPokemon.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<CapturedPokemon> capturedPokemons;

	public List<CapturedPokemon> getCapturedPokemons() {
		return capturedPokemons;
	}

	public void setCapturedPokemons(List<CapturedPokemon> capturedPokemons) {
		this.capturedPokemons = capturedPokemons;
	}

	public Message addCapturedPokemon(CapturedPokemon capturedPokemon) {
		if (capturedPokemons.size() < 6) {
			capturedPokemons.add(capturedPokemon);
			return new Message(true, String.valueOf(capturedPokemons.indexOf(capturedPokemon)));
		}
		return new Message(false, "Backpack is full");
	}
}
