package com.derby.service;

import com.derby.dao.ImageDao;
import com.derby.model.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service(value = "imageService")
@Transactional
public class ImageServiceImpl implements ImageService{

    @Autowired
    @Qualifier("imageDao")
    ImageDao imageDao;

    @Override
    public ImageDTO getImageByUserId(Integer id) throws Exception {
        return imageDao.getImageByUserId(id);
    }

    @Override
    public Integer uploadImage(ImageDTO imageDTO) throws Exception {
        return imageDao.uploadImage(imageDTO);
    }

    @Override
    public Integer deleteImageByUserId(Integer userId) throws Exception {
        return imageDao.deleteImageByUserId(userId);
    }
}
