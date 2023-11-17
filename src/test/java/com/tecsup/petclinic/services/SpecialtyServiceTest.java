	package com.tecsup.petclinic.services;


	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.fail;

	import com.tecsup.petclinic.entities.Specialty;
	import com.tecsup.petclinic.exception.ElementExistsException;
	import org.junit.jupiter.api.Test;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

	import lombok.extern.slf4j.Slf4j;


	@SpringBootTest
	@Slf4j
	public class SpecialtyServiceTest {

		@Autowired
		private SpecialityService specialityService;

		/**
		 *
		 */
		@Test
		public void testUpdateSpecialityById() {


			String name = "Adrian";
			String office = "Back Developer";
			Integer h_open = 3;
			Integer h_close = 8;
			Specialty specialtyUpdate = null;

			try {

				specialtyUpdate = specialityService.update(2, new Specialty("Adrian","Back Developer", 3, 8));

			} catch (ElementExistsException e) {
				fail(e.getMessage());
			}
			log.info("" + specialtyUpdate);

			assertEquals(name, specialtyUpdate.getName());
			assertEquals(office, specialtyUpdate.getOffice());
			assertEquals(h_open, specialtyUpdate.getH_open());
			assertEquals(h_close, specialtyUpdate.getH_close());

		}

	}
