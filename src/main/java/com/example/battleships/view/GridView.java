package com.example.battleships.view;

import com.example.battleships.model.grid.Field;
import lombok.NoArgsConstructor;

import static com.example.battleships.model.grid.FieldStatus.DOT;
import static com.example.battleships.model.grid.FieldStatus.HIT;
import static com.example.battleships.model.grid.FieldStatus.SHIP;

@NoArgsConstructor
public class GridView extends GameView {

  public static final String NAME = "gridView";

  @Override
  protected void drawFieldCells(Field cell) {
    if (cell == null) {
      System.out.print(DOT + OFFSET);
    } else if (SHIP.equals(cell.getStatus()) && cell.isHit()) {
      System.out.print(HIT + OFFSET);
    } else if (SHIP.equals(cell.getStatus())) {
      System.out.print(DOT + OFFSET);
    } else {
      System.out.print(cell.getStatus() + OFFSET);
    }
  }
}
