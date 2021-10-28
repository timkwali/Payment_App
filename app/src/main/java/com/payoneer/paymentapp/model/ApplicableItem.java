package com.payoneer.paymentapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ApplicableItem{

	@SerializedName("recurrence")
	private String recurrence;

	@SerializedName("redirect")
	private boolean redirect;

	@SerializedName("code")
	private String code;

	@SerializedName("method")
	private String method;

	@SerializedName("registration")
	private String registration;

	@SerializedName("links")
	private Links links;

	@SerializedName("operationType")
	private String operationType;

	@SerializedName("label")
	private String label;

	@SerializedName("grouping")
	private String grouping;

	@SerializedName("selected")
	private boolean selected;

	@SerializedName("inputElements")
	private List<InputElementsItem> inputElements;

	@SerializedName("contractData")
	private ContractData contractData;

	public void setRecurrence(String recurrence){
		this.recurrence = recurrence;
	}

	public String getRecurrence(){
		return recurrence;
	}

	public void setRedirect(boolean redirect){
		this.redirect = redirect;
	}

	public boolean isRedirect(){
		return redirect;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setMethod(String method){
		this.method = method;
	}

	public String getMethod(){
		return method;
	}

	public void setRegistration(String registration){
		this.registration = registration;
	}

	public String getRegistration(){
		return registration;
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

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setGrouping(String grouping){
		this.grouping = grouping;
	}

	public String getGrouping(){
		return grouping;
	}

	public void setSelected(boolean selected){
		this.selected = selected;
	}

	public boolean isSelected(){
		return selected;
	}

	public void setInputElements(List<InputElementsItem> inputElements){
		this.inputElements = inputElements;
	}

	public List<InputElementsItem> getInputElements(){
		return inputElements;
	}

	public void setContractData(ContractData contractData){
		this.contractData = contractData;
	}

	public ContractData getContractData(){
		return contractData;
	}
}