package com.brunoalmada.springbootrest.entity;

public class Trainer extends NamedEntity {
	public enum Sex {
		MALE, FEMALE
	}

	private Backpack backpack;

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
