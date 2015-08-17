package com.example.battleships.command;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.Parser;
import com.example.battleships.utils.gridAlocation.Position;
import com.example.battleships.view.BoardView;
import com.example.battleships.view.GameBoardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.ParseException;

public class CommandShoot extends AbstractCommand {

  public static final String NAME = "commandShoot";

  @Autowired
  private GridBoard gridBoard;

  @Autowired
  @Qualifier(value = GameBoardView.NAME)
  private BoardView gameBoardView;

  @Autowired
  private Parser coordinatesParser;

  @Override
  public void execute(String commandString) throws ParseException {
      Position position = coordinatesParser.parse(commandString);
      gridBoard.tryShot(position);
      gameBoardView.drawBoard();
  }
}
