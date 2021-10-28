package com.payoneer.paymentapp.model;

import com.google.gson.annotations.SerializedName;

public class Payment{

	@SerializedName("reference")
	private String reference;

	@SerializedName("amount")
	private int amount;

	@SerializedName("currency")
	private String currency;

	public void setReference(String reference){
		this.reference = reference;
	}

	public String getReference(){
		return reference;
	}

	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}
}