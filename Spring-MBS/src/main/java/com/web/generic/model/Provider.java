package com.web.generic.model;

import java.util.Date;

import com.web.generic.model.enums.ProviderState;

public class Provider {

	private Integer providerId; //Id_Proveedor
	private Date subsriptionDate; // Fecha_Alta
	private Date unsubscriptionDate; // Fecha_Baja TODO change to modified
	// TODO id_Usuario
	private String firstName; // Nombre_Encargada
	private String lastName; // Apellido_Encargada
	private String service; // TODO averiguar que es esto: Razon social
	private Integer numberOfBranches; // Cantidad_Sucursales
	private String providerEmail; // email TODO revisar si esto es necesario
	private ProviderState providerState; // Estado_Proveedor {Ok - Bloqueado - baja}
	private String category; // Rubro
	private String subCategory; // subRubro
	private String hmoProvider; // Obra social

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Date getSubsriptionDate() {
		return subsriptionDate;
	}

	public void setSubsriptionDate(Date subsriptionDate) {
		this.subsriptionDate = subsriptionDate;
	}

	public Date getUnsubscriptionDate() {
		return unsubscriptionDate;
	}

	public void setUnsubscriptionDate(Date unsubscriptionDate) {
		this.unsubscriptionDate = unsubscriptionDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Integer getNumberOfBranches() {
		return numberOfBranches;
	}

	public void setNumberOfBranches(Integer numberOfBranches) {
		this.numberOfBranches = numberOfBranches;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public ProviderState getProviderState() {
		return providerState;
	}

	public void setProviderState(ProviderState providerState) {
		this.providerState = providerState;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getHmoProvider() {
		return hmoProvider;
	}

	public void setHmoProvider(String hmoProvider) {
		this.hmoProvider = hmoProvider;
	}

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", subsriptionDate=" + subsriptionDate + ", unsubscriptionDate=" + unsubscriptionDate + ", firstName=" + firstName + ", lastName=" + lastName + ", service=" + service + ", numberOfBranches=" + numberOfBranches
				+ ", providerEmail=" + providerEmail + ", providerState=" + providerState + ", category=" + category + ", subCategory=" + subCategory + ", hmoProvider=" + hmoProvider + "]";
	}

}
