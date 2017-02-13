package com.example.json.model;

//TODO:pagina de registracion
public class Access {
	String user;
	String pass;
	String token;
    private String hash;
    private boolean accepted;

    public String getHash() {
	return hash;
    }

    public void setHash(String hash2) {
	this.hash = hash2;
    }

    public boolean isAccepted() {
	return accepted;
    }

    public void setAccepted(boolean accepted) {
	this.accepted = accepted;
    }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Access [user=" + user + ", pass=" + pass + ", token=" + token + ", hash=" + hash + ", accepted=" + accepted + "]";
	}


}
