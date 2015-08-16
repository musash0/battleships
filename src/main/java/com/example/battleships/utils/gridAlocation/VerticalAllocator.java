package com.example.battleships.utils.gridAlocation;

import com.example.battleships.model.board.BoardField;
import com.example.battleships.model.board.BoardFieldStatus;
import com.example.battleships.model.board.GridBoard;

public class VerticalAllocator extends BaseGridAllocator {

  public static final String NAME = "verticalAllocator";

  @Override
  protected void placeShip(Position position) {
    int stern = getStern(position);
    for (int newRowPosition = position.getRow(); newRowPosition <= stern; newRowPosition++) {
      Position newShipPosition = createNewRowPosition(position, newRowPosition);
      gridBoard.addBoardField(newShipPosition, BoardField.create(BoardFieldStatus.SHIP));
    }
  }

  @Override
  protected int getStern(Position position) {
    return position.getRow() + ship.getSize() - 1;
  }

  @Override
  protected boolean gridSpaceAvailable(Position position) {
    int stern = getStern(position);
    boolean availableSpace = false;
    if (stern < GridBoard.BOARD_CAPACITY - 1) {
      for (int newRowPosition = position.getRow(); newRowPosition <= stern; newRowPosition++) {
        Position newShipPosition = createNewRowPosition(position, newRowPosition);
        if (!gridBoard.isEmpty(newShipPosition)) {
          availableSpace = false;
          break;
        }
        availableSpace = true;
      }
    }
    return availableSpace;
  }

  private Position createNewRowPosition(Position position, int newRowPosition) {
    return Position.createPosition(newRowPosition, position.getColumn());
  }

}
