package com.example.battleships.model.ship;

import org.springframework.beans.factory.annotation.Value;

public class Battleship extends Ship {

  @Override
  public void setSize(@Value("ship.battleship.size") int size) {
    super.setSize(size);
  }
}
