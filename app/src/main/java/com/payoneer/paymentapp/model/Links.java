package com.payoneer.paymentapp.model;

import com.google.gson.annotations.SerializedName;

public class Links{

	@SerializedName("self")
	private String self;

	@SerializedName("lang")
	private String lang;

	@SerializedName("logo")
	private String logo;

	@SerializedName("operation")
	private String operation;

	@SerializedName("validation")
	private String validation;

	public void setSelf(String self){
		this.self = self;
	}

	public String getSelf(){
		return self;
	}

	public void setLang(String lang){
		this.lang = lang;
	}

	public String getLang(){
		return lang;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setOperation(String operation){
		this.operation = operation;
	}

	public String getOperation(){
		return operation;
	}

	public void setValidation(String validation){
		this.validation = validation;
	}

	public String getValidation(){
		return validation;
	}
}