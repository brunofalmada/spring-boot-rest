package com.brunoalmada.springbootrest.entity;

import java.util.Date;

/**
 * @author Bruno Faria Almada
 *
 */
public class Evolution {

	private Date date;

	private int trainerId;

	private int backpackId;

	private int originPokemonId;

	public Evolution(Date date, int trainerId, int backpackId, int originPokemonId) {
		super();
		this.date = date;
		this.trainerId = trainerId;
		this.backpackId = backpackId;
		this.originPokemonId = originPokemonId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getBackpackId() {
		return backpackId;
	}

	public void setBackpackId(int backpackId) {
		this.backpackId = backpackId;
	}

	public int getOriginPokemonId() {
		return originPokemonId;
	}

	public void setOriginPokemonId(int originPokemonId) {
		this.originPokemonId = originPokemonId;
	}

}
