package com.brunoalmada.springbootrest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.brunoalmada.springbootrest.entity.helper.NamedEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bruno Faria Almada
 *
 */
@Entity
public class Trainer extends NamedEntity {
	public enum Sex {
		MALE, FEMALE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ApiModelProperty(hidden = true)
	@OneToOne(targetEntity = Backpack.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Backpack backpack;

	@ApiModelProperty(notes = "Sex of the trainer")
	private Sex sex;

	public Trainer() {
		super();
		backpack = new Backpack();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
