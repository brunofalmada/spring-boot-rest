package com.brunoalmada.springbootrest.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bruno Faria Almada
 *
 */
public class CapturedPokemon {

	@ApiModelProperty(notes = "Id of the pokemon")
	private int pokemonId;

	@ApiModelProperty(notes = "Nickname of the pokemon")
	private String pokemonNickname;

	@ApiModelProperty(notes = "Level of the pokemon")
	private int pokemonLevel;

	public CapturedPokemon(int pokemonId, String pokemonNickname) {
		super();
		this.pokemonId = pokemonId;
		this.pokemonNickname = pokemonNickname;
		this.pokemonLevel = 1;
	}

	public int getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(int pokemonId) {
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
