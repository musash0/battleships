package com.example.battleships.utils.shipGenerator;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.model.ship.Ship;
import com.example.battleships.utils.gridAllocation.IAllocator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.example.battleships.model.ship.Ship.createShip;
import static com.example.battleships.utils.BattleshipConstants.BATTLESHIP_SIZE;
import static com.example.battleships.utils.BattleshipConstants.DESTROYER_SIZE;

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
    Ship destroyer1 = createShip(DESTROYER_SIZE);
    Ship destroyer2 = createShip(DESTROYER_SIZE);
    Ship battleship = createShip(BATTLESHIP_SIZE);

    return Arrays.asList(destroyer1, destroyer2, battleship);
  }

  private IAllocator getAllocator() {
    Random random = new Random();
    return random.nextBoolean() ? horizontalAllocator : verticalAllocator;
  }
}
