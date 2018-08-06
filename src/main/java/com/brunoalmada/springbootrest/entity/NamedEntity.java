package com.brunoalmada.springbootrest.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bruno Faria Almada
 *
 */
public class NamedEntity {
	
    @ApiModelProperty(notes = "Name of the entity")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
