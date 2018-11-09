package com.tedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.mapper.UserMapper;
import com.tedu.pojo.User;
import com.tedu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

	@Override
	public void insert(User user) {
		userMapper.insert(user);
		
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
		
	}

	@Override
	public void delete(Integer id) {
		userMapper.delete(id);
		
	}

}
