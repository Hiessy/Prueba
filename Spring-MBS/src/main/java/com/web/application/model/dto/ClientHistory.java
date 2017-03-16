package com.web.application.model.dto;

public class ClientHistory {

	private Integer clientHistoryId; // Numerico Incremental
	private Integer clientId;// id_Cliente Numerico ID
	private String historyLog;// Dato1 Texto

	public Integer getClientHistoryId() {
		return clientHistoryId;
	}

	public void setClientHistoryId(Integer clientHistoryId) {
		this.clientHistoryId = clientHistoryId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getHistoryLog() {
		return historyLog;
	}

	public void setHistoryLog(String historyLog) {
		this.historyLog = historyLog;
	}

	@Override
	public String toString() {
		return "ClientHistory [clientHistoryId=" + clientHistoryId + ", clientId=" + clientId + ", historyLog=" + historyLog + "]";
	}

}
