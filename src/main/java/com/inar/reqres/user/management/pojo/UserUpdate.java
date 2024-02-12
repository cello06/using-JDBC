package com.inar.reqres.user.management.pojo;

import java.time.ZonedDateTime;

public class UserUpdate {

	private String name;

	private String job;

	private ZonedDateTime updatedAt;

	public UserUpdate() {
	}

	public UserUpdate(String name, String job, ZonedDateTime updatedAt) {
		this.name = name;
		this.job = job;
		this.updatedAt = updatedAt;
	}

	public UserUpdate(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
