package com.example.battleships.view;

import com.example.battleships.model.board.BoardField;
import com.example.battleships.model.board.GridBoard;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class BoardView {

  public static final String NAME = "boardView";

  @Autowired
  private GridBoard gridBoard;
//
//  public BoardView(GridBoard gameModel) {
//    this.gridBoard = gameModel;
//  }

  public void draw() {
    BoardField fields[][] = gridBoard.getGrid();
    System.out.println("   1   2   3   4   5   6   7   8   9   10");
    char asciiLetter = 65;
    for (BoardField[] row : fields) {
      System.out.print(asciiLetter++ + "  ");
      for (BoardField cell : row) {
        if (cell == null) {
          System.out.print(".   ");
        } else {
          System.out.print(cell.toString() + "   ");
        }
      }
      System.out.println("");
    }
  }
}
