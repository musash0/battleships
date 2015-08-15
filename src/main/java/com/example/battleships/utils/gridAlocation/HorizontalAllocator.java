package com.example.battleships.utils.gridAlocation;

import com.example.battleships.model.board.BoardField;

public class HorizontalAllocator extends BaseGridAllocator {

  public static final String NAME = "horizontalAllocator";

  @Override
  protected void placeShip(Position position) {
    int stern = getStern(position);
    for (int i = position.getRow(); i < stern; i++) {
      gridBoard.addBoardField(position, BoardField.SHIP);
    }
  }

}
