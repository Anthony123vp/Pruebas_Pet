package com.tecsup.petclinic.web;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.services.SpecialityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @PostMapping("/especialidad")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Speciality speciality)
    {
        Speciality specialitycreated = specialityService.save(speciality);

        return  ResponseEntity.status(HttpStatus.CREATED).body(specialitycreated);
    }

    @GetMapping("speciality/{id}")
    public  ResponseEntity<?> findOne(@PathVariable Integer id) {
        Speciality speciality;
        try {
            speciality = specialityService.find(id);
        } catch (SpecialityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
        return ResponseEntity.ok(speciality);

    }

    @DeleteMapping("speciality/{id}")
    public  void deleteOne(@PathVariable Integer id){
         specialityService.delete(id);
    }

}
