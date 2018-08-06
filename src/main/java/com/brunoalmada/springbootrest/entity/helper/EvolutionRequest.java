package com.brunoalmada.springbootrest.entity.helper;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bruno Faria Almada
 *
 */
public class EvolutionRequest {

	@ApiModelProperty(notes = "Id of the trainer")
	int trainerId;

	@ApiModelProperty(notes = "Position of pokemon in backpack")
	int backpackId;

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

}
