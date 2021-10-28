package com.payoneer.paymentapp.model;

import com.google.gson.annotations.SerializedName;

public class Style{

	@SerializedName("language")
	private String language;

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}
}