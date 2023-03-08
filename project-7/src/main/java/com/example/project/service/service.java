package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.project.model.studentmodel;
import com.example.project.repository.repository;


@Service

public class service {

		@Autowired
		repository r;
		
		public String add(studentmodel m) {
			r.save(m);
			return "Added";
		}
		
		public List<studentmodel> getDetails() {
			return r.findAll();
		}
		public studentmodel updateDetails(studentmodel e1) {
			return r.saveAndFlush(e1);
		}
		public void deleteDetail(int id) {
			r.deleteById(id);
		}
	public List<studentmodel> getSorted(String field) {
			return r.findAll(Sort.by(Sort.Direction.ASC,field));
		}
		public List<studentmodel> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
			Page<studentmodel> page =r.findAll(PageRequest.of(offset, pageSize));
			return page.getContent();
		}

}


	






