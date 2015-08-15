package com.example.battleships.utils.gridAlocation;

import com.example.battleships.model.board.BoardField;

public class VerticalAllocator extends BaseGridAllocator {

  public static final String NAME = "verticalAllocator";

  @Override
  protected void placeShip(Position position) {
    int stern = getStern(position);
    for (int i = position.getColumn(); i < stern; i++) {
      gridBoard.addBoardField(position, BoardField.SHIP);
    }
  }
}
