package com.example.battleships.command;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.view.BoardView;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandShow extends AbstractCommand {

  public static final String NAME = "commandShow";

  @Autowired
  private BoardView boardView;

  @Override
  public void execute(String commandString) {
    boardView.drawShips();
  }
}
