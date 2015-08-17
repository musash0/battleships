package com.example.battleships.utils.shipGenerator;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.model.ship.Ship;
import com.example.battleships.utils.gridAlocation.IAllocator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.example.battleships.model.ship.Ship.createShip;

/**
 * {@inheritDoc}
 */
@Data
public class ShipGenerator implements IShipGenerator {

  public static final String NAME = "shipGenerator";

  @Autowired
  private IAllocator horizontalAllocator;

  @Autowired
  private IAllocator verticalAllocator;

  @Autowired
  private GridBoard gridBoard;

  private int destroyerSize = 4;

  private int battleshipSize = 5;

  /**
   * {@inheritDoc}
   */
  @Override
  public void generate() {
    List<Ship> ships = createShips();
    for (Ship ship : ships) {
      getAllocator().allocate(ship);
    }
  }

  private List<Ship> createShips() {
    Ship destroyer1 = createShip(destroyerSize);
    Ship destroyer2 = createShip(destroyerSize);
    Ship battleship = createShip(battleshipSize);

    return Arrays.asList(destroyer1, destroyer2, battleship);
  }

  private IAllocator getAllocator() {
    Random random = new Random();
    return random.nextBoolean() ? horizontalAllocator : verticalAllocator;
  }
}
