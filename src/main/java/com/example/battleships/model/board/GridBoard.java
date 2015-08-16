package com.example.battleships.model.board;

import com.example.battleships.utils.gridAlocation.Position;
import lombok.Getter;

public class GridBoard {
  public static final int BOARD_CAPACITY = 10;

  @Getter
  private BoardField[][] grid = new BoardField[BOARD_CAPACITY][BOARD_CAPACITY];


  public void addBoardField(Position position, BoardField boardField) {
    System.out.println("row" + position.getRow() + ",column" + position.getColumn());
    grid[position.getRow()][position.getColumn()] = boardField;
  }

  public BoardField tryShot(Position position) {
    BoardField field = grid[position.getRow()][position.getColumn()];
    if (field == null) {
      field = BoardField.MISSED;
    } else if (BoardField.SHIP.equals(field)) {
      field = BoardField.HIT;
    }

    return field;
  }

  public boolean isEmpty(Position position) {
    return grid[position.getRow()][position.getColumn()] == null;
  }

  public BoardField getField(Position position) {
    return grid[position.getRow()][position.getColumn()];
  }
}
