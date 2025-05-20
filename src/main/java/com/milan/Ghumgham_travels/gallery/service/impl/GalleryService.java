package com.milan.Ghumgham_travels.gallery.service.impl;

import com.milan.Ghumgham_travels.gallery.model.Gallery;
import com.milan.Ghumgham_travels.gallery.repository.GalleryRepository;
import com.milan.Ghumgham_travels.gallery.service.GalleryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService implements GalleryInterface {

    @Autowired
    GalleryRepository repo;

    @Override
    public Gallery saveGallery(Gallery gallery){
        return repo.save(gallery);
    }

    @Override
    public List<Gallery> getALl(){
        return repo.findAll();
    }

    @Override
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
