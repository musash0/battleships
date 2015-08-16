package com.example.battleships.model.board;

import lombok.Getter;

public enum BoardField {

  SHIP("0"),
  HIT("X"),
  MISSED("-");

  @Getter
  private String icon;


  BoardField(String icon) {
    this.icon = icon;
  }

  @Override
  public String toString() {
    return icon;
  }
}
