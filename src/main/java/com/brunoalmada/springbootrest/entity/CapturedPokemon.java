package com.brunoalmada.springbootrest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bruno Faria Almada
 *
 */
@Entity
public class CapturedPokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ApiModelProperty(notes = "Id of the pokemon")
	@JoinColumn(name = "pokemon_id")
	private long pokemonId;

	@ApiModelProperty(notes = "Nickname of the pokemon")
	private String pokemonNickname;

	@ApiModelProperty(notes = "Level of the pokemon")
	private int pokemonLevel;

	public CapturedPokemon () {
		this.pokemonLevel = 1;
	}
	
	public CapturedPokemon(long pokemonId, String pokemonNickname) {
		super();
		this.pokemonId = pokemonId;
		this.pokemonNickname = pokemonNickname;
		this.pokemonLevel = 1;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(long pokemonId) {
		this.pokemonId = pokemonId;
	}

	public String getPokemonNickname() {
		return pokemonNickname;
	}

	public void setPokemonNickname(String pokemonNickname) {
		this.pokemonNickname = pokemonNickname;
	}

	public int getPokemonLevel() {
		return pokemonLevel;
	}

	public void setPokemonLevel(int pokemonLevel) {
		this.pokemonLevel = pokemonLevel;
	}

}
