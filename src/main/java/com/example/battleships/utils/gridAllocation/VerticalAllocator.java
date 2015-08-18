package com.example.battleships.utils.gridAllocation;

import static com.example.battleships.utils.BattleshipConstants.GRID_SIZE_TO_COORDINATES_INDEX;

/**
 * Allocate space vertically
 */
public class VerticalAllocator extends GridAllocator {

  public static final String NAME = "verticalAllocator";

  /**
   * {@inheritDoc}
   */
  @Override
  protected void placeShip(Position position) {
    int stern = getStern(position);
    for (int newRowPosition = position.getRow(); newRowPosition <= stern; newRowPosition++) {
      Position newShipPosition = generatePosition(newRowPosition, position.getColumn());
      grid.placeShip(newShipPosition);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected int getStern(Position position) {
    return position.getRow() + ship.getSize() - GRID_SIZE_TO_COORDINATES_INDEX;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean traverseGrid(Position position, int stern) {
    boolean availableSpace = true;
    for (int newRowPosition = position.getRow(); newRowPosition <= stern; newRowPosition++) {
      if (!grid.isEmpty(generatePosition(newRowPosition, position.getColumn()))) {
        availableSpace = false;
        break;
      }
    }
    return availableSpace;
  }
}
