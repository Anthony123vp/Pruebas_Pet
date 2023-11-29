package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.ElementExistsException;
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

    @Override
    public Speciality update(Integer id, Speciality specialty) throws ElementExistsException {
        Speciality specialtyFind = specialityRepository.findById(id)
                .orElseThrow(() -> new ElementExistsException("Speciality with id "+id+" exists already in DB"));
        specialtyFind.setName(specialty.getName());
        specialtyFind.setOffice(specialty.getOffice());
        specialtyFind.setH_open(specialty.getH_open());
        specialtyFind.setH_close(specialty.getH_close());

        return specialityRepository.save(specialtyFind);
    }
}

