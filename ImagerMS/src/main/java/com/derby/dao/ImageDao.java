package com.derby.dao;

import com.derby.model.ImageDTO;


public interface ImageDao {
    public ImageDTO getImageByUserId(Integer id) throws Exception;
    public Integer uploadImage(ImageDTO imageDTO)throws Exception;
    public Integer deleteImageByUserId(Integer userId) throws Exception;
}
