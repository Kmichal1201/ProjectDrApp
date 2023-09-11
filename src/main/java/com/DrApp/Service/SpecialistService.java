package com.DrApp.Service;


import com.DrApp.Repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialistService {

    private SpecialistRepository specialistRepo;

    @Autowired
    public SpecialistService(SpecialistRepository specialistRepo) {
        this.specialistRepo = specialistRepo;
    }



}
