package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialityServiceImpl implements  SpecialityService{

    @Autowired
    private SpecialityRepository specialityRepository;
    @Override
    public Speciality save(Speciality speciality) {
        return  specialityRepository.save(speciality);
    }

    @Override
    public Speciality find(Integer id) throws SpecialityNotFoundException {
          Optional<Speciality> speciality = specialityRepository.findById(id);
        if(!speciality.isPresent()){
            throw new SpecialityNotFoundException("No se encontro la especialidad");
        }
        return speciality.get();
    }

    @Override
    public void delete(Integer id) {
        specialityRepository.deleteById(id);
    }
}
