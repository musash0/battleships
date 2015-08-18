package com.example.battleships.command;

import com.example.battleships.model.grid.Grid;
import com.example.battleships.utils.Parser;
import com.example.battleships.utils.gridAllocation.Position;
import com.example.battleships.view.GameView;
import com.example.battleships.view.GridView;
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
  private Grid grid;

  @Autowired
  @Qualifier(value = GridView.NAME)
  private GameView gameGameView;

  @Autowired
  private Parser coordinatesParser;

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(String commandString) {
    try {
      Position position = coordinatesParser.parse(commandString);
      grid.hit(position);
      gameGameView.draw();
    } catch (ParseException e) {
      System.err.println(SYS_ERR_MSG_PREF + "Unexpected exception: " + e.getMessage());
    }
  }
}
