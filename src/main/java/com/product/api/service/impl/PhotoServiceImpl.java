package com.product.api.service.impl;

import com.product.api.model.Photo;
import com.product.api.repository.PhotoRepository;
import com.product.api.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Photo getPhoto(Long photoId) {
        return photoRepository.findById(photoId).get();
    }
}
