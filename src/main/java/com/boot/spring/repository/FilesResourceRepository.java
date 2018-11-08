package com.boot.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.spring.model.FileResource;

@Repository
public interface FilesResourceRepository extends CrudRepository<FileResource, String> {
	List<FileResource> findByResourceId(String resourceId);
}
