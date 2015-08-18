package com.example.battleships.model;

import com.example.battleships.model.grid.Field;
import com.example.battleships.model.grid.FieldStatus;
import com.example.battleships.model.grid.Grid;
import com.example.battleships.utils.gridAllocation.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGrid {

  private Grid grid;

  @Before
  public void setup() {
    grid = new Grid();
  }

  @Test
  public void testPlaceShip() {
    Position position = Position.createPosition(1, 1);
    grid.placeShip(position);
    Field field = grid.getGrid()[1][1];
    Assert.assertTrue(field.getStatus().equals(FieldStatus.SHIP));
  }
}
