package com.payoneer.paymentapp.model;

import com.google.gson.annotations.SerializedName;

public class Identification{

	@SerializedName("shortId")
	private String shortId;

	@SerializedName("longId")
	private String longId;

	@SerializedName("transactionId")
	private String transactionId;

	public void setShortId(String shortId){
		this.shortId = shortId;
	}

	public String getShortId(){
		return shortId;
	}

	public void setLongId(String longId){
		this.longId = longId;
	}

	public String getLongId(){
		return longId;
	}

	public void setTransactionId(String transactionId){
		this.transactionId = transactionId;
	}

	public String getTransactionId(){
		return transactionId;
	}
}