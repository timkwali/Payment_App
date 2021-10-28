package com.payoneer.paymentapp.model;

import com.google.gson.annotations.SerializedName;

public class InputElementsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("type")
	private String type;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}