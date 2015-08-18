package com.example.battleships.model.board;

import com.example.battleships.utils.gridAllocation.Position;
import lombok.Getter;

import static com.example.battleships.model.board.BoardFieldStatus.HIT;
import static com.example.battleships.model.board.BoardFieldStatus.MISSED;
import static com.example.battleships.model.board.BoardFieldStatus.SHIP;

/**
 * Represent matrix of the battleship board
 */
public class GridBoard {

  public static final int BOARD_CAPACITY = 10;
  @Getter
  private static int hitShipsCounter;
  @Getter
  private static int allShotsCounter;

  @Getter
  private BoardField[][] grid = new BoardField[BOARD_CAPACITY][BOARD_CAPACITY];


  /**
   * Place ship to the grid
   *
   * @param position
   */
  public void placeShipField(Position position) {
    grid[position.getRow()][position.getColumn()] = BoardField.create(SHIP);
  }

  /**
   * Hit field on the grid board
   *
   * @param position
   * @return Updated field
   */
  public BoardField hitBoard(Position position) {
    BoardField field = grid[position.getRow()][position.getColumn()];
    hitField(field, position);

    return field;
  }

  private void hitField(BoardField field, Position position) {
    int row = position.getRow();
    int column = position.getColumn();
    if (field == null) {
      hitEmptyField(row, column);
    } else if (SHIP.equals(field.getValue()) && !field.isHit()) {
      hitShipField(row, column);
    } else if (field.isHit()) {
      System.out.println("This field is already hit!");
    }
  }

  private void hitShipField(int row, int column) {
    grid[row][column] = BoardField.create(HIT, true);
    System.out.println("HIT!");
    hitShipsCounter++;
    allShotsCounter++;
  }

  private void hitEmptyField(int row, int column) {
    grid[row][column] = BoardField.create(MISSED, true);
    System.out.println("MISSED!");
    allShotsCounter++;
  }

  public boolean isEmpty(Position position) {
    return grid[position.getRow()][position.getColumn()] == null;
  }

}
