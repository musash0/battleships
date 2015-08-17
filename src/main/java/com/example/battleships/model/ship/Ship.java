package com.example.battleships.model.ship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Ship {

  @Getter
  private static int allShipsCounter;

  private int size;

  public static Ship createShip(int size) {
    allShipsCounter += size;
    return new Ship(size);
  }
}
