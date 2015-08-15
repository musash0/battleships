package com.example.battleships.model;

import lombok.Getter;

public enum BoardFieldStatus {

  SHIP("0"),
  EMPTY("."),
  HIT("X"),
  MISSED("-");

  @Getter
  private String icon;


  BoardFieldStatus(String icon) {
    this.icon = icon;
  }

  @Override
  public String toString() {
    return icon;
  }
}
