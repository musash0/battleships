package com.example.battleships.utils;

import com.example.battleships.utils.gridAlocation.Position;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;

import static com.example.battleships.utils.BattleshipConstants.ASCII_TO_ROW_PARSE_INDEX;
import static com.example.battleships.utils.BattleshipConstants.A_ASCII_CAPITAL_LETTER;
import static com.example.battleships.utils.BattleshipConstants.COLUMN_TO_GRID_PARSE_INDEX;
import static com.example.battleships.utils.BattleshipConstants.FIRST_DIGIT_INDEX;
import static com.example.battleships.utils.BattleshipConstants.J_ASCII_CAPITAL_LETTER;
import static com.example.battleships.utils.BattleshipConstants.LETTER_INDEX;
import static com.example.battleships.utils.BattleshipConstants.TEN_DIGIT;
import static com.example.battleships.utils.BattleshipConstants.ZERO_DIGIT;

public class CoordinatesParser implements Parser {

  public static final String NAME = "coordinatesParser";

  @Override
  public Position parse(String commandString) throws ParseException {
    int parsedRow = parseRow(commandString);
    int parsedColumn = parseColumn(commandString);

    return Position.createPosition(parsedRow, parsedColumn);
  }

  private int parseRow(String commandString) throws ParseException {
    int validAsciiLetter = commandString.toUpperCase().charAt(BattleshipConstants.LETTER_INDEX);
    int row = 0;
    if (validAsciiLetter >= A_ASCII_CAPITAL_LETTER && validAsciiLetter <= J_ASCII_CAPITAL_LETTER) {
      row = validAsciiLetter - ASCII_TO_ROW_PARSE_INDEX;
    } else {
      throw new ParseException("Input is not valid!", LETTER_INDEX);
    }
    return row;
  }

  private int parseColumn(String commandString) throws ParseException {
    String digit = StringUtils.substring(commandString, BattleshipConstants.FIRST_DIGIT_INDEX);
    int parsedInt = Integer.valueOf(digit);
    int column = 0;
    if (parsedInt > ZERO_DIGIT && parsedInt <= TEN_DIGIT) {
      column = parsedInt - COLUMN_TO_GRID_PARSE_INDEX;
    } else {
      throw new ParseException("Input is not valid!", FIRST_DIGIT_INDEX);
    }
    return column;
  }
}
