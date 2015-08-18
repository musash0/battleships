package com.example.battleships.utils.gridAllocation;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.model.ship.Ship;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.battleships.utils.BattleshipConstants.BATTLESHIP_SIZE;
import static com.example.battleships.utils.BattleshipConstants.DESTROYER_SIZE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestVerticalAllocator {

  @Mock
  private GridBoard gridBoard;

  @Mock
  private Ship ship;

  @Mock
  private Position positionStartOfBoard;

  @Mock
  private Position positionEndOfBoard;

  @Mock
  private Position positionOutOfBoard;

  @InjectMocks
  private VerticalAllocator verticalAllocator;

  @Before
  public void setup() {
    when(ship.getSize()).thenReturn(DESTROYER_SIZE);
    when(positionEndOfBoard.getRow()).thenReturn(6);
    when(positionStartOfBoard.getRow()).thenReturn(0);
    when(positionOutOfBoard.getRow()).thenReturn(7);
  }

  @Test
  public void testSternEndPosition() {
    int stern = verticalAllocator.getStern(positionEndOfBoard);
    assertEquals("Index 9 is max destroyer position on board", 9, stern);
  }

  @Test
  public void testSternStartPosition() {
    int stern = verticalAllocator.getStern(positionStartOfBoard);
    assertEquals("Index 3 is min destroyer position on board", 3, stern);
  }

  @Test
  public void testSternOutPosition() {
    int stern = verticalAllocator.getStern(positionOutOfBoard);
    assertEquals("Index grater than 9 is out of board", 10, stern);
  }

  @Test
  public void testWithNotEmptyFieldAtStart() {
    when(gridBoard.isEmpty(any(Position.class))).thenReturn(false);
    assertFalse(verticalAllocator.gridSpaceAvailable(positionStartOfBoard));
  }

  @Test
  public void testWithNotEmptyFieldAtEnd() {
    when(gridBoard.isEmpty(any(Position.class))).thenReturn(false);
    assertFalse(verticalAllocator.gridSpaceAvailable(positionEndOfBoard));
  }

  @Test
  public void testWithEmptyFieldAtStart() {
    when(gridBoard.isEmpty(any(Position.class))).thenReturn(true);
    assertTrue(verticalAllocator.gridSpaceAvailable(positionStartOfBoard));
  }

  @Test
  public void testWithEmptyFieldAtEnd() {
    when(gridBoard.isEmpty(any(Position.class))).thenReturn(true);
    assertTrue(verticalAllocator.gridSpaceAvailable(positionEndOfBoard));
  }

  @Test
  public void testRandomNumber() {
    for (int times = 0; times < 200; times++) {
      int num = verticalAllocator.getRandomNumber();
      assertTrue(num >= 0 && num <= 9);
    }
  }

  @Test
  public void testPlaceDestroyer() {
    verticalAllocator.placeShip(positionStartOfBoard);
    verify(gridBoard, times(DESTROYER_SIZE)).placeShipField(any(Position.class));
  }

  @Test
  public void testPlaceBattleship() {
    when(ship.getSize()).thenReturn(BATTLESHIP_SIZE);
    verticalAllocator.placeShip(positionStartOfBoard);
    verify(gridBoard, times(BATTLESHIP_SIZE)).placeShipField(any(Position.class));
  }

}
