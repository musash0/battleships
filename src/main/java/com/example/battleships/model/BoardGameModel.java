package com.example.battleships.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BoardGameModel {
  private static final int BOARD_CAPACITY = 10;

  @Getter
  private BoardFieldStatus[][] boardGrid = new BoardFieldStatus[BOARD_CAPACITY][BOARD_CAPACITY];

}
