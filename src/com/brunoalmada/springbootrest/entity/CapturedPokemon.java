package com.brunoalmada.springbootrest.entity;

public class CapturedPokemon {
	private int pokemonId;
	private String pokemonNickname;
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
