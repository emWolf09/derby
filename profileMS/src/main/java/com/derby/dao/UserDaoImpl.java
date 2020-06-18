package com.derby.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.derby.entity.UserEntity;
import com.derby.model.User;
import com.sun.istack.NotNull;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	Mapper mapper;
	
	@Autowired
	UserDaoRepo userDaoRepo;
	
	@Override
	public User getUserById(Integer id) {
		Optional<UserEntity> userEntity  = userDaoRepo.findById(id);
		User user=null;
		if(userEntity.isPresent())user = mapper.map(userEntity, User.class);
		return user;
	}

	@Override
	public Integer register(@NotNull User user) {
		UserEntity userEntity = mapper.map(user, UserEntity.class);
		userEntity = userDaoRepo.save(userEntity);
		return userEntity.getId();
	}

	@Override
	public Integer update(User user) {
		return user.getId();
	}

	@Override
	public Integer delete(@NotNull User user) {
		userDaoRepo.deleteById(user.getId());
		return user.getId();
	}

	@Override
	public List<User> searchByName(String name,int page,int size) {
		Pageable pageable = PageRequest.of(page, size);
		List<UserEntity> userEntities=  userDaoRepo.findByPlaceContaining(name, pageable);
		return userEntities.parallelStream().map(u->mapper.map(u, User.class)).collect(Collectors.toList());	
	}

}
