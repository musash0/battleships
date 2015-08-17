package com.example.battleships.utils;

import com.example.battleships.command.Commands;
import com.example.battleships.model.board.GridBoard;
import org.apache.commons.lang.StringUtils;

public class CoordinatesValidator implements Validator {

  public static final String NAME = "coordinatesValidator";
  private static final int LETTER_INDEX = 0;
  private static final int FIRST_DIGIT_INDEX = 1;

  @Override
  public boolean validate(String commandString) {
    try {
      if (Commands.SHOOT.getCommand() == commandString) {
        return false;
      }
      boolean validate = false;
      if (validateLetter(commandString) && validateDigits(commandString)) {
        validate = true;
      }
      return validate;
    } catch (Exception e) {
      return false;
    }
  }

  private boolean validateLetter(String commandString) {
    int validAsciiLetter = commandString.toUpperCase().charAt(LETTER_INDEX) - 65;
    return validAsciiLetter >= 0 && validAsciiLetter <= 9;
  }

  private boolean validateDigits(String commandString) {
    String digit = StringUtils.substring(commandString, FIRST_DIGIT_INDEX);
    int parsedInt = Integer.valueOf(digit);
    return parsedInt > 0 && parsedInt <= GridBoard.BOARD_CAPACITY;
  }
}
