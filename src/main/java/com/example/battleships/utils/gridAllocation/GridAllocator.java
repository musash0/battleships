package com.example.battleships.utils.gridAllocation;

import com.example.battleships.model.grid.Grid;
import com.example.battleships.model.ship.Ship;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

import static com.example.battleships.model.grid.Grid.GRID_CAPACITY;

/**
 * {@inheritDoc}
 */
public abstract class GridAllocator implements IAllocator {

  @Autowired
  protected Grid grid;
  protected Ship ship;

  /**
   * {@inheritDoc}
   */
  @Override
  public void allocate(Ship ship) {
    this.ship = ship;
    Position position = createPosition();
    while (!gridSpaceAvailable(position)) {
      position = createPosition();
    }
    placeShip(position);
  }

  /**
   * Check for available space on grid
   */
  protected boolean gridSpaceAvailable(Position position) {
    int stern = getStern(position);
    boolean availableSpace = false;
    if (stern < GRID_CAPACITY) {
      availableSpace = traverseGrid(position, stern);
    }
    return availableSpace;
  }

  /**
   * Place ship at position
   */
  protected abstract void placeShip(Position position);

  /**
   * Get full size of the ship
   */
  protected abstract int getStern(Position position);

  /**
   * Traverse grid grid vertically or horizontally for available fields
   */
  protected abstract boolean traverseGrid(Position position, int stern);

  protected Position generatePosition(int row, int column) {
    return Position.createPosition(row, column);
  }

  protected int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(GRID_CAPACITY);
  }

  private Position createPosition() {
    int row = getRandomNumber();
    int column = getRandomNumber();
    return Position.createPosition(row, column);
  }
}
