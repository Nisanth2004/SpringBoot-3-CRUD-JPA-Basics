package com.nisanth.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.nisanth.springboot.model.Student;

public interface UserDao extends CrudRepository<Student, Integer>{

}
