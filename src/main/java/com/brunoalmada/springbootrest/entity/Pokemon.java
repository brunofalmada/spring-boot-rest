package com.brunoalmada.springbootrest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.brunoalmada.springbootrest.entity.helper.NamedEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bruno Faria Almada
 *
 */
@Entity
public class Pokemon extends NamedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ApiModelProperty(notes = "Type of the pokemon")
	private String type;

	@ApiModelProperty(notes = "Id of the pokemon this evolves to")
	@JoinColumn(name = "pokemon_id")
	private long evolutionId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getEvolutionId() {
		return evolutionId;
	}

	public void setEvolutionId(long evolutionId) {
		this.evolutionId = evolutionId;
	}

}
