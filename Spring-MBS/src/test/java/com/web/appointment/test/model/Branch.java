package com.web.appointment.test.model;


import java.util.List;
import java.util.Map;

public class Branch {
	
	private Map<String, List<Service>> branchService;

	public Branch(Map<String, List<Service>> branchService) {
		super();
		this.branchService = branchService;
	}

	public Map<String, List<Service>> getBranchService() {
		return branchService;
	}

	public void setBranchService(Map<String, List<Service>> branchService) {
		this.branchService = branchService;
	}

	@Override
	public String toString() {
		return "Branch [branchService=" + branchService + "]";
	}	
	

	
}
