package com.derby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.derby.dao.UserDao;
import com.derby.model.User;

import javax.transaction.Transactional;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	//TODO : Log apply
	//TODO : validation apply

	@Override
	@Cacheable(value = "userCacheById",key = "#id")
	public User getUserById(Integer id) throws Exception {
		return userDao.getUserById(id);
	}

	@Override
	public Integer register(User user) throws Exception{
		return userDao.register(user);
	}

	@Override
	@CacheEvict(value = "userCacheById", key = "#user.id")
	public Integer update(User user) throws Exception{
		return userDao.update(user);
	}

	@Override
	@CacheEvict(value = "userCacheById", key = "#user.id")
	public Integer delete(User user) throws Exception{
		return userDao.delete(user);
	}

	@Override
	public List<User> searchByName(String name, int page, int count) throws Exception{
		return userDao.searchByName(name, page, count);
	}

}
