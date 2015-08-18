package com.example.battleships.model.grid;

import lombok.Getter;

/**
 * Enumeration for the status of every field from the grid
 */
public enum FieldStatus {

  SHIP("0"),
  HIT("X"),
  MISSED("-"),
  DOT("."),
  EMPTY(" ");

  @Getter
  private String icon;

  FieldStatus(String icon) {
    this.icon = icon;
  }

  @Override
  public String toString() {
    return icon;
  }

}
