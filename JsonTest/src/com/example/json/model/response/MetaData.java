package com.example.json.model.response;

public class MetaData {

	private String httpStatus;
	private String code;
	private String message;

	public String getInfo() {
		return this.code;
	}

	public void setInfo(String info) {
		this.code = info;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MetaData [httpStatus=" + httpStatus + ", code=" + code + ", message=" + message + "]";
	}


}
