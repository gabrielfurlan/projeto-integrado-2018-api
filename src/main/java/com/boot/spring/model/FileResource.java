package com.boot.spring.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "files_resource")
public class FileResource {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "file")
	private String file;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "resource_id")
	private String resourceId;
	
	public static String idGenerator() {
		return UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
