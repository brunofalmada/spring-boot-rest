package com.brunoalmada.springbootrest.entity.helper;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bruno Faria Almada
 *
 */
public class CaptureRequest {
	
    @ApiModelProperty(notes = "Id of the trainer")
	int trainerId;
    
    @ApiModelProperty(notes = "Id of the pokemon")
	int pokemonId;

    @ApiModelProperty(notes = "Nickname of the pokemon")
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
