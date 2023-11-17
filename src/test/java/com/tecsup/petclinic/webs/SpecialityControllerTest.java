package com.tecsup.petclinic.webs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.services.SpecialityService;
import com.tecsup.petclinic.web.SpecialityController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SpecialityController.class)
public class SpecialityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SpecialityService specialityService;

    @Test
    public void testCreateSpeciality() throws Exception {
        Speciality speciality = new Speciality();
        speciality.setName("Ejemplo");

        Mockito.when(specialityService.save(Mockito.any(Speciality.class)))
                .thenReturn(speciality);

        String specialityJson = objectMapper.writeValueAsString(speciality);

        mockMvc.perform(MockMvcRequestBuilders.post("/especialidad")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(specialityJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Ejemplo"));
    }

    @Test
    public void testFindOneSpeciality() throws Exception {
        Speciality speciality = new Speciality();
        speciality.setId(1);
        speciality.setName("Ejemplo");

        Mockito.when(specialityService.find(Mockito.anyInt()))
                .thenReturn(speciality);

        mockMvc.perform(MockMvcRequestBuilders.get("/speciality/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Ejemplo"));
    }

    @Test
    public void testFindOneSpecialityNotFound() throws Exception {
        Mockito.when(specialityService.find(Mockito.anyInt()))
                .thenThrow(new SpecialityNotFoundException("Speciality not found"));

        mockMvc.perform(MockMvcRequestBuilders.get("/speciality/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("Speciality not found"));
    }

    @Test
    public void testDeleteOneSpeciality() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/speciality/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // También puedes verificar que el método delete del servicio se haya llamado con el ID correcto
        Mockito.verify(specialityService, Mockito.times(1)).delete(1);
    }
}
