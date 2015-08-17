package com.example.battleships.utils.gridAlocation;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.model.ship.Ship;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

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
   * Check for available space on gridBoard
   */
  protected abstract boolean gridSpaceAvailable(Position position);

  protected int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(GridBoard.BOARD_CAPACITY - 1);
  }

  private Position createPosition() {
    int row = getRandomNumber();
    int column = getRandomNumber();
    return Position.createPosition(row, column);
  }
}
