package com.payoneer.paymentapp.model;

import com.google.gson.annotations.SerializedName;

public class PaymentsResponse{

	@SerializedName("resultCode")
	private String resultCode;

	@SerializedName("networks")
	private Networks networks;

	@SerializedName("resultInfo")
	private String resultInfo;

	@SerializedName("returnCode")
	private ReturnCode returnCode;

	@SerializedName("identification")
	private Identification identification;

	@SerializedName("integrationType")
	private String integrationType;

	@SerializedName("interaction")
	private Interaction interaction;

	@SerializedName("links")
	private Links links;

	@SerializedName("operationType")
	private String operationType;

	@SerializedName("style")
	private Style style;

	@SerializedName("payment")
	private Payment payment;

	@SerializedName("operation")
	private String operation;

	@SerializedName("timestamp")
	private String timestamp;

	@SerializedName("status")
	private Status status;

	public void setResultCode(String resultCode){
		this.resultCode = resultCode;
	}

	public String getResultCode(){
		return resultCode;
	}

	public void setNetworks(Networks networks){
		this.networks = networks;
	}

	public Networks getNetworks(){
		return networks;
	}

	public void setResultInfo(String resultInfo){
		this.resultInfo = resultInfo;
	}

	public String getResultInfo(){
		return resultInfo;
	}

	public void setReturnCode(ReturnCode returnCode){
		this.returnCode = returnCode;
	}

	public ReturnCode getReturnCode(){
		return returnCode;
	}

	public void setIdentification(Identification identification){
		this.identification = identification;
	}

	public Identification getIdentification(){
		return identification;
	}

	public void setIntegrationType(String integrationType){
		this.integrationType = integrationType;
	}

	public String getIntegrationType(){
		return integrationType;
	}

	public void setInteraction(Interaction interaction){
		this.interaction = interaction;
	}

	public Interaction getInteraction(){
		return interaction;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setOperationType(String operationType){
		this.operationType = operationType;
	}

	public String getOperationType(){
		return operationType;
	}

	public void setStyle(Style style){
		this.style = style;
	}

	public Style getStyle(){
		return style;
	}

	public void setPayment(Payment payment){
		this.payment = payment;
	}

	public Payment getPayment(){
		return payment;
	}

	public void setOperation(String operation){
		this.operation = operation;
	}

	public String getOperation(){
		return operation;
	}

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}

	public String getTimestamp(){
		return timestamp;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}
}