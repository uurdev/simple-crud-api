package com.product.api.service;

import com.product.api.model.Photo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface PhotoService {

    public String addPhoto(String photoTitle, MultipartFile multipartFile) throws IOException;

    public Photo getPhoto(Long photoId);
}
