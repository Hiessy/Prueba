package com.web.generic.model;

import com.web.generic.model.enums.ProviderState;
import com.web.generic.model.enums.BranchType;

public class Branch {

	private Integer branchId;// Id_Sucursal
	private Integer providerId;// Id_Proveedor
	private Integer managerId;// Responsable_Sucursal
	private Integer telephone;// Telefono
	private Address address;
	private String brachEmail;// Mail_sucursal
	private BranchType brachType;// Tipo_Sucursal (Propio o Franquicia)
	private ProviderState branchState;// Estado_Sucursal

	public Integer getBrachId() {
		return branchId;
	}

	public void setBrachId(Integer brachId) {
		this.branchId = brachId;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public String getBrachEmail() {
		return brachEmail;
	}

	public void setBrachEmail(String brachEmail) {
		this.brachEmail = brachEmail;
	}

	public BranchType getBrachType() {
		return brachType;
	}

	public void setBrachType(BranchType brachType) {
		this.brachType = brachType;
	}

	public ProviderState getBranchState() {
		return branchState;
	}

	public void setBranchState(ProviderState branchState) {
		this.branchState = branchState;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", providerId=" + providerId + ", managerId=" + managerId + ", telephone=" + telephone + ", address=" + address + ", brachEmail=" + brachEmail + ", brachType=" + brachType + ", branchState=" + branchState + "]";
	}

	
}
