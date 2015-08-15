package com.example.battleships.utils;

import com.example.battleships.command.CommandExecutor;
import com.example.battleships.command.ICommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigUtil {

  @Bean(name = "commandExecutor")
  public ICommand getCommandExecutor() {
    return new CommandExecutor();
  }
}
