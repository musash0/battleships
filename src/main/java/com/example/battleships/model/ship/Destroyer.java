package com.example.battleships.model.ship;

import org.springframework.beans.factory.annotation.Value;

public class Destroyer extends Ship{

  @Override
  public void setSize(@Value("ship.destroyer.size") int size) {
    super.setSize(size);
  }
}
