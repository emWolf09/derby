package com.derby.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.derby.entity.UserEntity;
import com.derby.model.User;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	@Qualifier("mapper")
	Mapper mapper;

	@Autowired
	UserDaoRepo userDaoRepo;
	
	@Override
	public User getUserById(Integer id) throws Exception{
		Optional<UserEntity> userEntity  = userDaoRepo.findById(id);
		User user=new User();
		if(userEntity.isPresent()){
			mapper.map(userEntity.get(),user);
			return user;
		}else return null;
	}

	@Override
	public Integer register( User user)throws Exception {
		UserEntity userEntity = mapper.map(user, UserEntity.class);
		userEntity = userDaoRepo.save(userEntity);
		return userEntity.getId();
	}

	@Override
	public Integer update(User user) throws Exception{
		return user.getId();
	}

	@Override
	public Integer delete( User user) throws Exception{
		userDaoRepo.deleteById(user.getId());
		return user.getId();
	}

	@Override
	public List<User> searchByName(String name,int page,int size) throws Exception{
		Pageable pageable = PageRequest.of(page, size);
		List<UserEntity> userEntities=  userDaoRepo.findByNameContaining(name, pageable);
		return userEntities.parallelStream().map(u->mapper.map(u, User.class)).collect(Collectors.toList());	
	}

}
