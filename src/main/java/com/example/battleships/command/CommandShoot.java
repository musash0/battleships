package com.example.battleships.command;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.gridAlocation.Position;
import com.example.battleships.view.BoardView;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandShoot extends AbstractCommand {

  @Autowired
  private GridBoard gridBoard;

  @Autowired
  private BoardView boardView;

  @Override
  public void execute(String commandString) {
    if (Commands.SHOOT.getCommand() != commandString) {

      char row = commandString.charAt(0);
      String column = null;
      if (commandString.length() == 3) {
        column = commandString.substring(1, 2);
      } else if (commandString.length() == 3) {
        column = commandString.substring(1);
      }
      int columnInt = Integer.valueOf(column);

      Position position = Position.createPosition(row, columnInt);
      gridBoard.tryShot(position);
    }
    boardView.draw();

  }
}
