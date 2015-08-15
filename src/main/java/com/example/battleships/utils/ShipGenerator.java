package com.example.battleships.utils;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.model.ship.Ship;
import com.example.battleships.utils.gridAlocation.IAllocator;
import com.example.battleships.utils.gridAlocation.IShipGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class ShipGenerator implements IShipGenerator {

  public static final String NAME = "allocatorGenerator";

  @Autowired
  private IAllocator horizontalAllocator;

  @Autowired
  private IAllocator verticalAllocator;

  @Autowired
  private GridBoard gridBoard;

  public void generate(Ship ship) {
    getAllocator().allocate(gridBoard, ship);
  }

  private IAllocator getAllocator() {
    Random random = new Random();
    return random.nextBoolean() ? horizontalAllocator : verticalAllocator;
  }
}
