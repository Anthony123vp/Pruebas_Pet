package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;

public interface SpecialityService {

    Speciality save (Speciality speciality);
    Speciality find(Integer id) throws SpecialityNotFoundException;

    void delete(Integer id);
}
