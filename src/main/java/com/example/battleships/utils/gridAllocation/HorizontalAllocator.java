package com.example.battleships.utils.gridAllocation;

import static com.example.battleships.utils.BattleshipConstants.GRID_SIZE_TO_COORDINATES_INDEX;

/**
 * Allocate space horizontally
 */
public class HorizontalAllocator extends GridAllocator {

  public static final String NAME = "horizontalAllocator";

  /**
   * {@inheritDoc}
   */
  @Override
  protected void placeShip(Position position) {
    int stern = getStern(position);
    for (int newColumnPosition = position.getColumn(); newColumnPosition <= stern; newColumnPosition++) {
      Position newShipPosition = generatePosition(position.getRow(), newColumnPosition);
      grid.placeShip(newShipPosition);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected int getStern(Position position) {
    return position.getColumn() + ship.getSize() - GRID_SIZE_TO_COORDINATES_INDEX;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean traverseGrid(Position position, int stern) {
    boolean availableSpace = true;
    for (int newColumnPosition = position.getColumn(); newColumnPosition <= stern; newColumnPosition++) {
      if (!grid.isEmpty(generatePosition(position.getRow(), newColumnPosition))) {
        availableSpace = false;
        break;
      }
    }
    return availableSpace;
  }
}
