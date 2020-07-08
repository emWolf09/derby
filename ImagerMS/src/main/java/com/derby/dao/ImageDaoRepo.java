package com.derby.dao;

import com.derby.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ImageDaoRepo extends JpaRepository<ImageEntity,Integer> {
    Optional<ImageEntity> findByUserId(Integer userId);

    long deleteByUserId(Integer userId);
}
