package com.brunoalmada.springbootrest.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.brunoalmada.springbootrest.entity.CapturedPokemon;
import com.brunoalmada.springbootrest.entity.Trainer;

@Service
public class TrainerService {
	Hashtable<Integer, Trainer> trainers = new Hashtable<Integer, Trainer>();
	int mapSize = 0;

	public int addTrainer(Trainer trainer) {
		mapSize++;
		trainers.put(mapSize, trainer);
		return mapSize;
	}

	public boolean addTrainer(int id, Trainer trainer) {
		if (!trainers.containsKey(id)) {
			if (id > mapSize) {
				mapSize = id;
			}
			trainers.put(id, trainer);
			return true;
		}
		return false;
	}

	public Hashtable<Integer, Trainer> getAll() {
		return trainers;
	}

	public Trainer getTrainer(int id) {
		return trainers.get(id);
	}

	public boolean updateTrainer(int id, Trainer trainer) {
		if (trainers.contains(id)) {
			trainer.setBackpack(trainers.get(id).getBackpack());
			trainers.put(id, trainer);
			return true;
		}
		return false;
	}

	public boolean removeTrainer(int id) {
		if (trainers.containsKey(id)) {
			trainers.remove(id);
			return true;
		}
		return false;
	}
	
	public CapturedPokemon getCapturedPokemon(int trainerId, int backpackId) {
		Trainer trainer = trainers.get(trainerId);
		if (trainer != null) {
			return trainer.getBackpack().getCapturedPokemons().get(backpackId);
		}
		return null;
	}
}
