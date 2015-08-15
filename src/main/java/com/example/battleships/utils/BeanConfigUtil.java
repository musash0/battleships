package com.example.battleships.utils;

import com.example.battleships.command.CommandExecutor;
import com.example.battleships.command.ICommand;
import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.gridAlocation.HorizontalAllocator;
import com.example.battleships.utils.gridAlocation.IAllocator;
import com.example.battleships.utils.gridAlocation.IShipGenerator;
import com.example.battleships.utils.gridAlocation.VerticalAllocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigUtil {

  @Bean(name = "commandExecutor")
  public ICommand getCommandExecutor() {
    return new CommandExecutor();
  }

  @Bean(name = VerticalAllocator.NAME)
  public IAllocator getVerticalAllocator() {
    return new VerticalAllocator();
  }

  @Bean(name = HorizontalAllocator.NAME)
  public IAllocator getHorizontalAllocator() {
    return new HorizontalAllocator();
  }

  @Bean(name = ShipGenerator.NAME)
  public IShipGenerator getAllocatorGenerator() {
    return new ShipGenerator();
  }

  @Bean
  public GridBoard getGridBoard() {
    return new GridBoard();
  }
}
