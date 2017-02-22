package com.web.generic.model;

import java.util.List;

import com.web.generic.model.enums.ProviderState;

public class Branch {

	private int branchId;// Id_Sucursal
	private int providerId;// Id_Proveedor
	private int telephone;// Telefono
	private Address address;
	private ProviderState branchState;// Estado_Sucursal
	private List<Service> services;
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ProviderState getBranchState() {
		return branchState;
	}
	public void setBranchState(ProviderState branchState) {
		this.branchState = branchState;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", providerId=" + providerId  + ", telephone=" + telephone + ", address=" + address + ", branchState=" + branchState + ", services=" + services + "]";
	}

}
