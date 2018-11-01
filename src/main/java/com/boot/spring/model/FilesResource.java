			package com.boot.spring.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "files_resource")
public class FilesResource {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "resource_id")
	private String resourceId;
	
	@Column(name = "file")
	private Byte[] file;
	
	
	public static String idGenerator() {
		return UUID.randomUUID().toString();
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String ResourceId) {
		this.resourceId = resourceId;
	}

	public Byte[] getFile() {
		return file;
	}

	public void setFile(Byte[] file) {
		this.file = file;
	}

	public void setId(String id) {
		this.id = id;
	}
}
