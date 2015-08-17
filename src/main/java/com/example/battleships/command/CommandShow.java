package com.example.battleships.command;

import com.example.battleships.view.BoardView;
import com.example.battleships.view.ShipsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CommandShow extends AbstractCommand {

  public static final String NAME = "commandShow";

  @Autowired
  @Qualifier(value = ShipsView.NAME)
  private BoardView shipsView;

  @Override
  public void execute(String commandString) {
    shipsView.drawBoard();
  }
}
