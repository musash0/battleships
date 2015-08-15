package com.example.battleships.utils;

import com.example.battleships.NewPrintClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigUtil {

  @Bean
  NewPrintClass getNewPrintClass() {
    return new NewPrintClass();
  }
}
