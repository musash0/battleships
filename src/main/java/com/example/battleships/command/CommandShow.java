package com.example.battleships.command;

import com.example.battleships.view.GameView;
import com.example.battleships.view.ShipsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Shows ships on the grid
 */
public class CommandShow implements ICommand {

  public static final String NAME = "commandShow";

  @Autowired
  @Qualifier(value = ShipsView.NAME)
  private GameView shipsView;

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(String commandString) {
    shipsView.draw();
  }
}
