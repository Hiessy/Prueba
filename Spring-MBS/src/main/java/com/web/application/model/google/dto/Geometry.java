package com.web.application.model.google.dto;

public class Geometry {
	
	private Bounds bounds;
	private Location location;
	private String location_type;
	private Viewport viewport;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLocation_type() {
		return location_type;
	}

	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	public Bounds getBounds() {
		return bounds;
	}

	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}

	@Override
	public String toString() {
		return "Geometry [bounds=" + bounds + ", location=" + location + ", location_type=" + location_type + ", viewport=" + viewport + "]";
	}


}
