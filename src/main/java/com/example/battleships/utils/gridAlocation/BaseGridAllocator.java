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

    Position position = getPosition();
    if (isEnoughGridSpace(position)) {
      placeShip(position);
    }
  }

  protected abstract void placeShip(Position position);


  public int getStern(Position position) {
    return position.getRow() + ship.getSize() - 1;
  }

  protected int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(GridBoard.BOARD_CAPACITY);
  }

  private boolean isEnoughGridSpace(Position position) {
    int stern = getStern(position);
    return stern < gridBoard.getGridBoard().length;
  }

  private Position getPosition() {
    int row = getRandomNumber();
    int column = getRandomNumber();
    return new Position(row, column);
  }
}
