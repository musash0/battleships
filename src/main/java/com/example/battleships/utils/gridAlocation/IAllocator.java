package com.example.battleships.utils.gridAlocation;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.model.ship.Ship;

public interface IAllocator {

  void allocate(GridBoard grid, Ship ship);
}
