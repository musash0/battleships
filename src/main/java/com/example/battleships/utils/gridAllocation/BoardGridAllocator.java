package com.example.battleships.utils.gridAllocation;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.model.ship.Ship;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

import static com.example.battleships.model.board.GridBoard.BOARD_CAPACITY;

/**
 * {@inheritDoc}
 */
public abstract class BoardGridAllocator implements IAllocator {

  @Autowired
  protected GridBoard gridBoard;
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
   * Place ship at position
   */
  protected abstract void placeShip(Position position);

  /**
   * Get full size of the ship
   */
  protected abstract int getStern(Position position);

  /**
   * Traverse grid board vertically or horizontally for available fields
   */
  protected abstract boolean traverseGridBoard(Position position, int stern);

  /**
   * Check for available space on gridBoard
   */
  protected boolean gridSpaceAvailable(Position position) {
    int stern = getStern(position);
    boolean availableSpace = false;
    if (stern < BOARD_CAPACITY) {
      availableSpace = traverseGridBoard(position, stern);
    }
    return availableSpace;
  }

  private Position createPosition() {
    int row = getRandomNumber();
    int column = getRandomNumber();
    return Position.createPosition(row, column);
  }

  protected Position generatePosition(int row, int column) {
    return Position.createPosition(row, column);
  }

  protected int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(BOARD_CAPACITY);
  }
}
