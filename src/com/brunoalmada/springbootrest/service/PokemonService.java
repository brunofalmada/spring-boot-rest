package com.brunoalmada.springbootrest.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.brunoalmada.springbootrest.entity.Pokemon;

@Service
public class PokemonService {
	Hashtable<Integer, Pokemon> pokemons = new Hashtable<Integer, Pokemon>();
	int mapSize = 0;

	public int addPokemon(Pokemon pokemon) {
		mapSize++;
		pokemons.put(mapSize, pokemon);
		return mapSize;
	}

	public boolean addPokemon(int id, Pokemon pokemon) {
		if (!pokemons.containsKey(id)) {
			if (id > mapSize) {
				mapSize = id;
			}
			pokemons.put(id, pokemon);
			return true;
		}
		return false;
	}

	public Hashtable<Integer, Pokemon> getAll() {
		return pokemons;
	}

	public Pokemon getPokemon(int id) {
		return pokemons.get(id);
	}

	public boolean updatePokemon(int id, Pokemon pokemon) {
		if (pokemons.containsKey(id)) {
			pokemons.put(id, pokemon);
			return true;
		}
		return false;
	}

	public boolean removePokemon(int id) {
		if (pokemons.containsKey(id)) {
			pokemons.remove(id);
			return true;
		}
		return false;
	}
}
