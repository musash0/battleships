package com.example.battleships.utils;

import com.example.battleships.utils.gridAllocation.Position;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;

import static com.example.battleships.utils.BattleshipConstants.ASCII_TO_ROW_PARSE_INDEX;
import static com.example.battleships.utils.BattleshipConstants.A_ASCII_CAPITAL_LETTER;
import static com.example.battleships.utils.BattleshipConstants.GRID_SIZE_TO_COORDINATES_INDEX;
import static com.example.battleships.utils.BattleshipConstants.FIRST_DIGIT_INDEX;
import static com.example.battleships.utils.BattleshipConstants.J_ASCII_CAPITAL_LETTER;
import static com.example.battleships.utils.BattleshipConstants.LETTER_INDEX;
import static com.example.battleships.utils.BattleshipConstants.TEN_DIGIT;
import static com.example.battleships.utils.BattleshipConstants.ZERO_DIGIT;
import static com.example.battleships.utils.gridAllocation.Position.createPosition;
import static org.apache.commons.lang.StringUtils.substring;

/**
 * {@inheritDoc}
 */
public class CoordinatesParser implements Parser {

  public static final String NAME = "coordinatesParser";

  /**
   * {@inheritDoc}
   */
  @Override
  public Position parse(String commandString) throws ParseException {
    int parsedRow = parseRow(commandString);
    int parsedColumn = parseColumn(commandString);

    return createPosition(parsedRow, parsedColumn);
  }

  private int parseRow(String commandString) throws ParseException {
    int validAsciiLetter = commandString.toUpperCase().charAt(LETTER_INDEX);
    if (validAsciiLetter >= A_ASCII_CAPITAL_LETTER
            && validAsciiLetter <= J_ASCII_CAPITAL_LETTER) {
      return validAsciiLetter - ASCII_TO_ROW_PARSE_INDEX;

    } else {
      throw new ParseException("Input is not valid!", LETTER_INDEX);
    }
  }

  private int parseColumn(String commandString) throws ParseException {
    String digit = substring(commandString, FIRST_DIGIT_INDEX);
    int parsedInt;
    try {
      parsedInt = Integer.valueOf(digit);
    } catch (NumberFormatException ex) {
      throw new ParseException("Input is not valid!", FIRST_DIGIT_INDEX);
    }

    if (parsedInt > ZERO_DIGIT && parsedInt <= TEN_DIGIT) {
      return parsedInt - GRID_SIZE_TO_COORDINATES_INDEX;
    } else {
      throw new ParseException("Input is not valid!", FIRST_DIGIT_INDEX);
    }
  }
}
