package com.example.battleships.command;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.gridAlocation.Position;
import com.example.battleships.view.BoardView;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandShoot extends AbstractCommand {

  public static final String NAME = "commandShoot";

  @Autowired
  private GridBoard gridBoard;

  @Autowired
  private BoardView boardView;

  @Override
  public void execute(String commandString) {
    if (Commands.SHOOT.getCommand() != commandString) {

      int row = commandString.toUpperCase().charAt(0) - 65;
      String column = null;
      if (commandString.length() == 3) {
        column = commandString.substring(1, 2);
      } else if (commandString.length() == 2) {
        column = commandString.substring(1);
      }
      int columnInt = Integer.valueOf(column) - 1;

      Position position = Position.createPosition(row, columnInt);
      gridBoard.tryShot(position);
    }
    boardView.draw();
  }
}
