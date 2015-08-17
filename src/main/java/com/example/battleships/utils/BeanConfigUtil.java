package com.example.battleships.utils;

import com.example.battleships.command.*;
import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.gridAlocation.HorizontalAllocator;
import com.example.battleships.utils.gridAlocation.IAllocator;
import com.example.battleships.utils.gridAlocation.IShipGenerator;
import com.example.battleships.utils.gridAlocation.VerticalAllocator;
import com.example.battleships.view.BoardView;
import com.example.battleships.view.GameBoardView;
import com.example.battleships.view.ShipsView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigUtil {

  @Bean(name = "commandExecutor")
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
  public GridBoard getGridBoard() {
    return new GridBoard();
  }

  @Bean(name = GameBoardView.NAME)
  public BoardView getGameBoardView() {
    return new GameBoardView();
  }

  @Bean(name = ShipsView.NAME)
  public BoardView getShipsView() {
    return new ShipsView();
  }

  @Bean(name = CoordinatesValidator.NAME)
  public Validator getCoordinatesValidator() {
    return new CoordinatesValidator();
  }
}
