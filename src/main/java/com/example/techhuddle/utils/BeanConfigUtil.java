package com.example.techhuddle.utils;

import com.example.techhuddle.NewPrintClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigUtil {

  @Bean
  NewPrintClass getNewPrintClass() {
    return new NewPrintClass();
  }
}
