package com.example.battleships.utils;

import com.example.battleships.command.CommandExecutor;
import com.example.battleships.command.CommandHelp;
import com.example.battleships.command.CommandQuit;
import com.example.battleships.command.CommandShoot;
import com.example.battleships.command.CommandShow;
import com.example.battleships.command.ICommand;
import com.example.battleships.model.grid.Grid;
import com.example.battleships.utils.gridAllocation.HorizontalAllocator;
import com.example.battleships.utils.gridAllocation.IAllocator;
import com.example.battleships.utils.gridAllocation.VerticalAllocator;
import com.example.battleships.utils.shipGenerator.IShipGenerator;
import com.example.battleships.utils.shipGenerator.ShipGenerator;
import com.example.battleships.view.GameView;
import com.example.battleships.view.GridView;
import com.example.battleships.view.ShipsView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigUtil {

  @Bean(name = CommandExecutor.NAME)
  public ICommand getCommandExecutor() {
    return new CommandExecutor();
  }

  @Bean(name = CommandShoot.NAME)
  public ICommand getCommandShoot() {
    return new CommandShoot();
  }

  @Bean(name = CommandHelp.NAME)
  public ICommand getCommandHelp() {
    return new CommandHelp();
  }

  @Bean(name = CommandQuit.NAME)
  public ICommand getCommandQuit() {
    return new CommandQuit();
  }

  @Bean(name = CommandShow.NAME)
  public ICommand getCommandShow() {
    return new CommandShow();
  }

  @Bean(name = HorizontalAllocator.NAME)
  public IAllocator getVerticalAllocator() {
    return new HorizontalAllocator();
  }

  @Bean(name = VerticalAllocator.NAME)
  public IAllocator getHorizontalAllocator() {
    return new VerticalAllocator();
  }

  @Bean(name = ShipGenerator.NAME)
  public IShipGenerator getShipGenerator() {
    return new ShipGenerator();
  }

  @Bean
  public Grid getGrid() {
    return new Grid();
  }

  @Bean(name = GridView.NAME)
  public GameView getGridView() {
    return new GridView();
  }

  @Bean(name = ShipsView.NAME)
  public GameView getShipsView() {
    return new ShipsView();
  }

  @Bean(name = CoordinatesParser.NAME)
  public Parser getCoordinatesParser() {
    return new CoordinatesParser();
  }

}
