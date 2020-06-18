package com.derby.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.derby.model.User;


@Repository(value = "userDao2")
public interface UserDao{
	public User getUserById(Integer id);
	public Integer register(User user);
	public Integer update(User user);
	public Integer delete(User user);
	public List<User> searchByName(String Name,int page,int count);

}
