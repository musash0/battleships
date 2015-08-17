package com.example.battleships.view;

import com.example.battleships.model.board.BoardField;
import lombok.NoArgsConstructor;

import static com.example.battleships.model.board.BoardFieldStatus.DOT;
import static com.example.battleships.model.board.BoardFieldStatus.HIT;
import static com.example.battleships.model.board.BoardFieldStatus.SHIP;

@NoArgsConstructor
public class GameBoardView extends BoardView {

  public static final String NAME = "gameBoardView";

  @Override
  protected void drawFieldCells(BoardField cell) {
    if (cell == null) {
      System.out.print(DOT + OFFSET);
    } else if (SHIP.equals(cell.getValue()) && cell.isHit()) {
      System.out.print(HIT + OFFSET);
    } else if (SHIP.equals(cell.getValue())) {
      System.out.print(DOT + OFFSET);
    } else {
      System.out.print(cell.getValue() + OFFSET);
    }
  }
}
