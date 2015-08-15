package com.example.battleships.view;

import com.example.battleships.model.BoardFieldStatus;
import com.example.battleships.model.BoardGameModel;

public class BoardView {

  private BoardGameModel boardGameModel;

  public BoardView(BoardGameModel gameModel) {
    this.boardGameModel = gameModel;
  }

  public void draw() {
    BoardFieldStatus fields[][] = boardGameModel.getBoardGrid();
    for (BoardFieldStatus[] row : fields) {
      for (BoardFieldStatus cell : row) {
        System.out.println(cell.toString());
      }
    }
  }
}
