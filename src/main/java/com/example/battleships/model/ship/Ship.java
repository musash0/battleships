package com.example.battleships.model.ship;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ship {

  private int size;

  public static Ship createShip(int size) {
    return new Ship(size);
  }
}
