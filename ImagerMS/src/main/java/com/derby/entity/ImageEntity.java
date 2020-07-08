package com.derby.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profile_picture")
@Data
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "image_seq")
    @SequenceGenerator(sequenceName = "image_seq", allocationSize = 1, name = "image_seq")
    @Column(name="image_id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "created_on")
    private Date created_on;
}
