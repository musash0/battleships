package com.example.battleships.view;

import com.example.battleships.model.board.BoardField;
import com.example.battleships.model.board.GridBoard;

public class BoardView {

  private GridBoard gridBoard;

  public BoardView(GridBoard gameModel) {
    this.gridBoard = gameModel;
  }

  public void draw() {
    BoardField fields[][] = gridBoard.getGridBoard();
    for (BoardField[] row : fields) {
      for (BoardField cell : row) {
        System.out.println(cell.toString());
      }
    }
  }
}
