package com.example.battleships.utils.gridAllocation;

import static com.example.battleships.utils.BattleshipConstants.BOARD_SIZE_TO_COORDINATES_INDEX;

/**
 * Allocate space vertically
 */
public class VerticalAllocator extends BoardGridAllocator {

  public static final String NAME = "verticalAllocator";

  /**
   * {@inheritDoc}
   */
  @Override
  protected void placeShip(Position position) {
    int stern = getStern(position);
    for (int newRowPosition = position.getRow(); newRowPosition <= stern; newRowPosition++) {
      Position newShipPosition = generatePosition(newRowPosition, position.getColumn());
      gridBoard.placeShipField(newShipPosition);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected int getStern(Position position) {
    return position.getRow() + ship.getSize() - BOARD_SIZE_TO_COORDINATES_INDEX;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean traverseGridBoard(Position position, int stern) {
    boolean availableSpace = true;
    for (int newRowPosition = position.getRow(); newRowPosition <= stern; newRowPosition++) {
      if (!gridBoard.isEmpty(generatePosition(newRowPosition, position.getColumn()))) {
        availableSpace = false;
        break;
      }
    }
    return availableSpace;
  }
}
