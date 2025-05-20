package com.milan.Ghumgham_travels.guideline.service.impl;

import com.milan.Ghumgham_travels.guideline.model.entity.Guideline;
import com.milan.Ghumgham_travels.guideline.repository.GuidelineRepository;
import com.milan.Ghumgham_travels.guideline.service.GuidelineInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuidelineImpl implements GuidelineInterface {

    @Autowired
    GuidelineRepository repository;


    @Override
    public Guideline saveAbout(Guideline aboutUsManage){
        Guideline aboutUsManage1 = new Guideline();
        aboutUsManage1.setId(1);
        aboutUsManage1.setDescription(aboutUsManage.getDescription());
        return repository.save(aboutUsManage1);
    }

    @Override
    public Guideline getHotels(){
        return repository.findAll().get(0);
    }
}
