package com.derby.dao;

import java.util.List;

import com.derby.model.User;



public interface UserDao{
	public User getUserById(Integer id) throws Exception;
	public Integer register(User user)throws Exception;
	public Integer update(User user) throws Exception;
	public Integer delete(User user) throws Exception;
	public List<User> searchByName(String name,int page,int count)throws Exception;

}
