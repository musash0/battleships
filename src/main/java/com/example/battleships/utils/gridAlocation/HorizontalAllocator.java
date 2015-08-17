package com.example.battleships.utils.gridAlocation;

import com.example.battleships.model.board.GridBoard;

/**
 * Allocate space horizontally
 */
public class HorizontalAllocator extends BoardGridAllocator {

  public static final String NAME = "horizontalAllocator";

  /**
   * {@inheritDoc}
   */
  @Override
  protected void placeShip(Position position) {
    int stern = getStern(position);
    for (int newColumnPosition = position.getColumn(); newColumnPosition <= stern; newColumnPosition++) {
      Position newShipPosition = createNewColumnPosition(position, newColumnPosition);
      gridBoard.placeShipField(newShipPosition);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected int getStern(Position position) {
    return position.getColumn() + ship.getSize() - 1;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean gridSpaceAvailable(Position position) {
    int stern = getStern(position);
    boolean availableSpace = false;
    if (stern < GridBoard.BOARD_CAPACITY - 1) {
      for (int newColumnPosition = position.getColumn(); newColumnPosition <= stern; newColumnPosition++) {
        Position newShipPosition = createNewColumnPosition(position, newColumnPosition);
        if (!gridBoard.isEmpty(newShipPosition)) {
          availableSpace = false;
          break;
        }
        availableSpace = true;
      }
    }
    return availableSpace;
  }

  private Position createNewColumnPosition(Position position, int newColumnPosition) {
    return Position.createPosition(position.getRow(), newColumnPosition);
  }
}
