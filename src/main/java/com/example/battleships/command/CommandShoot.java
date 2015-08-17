package com.example.battleships.command;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.Validator;
import com.example.battleships.utils.gridAlocation.Position;
import com.example.battleships.view.BoardView;
import com.example.battleships.view.GameBoardView;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CommandShoot extends AbstractCommand {

  public static final String NAME = "commandShoot";

  @Autowired
  private GridBoard gridBoard;

  @Autowired
  @Qualifier(value = GameBoardView.NAME)
  private BoardView gameBoardView;

  @Autowired
  private Validator coordinatesValidator;

  @Override
  public void execute(String commandString) {
    if (coordinatesValidator.validate(commandString)) {

      int row = commandString.toUpperCase().charAt(0) - 65;
      int columnInt = Integer.valueOf(StringUtils.substring(commandString, 1)) - 1;

      Position position = Position.createPosition(row, columnInt);
      gridBoard.tryShot(position);
    } else {
      System.out.println("Input is not valid!");
    }
    gameBoardView.drawBoard();
  }
}
