package com.example.battleships.utils.gridAllocation;

import com.example.battleships.model.grid.Grid;
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
public class TestHorizontalAllocator {

  @Mock
  private Grid grid;
  @Mock
  private Ship ship;
  @Mock
  private Position positionStartOfGrid;
  @Mock
  private Position positionEndOfGrid;
  @Mock
  private Position positionOutOfGrid;

  @InjectMocks
  private HorizontalAllocator horizontalAllocator;

  @Before
  public void setup() {
    when(ship.getSize()).thenReturn(DESTROYER_SIZE);
    when(positionEndOfGrid.getColumn()).thenReturn(6);
    when(positionStartOfGrid.getColumn()).thenReturn(0);
    when(positionOutOfGrid.getColumn()).thenReturn(7);
  }

  @Test
  public void testSternEndPosition() {
    int stern = horizontalAllocator.getStern(positionEndOfGrid);
    assertEquals("Index 9 is max destroyer position on grid", 9, stern);
  }

  @Test
  public void testSternStartPosition() {
    int stern = horizontalAllocator.getStern(positionStartOfGrid);
    assertEquals("Index 3 is min destroyer position on grid", 3, stern);
  }

  @Test
  public void testSternOutPosition() {
    int stern = horizontalAllocator.getStern(positionOutOfGrid);
    assertEquals("Index grater than 9 is out of grid", 10, stern);
  }

  @Test
  public void testWithNotEmptyFieldAtStart() {
    when(grid.isEmpty(any(Position.class))).thenReturn(false);
    assertFalse(horizontalAllocator.gridSpaceAvailable(positionStartOfGrid));
  }

  @Test
  public void testWithNotEmptyFieldAtEnd() {
    when(grid.isEmpty(any(Position.class))).thenReturn(false);
    assertFalse(horizontalAllocator.gridSpaceAvailable(positionEndOfGrid));
  }

  @Test
  public void testWithEmptyFieldAtStart() {
    when(grid.isEmpty(any(Position.class))).thenReturn(true);
    assertTrue(horizontalAllocator.gridSpaceAvailable(positionStartOfGrid));
  }

  @Test
  public void testWithEmptyFieldAtEnd() {
    when(grid.isEmpty(any(Position.class))).thenReturn(true);
    assertTrue(horizontalAllocator.gridSpaceAvailable(positionEndOfGrid));
  }

  @Test
  public void testPlaceDestroyer() {
    horizontalAllocator.placeShip(positionStartOfGrid);
    verify(grid, times(DESTROYER_SIZE)).placeShip(any(Position.class));
  }

  @Test
  public void testPlaceBattleship() {
    when(ship.getSize()).thenReturn(BATTLESHIP_SIZE);
    horizontalAllocator.placeShip(positionStartOfGrid);
    verify(grid, times(BATTLESHIP_SIZE)).placeShip(any(Position.class));
  }
}
