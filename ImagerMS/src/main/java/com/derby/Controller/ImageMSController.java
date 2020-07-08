package com.derby.Controller;

import com.derby.model.ImageDTO;
import com.derby.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@RestController
@RequestMapping(value = "/imageMS")
public class ImageMSController {
    @Autowired
    @Qualifier("imageService")
    ImageService imageService;

    @Value("${spring.servlet.multipart.location}")
    String fileBasePath;

    @PostMapping("/uploadProfilePicture/{userId}")
    public ResponseEntity<Integer> uploadToLocalFileSystem(@PathVariable Integer userId, @RequestParam("file") MultipartFile file) throws Exception{
        ImageDTO imageDTO = saveImageUtil(file,userId);
        Integer imageId = imageService.uploadImage(imageDTO);
        return new ResponseEntity<Integer>(imageId,HttpStatus.OK);
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<ImageDTO> getImageByUserId(@PathVariable Integer id) throws Exception{
        return new ResponseEntity<>(imageService.getImageByUserId(id),HttpStatus.OK);
    }

    private ImageDTO saveImageUtil(MultipartFile file,Integer userId) throws Exception{
        String finalFilePath = fileBasePath+userId.toString()+".PNG";
        finalFilePath = StringUtils.cleanPath(finalFilePath);
        Path path = Paths.get(finalFilePath);
        Files.write(path, file.getBytes());
        return new ImageDTO(userId,finalFilePath,new Date());
    }

}
