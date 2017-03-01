package com.web.appointment.test.model.alternative;

import java.util.Date;
import java.util.List;

import com.web.generic.model.enums.ProviderState;

public class Provider {

	private Integer providerId; //Id_Proveedor
	private Date latestUpdate; // Fecha_Alta
	private String providerName; // Nombre_Encargada
	private String providerEmail; // email TODO revisar si esto es necesario
	private String providerPassword; // Apellido_Encargada
	private List<Branch> branches; // Cantidad_Sucursales
	private String category; // Rubro
	private ProviderState providerState; // Estado_Proveedor {Ok - Bloqueado - baja}
	private String hmoProvider; // Obra social

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Date getLatesUpdate() {
		return latestUpdate;
	}

	public void setLatesUpdate(Date latestUpdate) {
		this.latestUpdate = latestUpdate;
	}

	public String getProviderPassword() {
		return providerPassword;
	}

	public void setProviderPassword(String providerPassword) {
		this.providerPassword = providerPassword;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
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

	public String getHmoProvider() {
		return hmoProvider;
	}

	public void setHmoProvider(String hmoProvider) {
		this.hmoProvider = hmoProvider;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", latestUpdate=" + latestUpdate + ", providerName=" + providerName + ", providerEmail=" + providerEmail + ", providerPassword=" + providerPassword + ", branches=" + branches + ", category=" + category
				+ ", providerState=" + providerState + ", hmoProvider=" + hmoProvider + "]";
	}

}
