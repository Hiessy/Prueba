package com.web.application.model.google.dto;

public class Viewport {
	private Location northeast;
	private Location southwest;
	public Location getNortheast() {
		return northeast;
	}
	public void setNortheast(Location northeast) {
		this.northeast = northeast;
	}
	public Location getSouthwest() {
		return southwest;
	}
	public void setSouthwest(Location southwest) {
		this.southwest = southwest;
	}
	@Override
	public String toString() {
		return "Viewport [northeast=" + northeast + ", southwest=" + southwest + "]";
	}
	
	
}
