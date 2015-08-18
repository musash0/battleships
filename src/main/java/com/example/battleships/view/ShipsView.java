package com.example.battleships.view;

import com.example.battleships.model.grid.Field;
import lombok.NoArgsConstructor;

import static com.example.battleships.model.grid.FieldStatus.EMPTY;
import static com.example.battleships.model.grid.FieldStatus.HIT;
import static com.example.battleships.model.grid.FieldStatus.SHIP;

@NoArgsConstructor
public class ShipsView extends GameView {

  public static final String NAME = "shipsView";

  @Override
  protected void drawFieldCells(Field cell) {
    if (cell != null && SHIP.equals(cell.getStatus())) {
      System.out.print(HIT + OFFSET);
    } else if (cell != null && HIT.equals(cell.getStatus())) {
      System.out.print(HIT + OFFSET);
    } else {
      System.out.print(EMPTY + OFFSET);
    }
  }
}
