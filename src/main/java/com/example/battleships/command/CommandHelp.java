package com.example.battleships.command;

import com.example.battleships.utils.BattleshipConstants;

public class CommandHelp extends AbstractCommand {

  public static final String NAME = "commandHelp";

  @Override
  public void execute(String commandString) {
    System.out.println(BattleshipConstants.SYS_RESULT_MSG_PREF + "List of available commands: ");
    Commands.print();
  }
}
