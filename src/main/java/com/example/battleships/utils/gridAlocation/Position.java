package com.example.battleships.utils.gridAlocation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Container for raw and column coordinates for gridBoard
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

  public static Position createPosition(int row, int column) {
    return new Position(row, column);
  }

  public static Position createPosition() {
    return new Position();
  }

  private int row;

  private int column;
}
