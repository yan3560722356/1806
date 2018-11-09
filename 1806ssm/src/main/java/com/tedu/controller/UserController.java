package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.pojo.User;
import com.tedu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping("/insert/{name}/{birthday}/{address}")
	public String insert(User user){
		try {
			userService.insert(user);
			return "insert success";
		} catch (Exception e) {
			e.printStackTrace();
			return "insert error";
		}
	}
	
	@RequestMapping("/update/{name}/{birthday}/{address}/{id}")
	public String update(User user){
		try {
			userService.update(user);
			return"update success";
		} catch (Exception e) {
			e.printStackTrace();
			return "update error";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(Integer id){
		try {
			userService.delete(id);;
			return"delete success";
		} catch (Exception e) {
			e.printStackTrace();
			return "delete error";
		}
	}
}
