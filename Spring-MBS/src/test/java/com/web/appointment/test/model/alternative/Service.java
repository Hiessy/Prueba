package com.web.appointment.test.model.alternative;

import java.util.List;

import com.web.generic.model.enums.ServiceState;

public class Service {

	private Integer serviceId;// Id_Servicio Numerico Incremental
	private Integer branchId;// Id_Sucursal Numerico ID
	private Integer scheduleId;// Id_Agenda Numerico ID
	private String serviceName;// Nombre_Servicio Texto
	private ServiceState serviceState;// Estado_Servicio
										// "Numerico//	1-OK//	2-Baja"
	private String subCategory;// SubRubro Texto (Nombre de subrubro del
								// servicio)
	private List<Provider> providers;
	private Integer duration;
	
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
	public ServiceState getServiceState() {
		return serviceState;
	}
	public void setServiceState(ServiceState serviceState) {
		this.serviceState = serviceState;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public List<Provider> getProviders() {
		return providers;
	}
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", branchId=" + branchId + ", scheduleId=" + scheduleId + ", serviceName=" + serviceName + ", serviceState=" + serviceState + ", subCategory=" + subCategory + ", providers=" + providers + ", duration=" + duration + "]";
	}	
	
}
