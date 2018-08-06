package com.brunoalmada.springbootrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bruno Faria Almada
 *
 */
public class Trainer extends NamedEntity {
	public enum Sex {
		MALE, FEMALE
	}

	@JsonIgnore
	private Backpack backpack;

	@ApiModelProperty(notes = "Sex of the trainer")
	private Sex sex;

	public Trainer() {
		super();
		backpack = new Backpack();
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Backpack getBackpack() {
		return backpack;
	}

	public void setBackpack(Backpack backpack) {
		this.backpack = backpack;
	}

}
