package com.example.battleships.model.board;

import lombok.Getter;

/**
 * Enumeration for the status of every field from the boardGrid
 */
public enum BoardFieldStatus {

  SHIP("0"),
  HIT("X"),
  MISSED("-"),
  DOT("."),
  EMPTY(" ");

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
