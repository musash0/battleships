package com.example.battleships.utils;

import com.example.battleships.command.CommandExecutor;
import com.example.battleships.command.ICommand;
import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.gridAlocation.VerticalAllocator;
import com.example.battleships.utils.gridAlocation.IAllocator;
import com.example.battleships.utils.gridAlocation.IShipGenerator;
import com.example.battleships.utils.gridAlocation.HorizontalAllocator;
import com.example.battleships.view.BoardView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigUtil {

  @Bean(name = "commandExecutor")
  public ICommand getCommandExecutor() {
    return new CommandExecutor();
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

  @Bean(name = BoardView.NAME)
  public BoardView getBoardView() {
    return new BoardView(getGridBoard());
  }
}
