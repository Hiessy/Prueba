package com.web.generic.model;

import com.web.generic.model.enums.ServiceState;

public class Service {

	private Integer serviceId;// Id_Servicio Numerico Incremental
	private Integer branchId;// Id_Sucursal Numerico ID
	private Integer scheduleId;// Id_Agenda Numerico ID
	private String serviceName;// Nombre_Servicio Texto
	private String serviceProviderName;// Nombre_Profecional Texto
	private ServiceState serviceState;// Estado_Servicio
										// "Numerico//	1-OK//	2-Baja"
	private Integer totalQuota;// Cantidad_Cupo Numerico
	private String subCategory;// SubRubro Texto (Nombre de subrubro del
								// servicio)

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

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public ServiceState getServiceState() {
		return serviceState;
	}

	public void setServiceState(ServiceState serviceState) {
		this.serviceState = serviceState;
	}

	public Integer getTotalQuota() {
		return totalQuota;
	}

	public void setTotalQuota(Integer totalQuota) {
		this.totalQuota = totalQuota;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", branchId=" + branchId + ", scheduleId=" + scheduleId + ", serviceName=" + serviceName + ", serviceProviderName=" + serviceProviderName + ", serviceState=" + serviceState + ", totalQuota=" + totalQuota + ", subCategory="
				+ subCategory + "]";
	}

}
