package com.example.battleships.model.board;

import com.example.battleships.model.board.BoardField;
import com.example.battleships.utils.gridAlocation.Position;
import lombok.Getter;

public class GridBoard {
  public static final int BOARD_CAPACITY = 10;

  @Getter
  private BoardField[][] gridBoard = new BoardField[BOARD_CAPACITY][BOARD_CAPACITY];


  public void addBoardField(Position position, BoardField boardField) {
    gridBoard[position.getRow()][position.getColumn()] = boardField;
  }
}
