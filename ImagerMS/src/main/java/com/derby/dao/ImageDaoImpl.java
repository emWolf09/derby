package com.derby.dao;

import com.derby.entity.ImageEntity;
import com.derby.model.ImageDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("imageDao")
public class ImageDaoImpl implements ImageDao{

    @Autowired
    @Qualifier("mapper")
    Mapper mapper;

    @Autowired
    ImageDaoRepo imageDaoRepo;

    @Override
    public ImageDTO getImageByUserId(Integer id) throws Exception {
        Optional<ImageEntity> imageEntity = imageDaoRepo.findByUserId(id);
        ImageDTO imageDTO = new ImageDTO();
        imageEntity.ifPresent(entity -> mapper.map(entity, imageDTO));
        return imageDTO;
    }

    @Override
    public Integer uploadImage(ImageDTO imageDTO) throws Exception {
        ImageEntity imageEntity = mapper.map(imageDTO, ImageEntity.class);
        imageEntity = imageDaoRepo.save(imageEntity);
        return imageEntity.getId();
    }

    @Override
    public Integer deleteImageByUserId(Integer userId) throws Exception {
        long deletedRows = imageDaoRepo.deleteByUserId(userId);
        return  userId;
    }
}
