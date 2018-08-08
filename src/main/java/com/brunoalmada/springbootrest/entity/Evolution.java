package com.brunoalmada.springbootrest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * @author Bruno Faria Almada
 *
 */
@Entity
public class Evolution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Date date;

	@JoinColumn(name = "trainer_id")
	private long trainerId;

	@JoinColumn(name = "capturedpokemon_id")
	private long backpackId;

	@JoinColumn(name = "pokemon_id")
	private long originPokemonId;

	public Evolution() {
		super();
	}

	public Evolution(Date date, long trainerId, long backpackId, long originPokemonId) {
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

	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public long getBackpackId() {
		return backpackId;
	}

	public void setBackpackId(long backpackId) {
		this.backpackId = backpackId;
	}

	public long getOriginPokemonId() {
		return originPokemonId;
	}

	public void setOriginPokemonId(long originPokemonId) {
		this.originPokemonId = originPokemonId;
	}

}
