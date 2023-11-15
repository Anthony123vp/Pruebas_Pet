package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exception.ElementExistsException;

public interface ISpecialityService {
   Specialty update(Integer id, Specialty specialty) throws ElementExistsException;
}
