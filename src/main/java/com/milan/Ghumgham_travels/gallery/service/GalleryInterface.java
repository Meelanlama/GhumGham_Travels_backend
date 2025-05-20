package com.milan.Ghumgham_travels.gallery.service;

import com.milan.Ghumgham_travels.gallery.model.Gallery;

import java.util.List;

public interface GalleryInterface {

    Gallery saveGallery(Gallery gallery);

    List<Gallery> getALl();

    void deleteById(int id);
}
