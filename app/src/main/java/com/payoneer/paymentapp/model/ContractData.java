package com.payoneer.paymentapp.model;

import com.google.gson.annotations.SerializedName;

public class ContractData{

	@SerializedName("PAGE_ENVIRONMENT")
	private String pAGEENVIRONMENT;

	@SerializedName("JAVASCRIPT_INTEGRATION")
	private String jAVASCRIPTINTEGRATION;

	@SerializedName("PAGE_BUTTON_LOCALE")
	private String pAGEBUTTONLOCALE;

	public void setPAGEENVIRONMENT(String pAGEENVIRONMENT){
		this.pAGEENVIRONMENT = pAGEENVIRONMENT;
	}

	public String getPAGEENVIRONMENT(){
		return pAGEENVIRONMENT;
	}

	public void setJAVASCRIPTINTEGRATION(String jAVASCRIPTINTEGRATION){
		this.jAVASCRIPTINTEGRATION = jAVASCRIPTINTEGRATION;
	}

	public String getJAVASCRIPTINTEGRATION(){
		return jAVASCRIPTINTEGRATION;
	}

	public void setPAGEBUTTONLOCALE(String pAGEBUTTONLOCALE){
		this.pAGEBUTTONLOCALE = pAGEBUTTONLOCALE;
	}

	public String getPAGEBUTTONLOCALE(){
		return pAGEBUTTONLOCALE;
	}
}