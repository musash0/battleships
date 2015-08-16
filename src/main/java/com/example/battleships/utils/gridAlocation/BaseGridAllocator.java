package com.example.battleships.utils.gridAlocation;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.model.ship.Ship;

import java.util.Random;

public abstract class BaseGridAllocator implements IAllocator {

  protected GridBoard gridBoard;
  protected Ship ship;

  @Override
  public void allocate(GridBoard grid, Ship ship) {
    this.gridBoard = grid;
    this.ship = ship;

    Position position = createPosition();
    while (!gridSpaceAvailable(position)) {
      position = createPosition();
      System.out.println("recalculating");
    }
    placeShip(position);
  }

  protected abstract void placeShip(Position position);

  protected abstract int getStern(Position position);

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
