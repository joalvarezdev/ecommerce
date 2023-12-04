package com.joalvarez.backshop.data.dto;

import com.joalvarez.baseframework.data.dto.BaseDTO;

public class CategoryDTO implements BaseDTO {

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
