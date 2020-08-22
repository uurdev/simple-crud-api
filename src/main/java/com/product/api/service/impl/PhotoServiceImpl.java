package com.product.api.service.impl;

import com.product.api.model.Photo;
import com.product.api.repository.PhotoRepository;
import com.product.api.service.PhotoService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public String addPhoto(String photoTitle, MultipartFile multipartFile) throws IOException {

        Photo tempPhoto=new Photo();
        tempPhoto.setPhotoTitle(photoTitle);
        tempPhoto.setImage(new Binary(BsonBinarySubType.BINARY,multipartFile.getBytes()));
        tempPhoto=photoRepository.insert(tempPhoto);
        return tempPhoto.getPhotoId().toString();

    }

    @Override
    public Photo getPhoto(Long photoId) {
        return photoRepository.findById(photoId).get();
    }
}
