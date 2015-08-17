package com.example.battleships.utils.gridAlocation;

import com.example.battleships.model.ship.Ship;

/**
 * Allocates available fields from gridBoard
 */
public interface IAllocator {

  /**
   * Allocate ship at the gridBoard
   */
  void allocate(Ship ship);
}
