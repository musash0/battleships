package com.example.battleships.view;

import com.example.battleships.model.board.BoardField;
import com.example.battleships.model.board.BoardFieldStatus;
import com.example.battleships.model.board.GridBoard;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.battleships.model.board.BoardFieldStatus.*;

@AllArgsConstructor
public class BoardView {

  public static final String NAME = "boardView";
  private static final String OFFSET = "   ";

  @Autowired
  private GridBoard gridBoard;

  public void draw() {
    draw(false);
  }

  public void drawShips() {
    draw(true);
  }

  private void draw(boolean showShips) {
    BoardField fields[][] = gridBoard.getGrid();
    System.out.println("    1   2   3   4   5   6   7   8   9   10");
    char asciiLetter = 65;
    for (BoardField[] row : fields) {
      System.out.print(asciiLetter++ + OFFSET);
      for (BoardField cell : row) {
        drawBoard(cell, showShips);
      }
      System.out.println();
    }
  }

  private void drawBoard(BoardField cell, boolean showShips) {
    if (showShips) {
      if (cell != null && SHIP.equals(cell.getValue())) {
        System.out.print(HIT + OFFSET);
      } else if (cell != null && HIT.equals(cell.getValue())) {
        System.out.print(HIT + OFFSET);
      } else {
        System.out.print(EMPTY + OFFSET);
      }
    } else {
      if (cell == null) {
        System.out.print(DOT + OFFSET);
      } else if (SHIP.equals(cell.getValue()) && cell.isHit()) {
        System.out.print(HIT + OFFSET);
      } else if (SHIP.equals(cell.getValue())) {
        System.out.print(DOT + OFFSET);
      } else {
        System.out.print(cell.getValue() + OFFSET);
      }
    }
  }
}
