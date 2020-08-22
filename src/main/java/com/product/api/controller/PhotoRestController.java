package com.product.api.controller;

import com.product.api.model.Photo;
import com.product.api.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RequestMapping
public class PhotoRestController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title,
                           @RequestParam("image") MultipartFile image, Model model)
            throws IOException {
        String id = photoService.addPhoto(title, image);
        return id;
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable Long id, Model model) {
        Photo photo = photoService.getPhoto(id);
        return photo;

    }
}
