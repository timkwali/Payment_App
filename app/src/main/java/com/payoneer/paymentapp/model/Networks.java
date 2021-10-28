package com.payoneer.paymentapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Networks{

	@SerializedName("applicable")
	private List<ApplicableItem> applicable;

	public void setApplicable(List<ApplicableItem> applicable){
		this.applicable = applicable;
	}

	public List<ApplicableItem> getApplicable(){
		return applicable;
	}
}