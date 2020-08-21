package com.product.api.service;

import com.product.api.model.Photo;
import org.springframework.stereotype.Service;

@Service
public interface PhotoService {

    public Photo getPhoto(Long photoId);
}
