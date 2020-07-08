package com.derby.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class ImageDTO {
    private Integer id;
    private Integer userId;
    private String imagePath;
    private Date created_on;
    public ImageDTO(){
    }
    public ImageDTO(Integer userId, String imagePath, Date created_on) {
        this.userId = userId;
        this.imagePath = imagePath;
        this.created_on = created_on;
    }
}
