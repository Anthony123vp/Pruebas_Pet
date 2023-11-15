package com.tecsup.petclinic.config;

import com.tecsup.petclinic.repositories.SpecialityRepository;
import com.tecsup.petclinic.services.ISpecialityService;
import com.tecsup.petclinic.services.SpecialtyImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

   private SpecialityRepository specialityRepository;

   @Bean
   public SpecialtyImplService specialityService() {
      return new SpecialtyImplService(specialityRepository);
   }

}
