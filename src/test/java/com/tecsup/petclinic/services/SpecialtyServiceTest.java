package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.ElementExistsException;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SpecialtyServiceTest {

	@Autowired
	private SpecialityService specialityService;

	@Test
	public void testSaveSpeciality() {
		Speciality speciality = new Speciality("TestName", "TestOffice", 9, 17);

		Speciality savedSpeciality = specialityService.save(speciality);

		log.info("Speciality Saved: " + savedSpeciality.toString());

		assertNotNull(savedSpeciality.getId());
		assertEquals("TestName", savedSpeciality.getName());
		assertEquals("TestOffice", savedSpeciality.getOffice());
		assertEquals(9, savedSpeciality.getH_open());
		assertEquals(17, savedSpeciality.getH_close());
	}

	@Test
	public void testFindSpeciality() throws SpecialityNotFoundException {
		Speciality savedSpeciality = specialityService.save(new Speciality("FindTest", "FindOffice", 8, 16));

		Speciality foundSpeciality = specialityService.find(savedSpeciality.getId());

		log.info("Speciality Found: " + foundSpeciality.toString());

		assertNotNull(foundSpeciality);
		assertEquals(savedSpeciality.getId(), foundSpeciality.getId());
		assertEquals("FindTest", foundSpeciality.getName());
		assertEquals("FindOffice", foundSpeciality.getOffice());
		assertEquals(8, foundSpeciality.getH_open());
		assertEquals(16, foundSpeciality.getH_close());
	}

	@Test
	public void testFindSpecialityNotFound() {
		assertThrows(SpecialityNotFoundException.class, () -> specialityService.find(-1));
	}

	@Test
	public void testDeleteSpeciality() {
		Speciality specialityToDelete = specialityService.save(new Speciality("DeleteTest", "DeleteOffice", 7, 15));

		specialityService.delete(specialityToDelete.getId());

		assertThrows(SpecialityNotFoundException.class, () -> specialityService.find(specialityToDelete.getId()));
	}

	@Test
	public void testUpdateSpeciality() throws ElementExistsException {
		Speciality originalSpeciality = specialityService.save(new Speciality("Original", "OriginalOffice", 9, 17));

		Speciality updatedSpeciality = new Speciality("Updated", "UpdatedOffice", 8, 16);
		Speciality result = specialityService.update(originalSpeciality.getId(), updatedSpeciality);

		log.info("Speciality Updated: " + result.toString());

		assertEquals(originalSpeciality.getId(), result.getId());
		assertEquals("Updated", result.getName());
		assertEquals("UpdatedOffice", result.getOffice());
		assertEquals(8, result.getH_open());
		assertEquals(16, result.getH_close());
	}
}
