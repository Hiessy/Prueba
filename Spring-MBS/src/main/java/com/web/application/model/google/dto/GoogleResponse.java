package com.web.application.model.google.dto;

import java.util.List;

public class GoogleResponse {
	private List<Result> results;
	private String status;

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GoogleResponse [results=" + results + ", status=" + status + "]";
	}

}
