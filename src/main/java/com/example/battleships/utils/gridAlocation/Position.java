package com.example.battleships.utils.gridAlocation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {

  public static Position createPosition(int row, int column) {
    return new Position(row, column);
  }

  private int row;

  private int column;
}
