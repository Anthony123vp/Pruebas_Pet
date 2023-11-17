package com.tecsup.petclinic.controller;

import com.tecsup.petclinic.entities.Specialty;
import com.tecsup.petclinic.exception.ElementExistsException;
import com.tecsup.petclinic.services.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class SpecialtyController {

   private final SpecialityService specialityService;

   @PutMapping("specialty/{id}")
   public ResponseEntity<?> update(@Param("id") Integer id, @RequestBody Specialty specialty){
      try {
         return new ResponseEntity<>(
             specialityService.update(id, specialty),
             HttpStatus.OK
         );
      } catch (ElementExistsException e) {
         return new ResponseEntity<>(
             e.getMessage(),
             HttpStatus.METHOD_NOT_ALLOWED
         );
      }
   }
}
