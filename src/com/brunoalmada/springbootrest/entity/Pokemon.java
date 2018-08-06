package com.brunoalmada.springbootrest.entity;

/**
 * @author Bruno Faria Almada
 *
 */
public class Pokemon extends NamedEntity {
	private String type;
	private int evolutionId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEvolution() {
		return evolutionId;
	}

	public void setEvolution(int evolutionId) {
		this.evolutionId = evolutionId;
	}

}
