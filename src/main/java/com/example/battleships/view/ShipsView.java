package com.example.battleships.view;

import com.example.battleships.model.board.BoardField;
import lombok.NoArgsConstructor;

import static com.example.battleships.model.board.BoardFieldStatus.EMPTY;
import static com.example.battleships.model.board.BoardFieldStatus.HIT;
import static com.example.battleships.model.board.BoardFieldStatus.SHIP;

@NoArgsConstructor
public class ShipsView extends BoardView {

  public static final String NAME = "shipsView";

  @Override
  protected void drawFieldCells(BoardField cell) {
    if (cell != null && SHIP.equals(cell.getValue())) {
      System.out.print(HIT + OFFSET);
    } else if (cell != null && HIT.equals(cell.getValue())) {
      System.out.print(HIT + OFFSET);
    } else {
      System.out.print(EMPTY + OFFSET);
    }
  }
}
