package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.studentmodel;
import com.example.project.service.service;
@CrossOrigin
@RestController
public class studentcontroller {
	@Autowired
	service s;

	@GetMapping("/get")
	public List<studentmodel> showDetails() {
		return s.getDetails();
	}

	@PostMapping("/p")
	public String addDetails(@RequestBody studentmodel m) {
		s.add(m);
		return "Added product " + m.getId();
	}

	//sorting
	@GetMapping("/product/{field}")
	public List<studentmodel> getWithSort(@PathVariable String field) {
		return s.getSorted(field);
	}
	
	@DeleteMapping("/deletemap/{id}")
	String deleteinfo(@PathVariable("id") int id) {
		s.deleteDetail(id);
		return "Deleted the element";
	}
	@PutMapping("/update")
	public studentmodel updateInfo(@RequestBody studentmodel m) {
	return s.updateDetails(m);
	}
	
	// pagination
	@GetMapping("/product/{offset}/{pageSize}")
	public List<studentmodel> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		return s.getWithPagination(offset, pageSize);
	}
}


