package com.example.battleships.utils.gridAllocation;

import com.example.battleships.model.ship.Ship;

/**
 * Allocates available fields from grid
 */
public interface IAllocator {

  /**
   * Allocate ship at the grid
   */
  void allocate(Ship ship);
}
