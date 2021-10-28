package com.payoneer.paymentapp.model;

import com.google.gson.annotations.SerializedName;

public class ReturnCode{

	@SerializedName("name")
	private String name;

	@SerializedName("source")
	private String source;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}
}