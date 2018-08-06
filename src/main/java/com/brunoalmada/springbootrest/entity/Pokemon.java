package com.brunoalmada.springbootrest.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bruno Faria Almada
 *
 */
public class Pokemon extends NamedEntity {

	@ApiModelProperty(notes = "Type of the pokemon")
	private String type;

	@ApiModelProperty(notes = "Id of the pokemon this evolves to")
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
