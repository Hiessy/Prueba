package com.example.json.model;

public class Address {
	
	String pais;
	String provincia;
	String barrio;
	String direccion;

	public Address(){
		
	}

	public Address(String pais, String provincia, String barrio, String direccion) {
		super();
		this.pais = pais;
		this.provincia = provincia;
		this.barrio = barrio;
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Address [pais=" + pais + ", provincia=" + provincia + ", barrio=" + barrio + ", direccion=" + direccion + "]";
	}

}
