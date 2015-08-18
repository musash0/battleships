package com.example.battleships.model.grid;

import com.example.battleships.utils.gridAllocation.Position;
import lombok.Getter;

import static com.example.battleships.model.grid.FieldStatus.HIT;
import static com.example.battleships.model.grid.FieldStatus.MISSED;
import static com.example.battleships.model.grid.FieldStatus.SHIP;

/**
 * Represent matrix of the battleship grid
 */
public class Grid {

  public static final int GRID_CAPACITY = 10;
  @Getter
  private static int hitShipsCounter;
  @Getter
  private static int allShotsCounter;

  @Getter
  private Field[][] grid = new Field[GRID_CAPACITY][GRID_CAPACITY];

  /**
   * Place ship to the grid
   *
   * @param position
   */
  public void placeShip(Position position) {
    grid[position.getRow()][position.getColumn()] = Field.create(SHIP);
  }

  /**
   * Hit field on the grid
   *
   * @param position
   * @return Updated field
   */
  public Field hit(Position position) {
    Field field = grid[position.getRow()][position.getColumn()];
    checkFieldForHit(field, position);

    return field;
  }

  private void checkFieldForHit(Field field, Position position) {
    int row = position.getRow();
    int column = position.getColumn();
    if (field == null) {
      markFieldAsMissed(row, column);
    } else if (SHIP.equals(field.getStatus()) && !field.isHit()) {
      markShipAsHit(row, column);
    } else if (field.isHit()) {
      System.out.println("This field is already hit!");
    }
  }

  private void markShipAsHit(int row, int column) {
    grid[row][column] = Field.create(HIT, true);
    System.out.println("HIT!");
    hitShipsCounter++;
    allShotsCounter++;
  }

  private void markFieldAsMissed(int row, int column) {
    grid[row][column] = Field.create(MISSED, true);
    System.out.println("MISSED!");
    allShotsCounter++;
  }

  public boolean isEmpty(Position position) {
    return grid[position.getRow()][position.getColumn()] == null;
  }

}
