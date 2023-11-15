package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Speciality;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class SpecialtyServiceTest {


	@Autowired
   private SpecialityService specilityService;


	@Test
	public void createNew() {

		String name = "Anthony";
		String office = "AG254";
		Integer f_open = 4;
		Integer f_close = 5;
		Speciality speciality = new Speciality(name,office,f_open,f_close);

		//Creando la especilidad mediante la interfaz service
		Speciality specialityCreated = specilityService.save(speciality);

		log.info("Speciality Created :" + specialityCreated.toString());

		assertNotNull(specialityCreated.getId());//Nos aseguramos que el id no sea nulo
		assertEquals(name,specialityCreated.getName());//Nos aseguramos que el nombre guardo sea igual al nombre registrado
		assertEquals(office,specialityCreated.getOffice());
		assertEquals(f_open,specialityCreated.getH_open());
		assertEquals(f_close,specialityCreated.getH_close());


	}
}
