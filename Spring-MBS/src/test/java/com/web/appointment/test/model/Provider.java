package com.web.appointment.test.model;

import java.util.Map;

public class Provider {

	private Map<String, Branch> providerBranch;	
	
	public Provider(Map<String, Branch> providerBranch) {
		this.providerBranch = providerBranch;
	}

	public Map<String, Branch> getProvider() {
		return providerBranch;
	}

	public void setProvider(Map<String, Branch> provider) {
		this.providerBranch = provider;
	}

	@Override
	public String toString() {
		return "Provider [providerBranch=" + providerBranch + "]";
	}

}
