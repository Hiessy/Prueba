package com.web.appointment.test.model.alternative;

import java.util.Date;

import com.web.generic.model.enums.AppointmentState;
import com.web.generic.model.enums.ChannelType;

public class Appointment {

	private Integer appointmentId;// Id_Turno
	private Integer providerId;// Id_Proveedor
	private Integer branchId;// Id_Sucursal
	private Integer clienteId;// Id_Cliente
	private Integer scheduleId;// Id_Agenda // TODO No entiendo
	private Integer serviceId;// id_Servicio
	private Integer employeeId;// id_Empleado
	private Integer surveyId;// Id_Encuesta
	private Date reservationDate;// Fecha_ResTurno
	
	private Integer day;// Fecha_Turno
	private Integer month;// Fecha_Turno
	private Integer year;	// Fecha_Turno
	private Integer startTimeHour;// Fecha_Turno
	private Integer startTimeMinute;// Fecha_Turno
	private Integer endTimeHour;// Fecha_Turno
	private Integer endTimeMinute;// Fecha_Turno

	private AppointmentState appointmentState; // Estado_Turno	
	private Date customerConfirmationDate;// Confirmacion_Turno_Cli_Fecha
	private Date providerConfirmationDate;// Confirmacion_Turno_Prov_Fecha
	private ChannelType channelType;// Canal_Turno
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	public Integer getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getStartTimeHour() {
		return startTimeHour;
	}
	public void setStartTimeHour(Integer startTimeHour) {
		this.startTimeHour = startTimeHour;
	}
	public Integer getStartTimeMinute() {
		return startTimeMinute;
	}
	public void setStartTimeMinute(Integer startTimeMinute) {
		this.startTimeMinute = startTimeMinute;
	}
	public Integer getEndTimeHour() {
		return endTimeHour;
	}
	public void setEndTimeHour(Integer endTimeHour) {
		this.endTimeHour = endTimeHour;
	}
	public Integer getEndTimeMinute() {
		return endTimeMinute;
	}
	public void setEndTimeMinute(Integer endTimeMinute) {
		this.endTimeMinute = endTimeMinute;
	}
	public AppointmentState getAppointmentState() {
		return appointmentState;
	}
	public void setAppointmentState(AppointmentState appointmentState) {
		this.appointmentState = appointmentState;
	}
	public Date getCustomerConfirmationDate() {
		return customerConfirmationDate;
	}
	public void setCustomerConfirmationDate(Date customerConfirmationDate) {
		this.customerConfirmationDate = customerConfirmationDate;
	}
	public Date getProviderConfirmationDate() {
		return providerConfirmationDate;
	}
	public void setProviderConfirmationDate(Date providerConfirmationDate) {
		this.providerConfirmationDate = providerConfirmationDate;
	}
	public ChannelType getChannel() {
		return channelType;
	}
	public void setChannel(ChannelType channel) {
		this.channelType = channel;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", providerId=" + providerId + ", branchId=" + branchId + ", clienteId=" + clienteId + ", scheduleId=" + scheduleId + ", serviceId=" + serviceId + ", employeeId=" + employeeId + ", surveyId=" + surveyId
				+ ", reservationDate=" + reservationDate + ", day=" + day + ", month=" + month + ", year=" + year + ", startTimeHour=" + startTimeHour + ", startTimeMinute=" + startTimeMinute + ", endTimeHour=" + endTimeHour + ", endTimeMinute=" + endTimeMinute
				+ ", appointmentState=" + appointmentState + ", customerConfirmationDate=" + customerConfirmationDate + ", providerConfirmationDate=" + providerConfirmationDate + ", channel=" + channelType + "]";
	}	
	
}
