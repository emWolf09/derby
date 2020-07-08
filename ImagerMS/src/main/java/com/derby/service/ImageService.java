package com.derby.service;

import com.derby.model.ImageDTO;

public interface ImageService {
    public ImageDTO getImageByUserId(Integer id) throws Exception;
    public Integer uploadImage(ImageDTO imageDTO)throws Exception;
    public Integer deleteImageByUserId(Integer userId) throws Exception;
}
