package com.web.user.model;

//TODO:pagina de registracion
public class Access {
    private String token;
    private boolean accepted;

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public boolean isAccepted() {
	return accepted;
    }

    public void setAccepted(boolean accepted) {
	this.accepted = accepted;
    }

}
