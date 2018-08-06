package com.brunoalmada.springbootrest.entity.helper;

/**
 * @author Bruno Faria Almada
 *
 */
public class CaptureRequest {
	int trainerId;
	int pokemonId;
	String nickname;

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
