package com.example.battleships.utils.gridAllocation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Container for raw and column coordinates for grid
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

  private int row;
  private int column;

  public static Position createPosition(int row, int column) {
    return new Position(row, column);
  }

  public static Position createPosition() {
    return new Position();
  }
}
