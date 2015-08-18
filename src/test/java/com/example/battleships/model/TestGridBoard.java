package com.example.battleships.model;

import com.example.battleships.model.board.BoardField;
import com.example.battleships.model.board.BoardFieldStatus;
import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.gridAllocation.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGridBoard {

  private GridBoard gridBoard;

  @Before
  public void setup() {
    gridBoard = new GridBoard();
  }

  @Test
  public void testPlaceShip() {
    Position position = Position.createPosition(1, 1);
    gridBoard.placeShipField(position);
    BoardField field = gridBoard.getGrid()[1][1];
    Assert.assertTrue(field.getValue().equals(BoardFieldStatus.SHIP));
  }
}
