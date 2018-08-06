package com.brunoalmada.springbootrest.entity.helper;

/**
 * @author Bruno Faria Almada
 *
 */
public class EvolutionRequest {
	int trainerId;
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
