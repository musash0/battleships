package com.example.battleships.command;

import com.example.battleships.view.BoardView;
import com.example.battleships.view.ShipsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Shows ships on the board
 */
public class CommandShow implements ICommand {

  public static final String NAME = "commandShow";

  @Autowired
  @Qualifier(value = ShipsView.NAME)
  private BoardView shipsView;

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(String commandString) {
    shipsView.drawBoard();
  }
}
