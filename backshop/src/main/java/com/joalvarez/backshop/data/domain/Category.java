package com.joalvarez.backshop.data.domain;

import com.joalvarez.backshop.data.types.Categories;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	private int id;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
