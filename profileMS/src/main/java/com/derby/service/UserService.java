package com.derby.service;

import java.util.List;

import com.derby.model.User;

public interface UserService {
	public User getUserById(Integer id)throws Exception;
	public Integer register(User user)throws Exception;
	public Integer update(User user)throws Exception;
	public Integer delete(User user)throws Exception;
	public List<User> searchByName(String name,int page,int count)throws Exception;
}
