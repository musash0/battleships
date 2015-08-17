package com.example.battleships.command;

import com.example.battleships.utils.BattleshipConstants;

/**
 * Execute help
 */
public class CommandHelp implements ICommand {

  public static final String NAME = "commandHelp";

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(String commandString) {
    System.out.println(BattleshipConstants.SYS_RESULT_MSG_PREF + "List of available commands: ");
    Commands.print();
  }
}
