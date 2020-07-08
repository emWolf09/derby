package com.derby.dao;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derby.entity.UserEntity;

/**
 * @author MAHESH NAGARWAL
 *
 */
@Repository
public interface UserDaoRepo extends JpaRepository<UserEntity, Integer>{
	List<UserEntity> findByNameContaining(String name,Pageable pageable);
}
