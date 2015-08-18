package com.example.battleships.view;

import com.example.battleships.command.Commands;
import com.example.battleships.model.grid.Field;
import com.example.battleships.model.grid.Grid;
import com.example.battleships.utils.BattleshipConstants;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public abstract class GameView {

  protected static final String OFFSET = "  ";
  private static final String TITLE_NUMBERS = "   1  2  3  4  5  6  7  8  9  10";

  @Autowired
  protected Grid grid;

  public void draw() {
    drawDescription();
  }

  private void drawDescription() {
    Field fields[][] = grid.getGrid();
    System.out.println(TITLE_NUMBERS);
    char asciiLetter = BattleshipConstants.A_ASCII_CAPITAL_LETTER;
    for (Field[] row : fields) {
      System.out.print(asciiLetter++ + OFFSET);
      for (Field cell : row) {
        drawFieldCells(cell);
      }
      System.out.println();
    }
    System.out.println(Commands.SHOOT.getDescription());
  }

  protected abstract void drawFieldCells(Field cell);
}
