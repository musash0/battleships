package com.example.battleships.command;

public class CommandHelp extends AbstractCommand {

  @Override
  public void execute(String commandString) {
    System.out.println(SYS_RESULT_MSG_PREF + "List of available commands: ");
    Commands.print();
  }
}
