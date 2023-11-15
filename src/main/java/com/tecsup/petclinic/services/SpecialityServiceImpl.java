package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl implements  SpecialityService{

    @Autowired
    private SpecialityRepository specialityRepository;
    @Override
    public Speciality save(Speciality speciality) {
        return  specialityRepository.save(speciality);
    }
}
