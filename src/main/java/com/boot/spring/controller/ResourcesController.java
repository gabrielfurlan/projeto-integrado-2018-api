package com.boot.spring.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.model.FileResource;
import com.boot.spring.model.Resource;
import com.boot.spring.service.FilesResourceService;
import com.boot.spring.service.ResourcesService;
import com.boot.spring.utils.StatusUtil;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = { "http://localhost:8888" })
public class ResourcesController {
	
	@Autowired
	private ResourcesService service;
	
	@Autowired
	private FilesResourceService filesService;
	
	@PostMapping
	public @ResponseBody Response save(@RequestBody Resource body) {		
		body.setId(body.idGenerator());
		Resource resource = service.save(body);
		
		if(resource == null)
			return new Response(StatusUtil.NOT_FOUND, "Resource Not Found");
		
		return new Response<Resource>(StatusUtil.SUCCESS, resource);
	}
	
	@GetMapping("/{resourceId:.+}/files")
	public @ResponseBody List<FileResource> getFiles(@PathVariable @NotNull String resourceId) {
		return filesService.findByResourceId(resourceId); 
	}
	
	@PostMapping("/{resourceId}/files")
	public @ResponseBody Response saveFiles(@RequestBody FileResource body) {		
		body.setId(body.idGenerator());
		FileResource fileResource = filesService.save(body);
		
		if(fileResource == null)
			return new Response(StatusUtil.NOT_FOUND, "File Resource Not Found");
		
		return new Response<FileResource>(StatusUtil.SUCCESS, fileResource);
	}
	
	private class Response<Entity> {
		public int status;
		public String message;
		public Entity data;
		
		public Response(int status) {
			this.status = status;
		}
		
		public Response(int status, Entity data) {
			this.status = status;
			this.data = data;
		}
		
		public Response(int status, String message) {
			this.status= status;
			this.message = message;
		}
		
		public Response(int status, Entity data, String message) {
			this.status = status;
			this.data = data;
			this.message = message;
		}
	}
	
}
