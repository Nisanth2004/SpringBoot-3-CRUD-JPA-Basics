package com.nisanth.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nisanth.springboot.dao.UserDao;
import com.nisanth.springboot.model.Student;

@Controller
public class UserController 
{
	@Autowired
	UserDao userDao;
 @GetMapping("index")
 public String user()
 {
	 return "index.jsp";
 }
 
 @GetMapping("addUser")
 public String addUser(Student student) // student obj is model 
 {
	 userDao.save(student);// db related methods
	 return "index.jsp";
 }
 
 @GetMapping("getUser")
 public ModelAndView getUser(@RequestParam int id) // student obj is model 
 {
	 ModelAndView modelAndView=new ModelAndView("showUser.jsp");
	Student student= userDao.findById(id).orElse(new Student());
	 modelAndView.addObject(student);// db related methods
	 return modelAndView;
 }
 
 @GetMapping("deleteUser")
 public ModelAndView deleteUser(@RequestParam int id) // student obj is model 
 {
	 ModelAndView modelAndView=new ModelAndView("deleteUser.jsp");
	Student student= userDao.findById(id).orElse(new Student());
	 userDao.deleteById(id);
	modelAndView.addObject(student);// db related methods
	 return modelAndView;
 }
 
 @GetMapping("updateUser")
 public ModelAndView updateUser(Student student) // take any details from the specified id user not only (id)
 {
	 ModelAndView modelAndView=new ModelAndView("updateUser.jsp");
	 student= userDao.findById(student.getId()).orElse(new Student());
	 userDao.deleteById(student.getId());
	modelAndView.addObject(student);// db related methods
	 return modelAndView;
 }
}
