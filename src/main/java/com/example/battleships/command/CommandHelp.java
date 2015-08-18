package com.example.battleships.command;

import static com.example.battleships.utils.BattleshipConstants.SYS_RESULT_MSG_PREF;

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
    System.out.println(SYS_RESULT_MSG_PREF + "List of available commands: ");
    Commands.print();
  }
}
