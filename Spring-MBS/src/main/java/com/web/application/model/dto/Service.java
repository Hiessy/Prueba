package com.web.application.model.dto;

import java.util.List;

import com.web.application.model.enums.ServiceState;

public class Service {

	private Integer serviceId;// Id_Servicio Numerico Incremental
	private Integer branchId;// Id_Sucursal Numerico ID
	private String subCategory;// SubRubro Texto (Nombre de subrubro del
	private String serviceName;// Nombre_Servicio Texto
	private int duration;
	private ServiceState serviceState;// Estado_Servicio
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public ServiceState getServiceState() {
		return serviceState;
	}
	public void setServiceState(ServiceState serviceState) {
		this.serviceState = serviceState;
	}
	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", branchId=" + branchId + ", subCategory=" + subCategory + ", serviceName=" + serviceName + ", duration=" + duration + ", serviceState=" + serviceState + "]";
	}

	
	
}
