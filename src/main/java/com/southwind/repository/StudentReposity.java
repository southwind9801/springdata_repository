package com.southwind.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.southwind.entity.Student;

@Repository
public interface StudentReposity extends CrudRepository<Student, String>{
	public List<Student> findByName(String name);
    public List<Student> findByNameAndAge(String name,int age);
    public List<Student> findAll(Sort sort);
}