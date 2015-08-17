package com.example.battleships.command;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.Parser;
import com.example.battleships.utils.gridAlocation.Position;
import com.example.battleships.view.BoardView;
import com.example.battleships.view.GameBoardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.ParseException;

import static com.example.battleships.utils.BattleshipConstants.SYS_ERR_MSG_PREF;

/**
 * Try to hit a ship from the grid
 */
public class CommandShoot implements ICommand {

  public static final String NAME = "commandShoot";

  @Autowired
  private GridBoard gridBoard;

  @Autowired
  @Qualifier(value = GameBoardView.NAME)
  private BoardView gameBoardView;

  @Autowired
  private Parser coordinatesParser;

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(String commandString) {
    try {
      Position position = coordinatesParser.parse(commandString);
      gridBoard.hitBoard(position);
      gameBoardView.drawBoard();
    } catch (ParseException e) {
      System.err.println(SYS_ERR_MSG_PREF + "Unexpected exception: " + e.getMessage());
    }
  }
}
