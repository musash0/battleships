package com.example.battleships.model.board;

import com.example.battleships.utils.gridAlocation.Position;
import lombok.Getter;

import static com.example.battleships.model.board.BoardFieldStatus.HIT;
import static com.example.battleships.model.board.BoardFieldStatus.MISSED;
import static com.example.battleships.model.board.BoardFieldStatus.SHIP;

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
    int row = position.getRow();
    int column = position.getColumn();
    if (field == null) {
      grid[row][column] = BoardField.create(MISSED, true);
    } else if (SHIP.equals(field.getValue())) {
      grid[row][column] = BoardField.create(HIT, true);
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
