package com.boot.spring.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "time_logs")
public class Log {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "minutes")
	private String minutes;
	
	@Column(name = "observation")
	private String observation;
	
	@Column(name = "task_id")
	private String taskId;
	
	@Column(name = "created_at")
	private String createdAt;
	
	public static String idGenerator() {
		return UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
