package com.example.battleships.utils;

import com.example.battleships.utils.gridAlocation.Position;

import java.text.ParseException;

/**
 * Utility class used to parse user input
 */
public interface Parser {

  /**
   * Parse user input and return valid position
   */
  Position parse(String commandString) throws ParseException;
}
