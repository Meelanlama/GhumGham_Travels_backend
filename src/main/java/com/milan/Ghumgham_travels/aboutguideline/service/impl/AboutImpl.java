package com.milan.Ghumgham_travels.aboutguideline.service.impl;

import com.milan.Ghumgham_travels.aboutguideline.model.entity.AboutUsManage;
import com.milan.Ghumgham_travels.aboutguideline.repository.AboutRepository;
import com.milan.Ghumgham_travels.aboutguideline.service.AboutInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutImpl implements AboutInterface {

    @Autowired
    AboutRepository repository;

    @Override
    public AboutUsManage saveAbout(AboutUsManage aboutUsManage){
        AboutUsManage aboutUsManage1 = new AboutUsManage();
        aboutUsManage1.setId(1);
        aboutUsManage1.setDescription(aboutUsManage.getDescription());
        return repository.save(aboutUsManage1);
    }

    @Override
    public AboutUsManage getHotels(){
        return repository.findAll().get(0);
    }
}
