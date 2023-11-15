package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exception.ElementExistsException;
import com.tecsup.petclinic.repositories.SpecialityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialtyImplService implements ISpecialityService{

   private final SpecialityRepository specialityRepository;

   @Override
   public Specialty update(Integer id, Specialty specialty) throws ElementExistsException {
      Specialty specialtyFind = specialityRepository.findById(id)
          .orElseThrow(() -> new ElementExistsException("Speciality with id "+id+" exists already in DB"));
      specialtyFind.setName(specialty.getName());
      specialtyFind.setOffice(specialty.getName());
      specialtyFind.setH_open(specialty.getH_open());
      specialtyFind.setH_close(specialty.getH_close());

      return specialityRepository.save(specialtyFind);
   }
}
