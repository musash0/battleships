package com.example.battleships.command;

import lombok.Getter;

public enum Commands {

  SHOOT("", "Try to hit a ship. Enter coordinates (row, col), e.g. A5", CommandShoot.class),
  SHOW("show", "Show battleships on board.", CommandShow.class),
  HELP("help", "Print available commands.", CommandHelp.class),
  QUIT("quit", "Quit the program.", CommandQuit.class);

  @Getter
  private String command;
  @Getter
  private String description;
  @Getter
  private Class<? extends ICommand> commandClz;

  Commands(String command, String description,
           Class<? extends ICommand> commandClz) {
    this.command = command;
    this.description = description;
    this.commandClz = commandClz;
  }

  /**
   * Print available commands
   */
  public static void print() {
    for (Commands command : Commands.values()) {
      System.out.println(command.toString());
    }
  }

  /**
   * Find command by given String
   */
  public static Commands findCommand(String commandString) {
    Commands searchedCommand;
    if (commandString.equalsIgnoreCase(SHOW.getCommand())) {
      searchedCommand = SHOW;
    } else if (commandString.equalsIgnoreCase(HELP.getCommand())) {
      searchedCommand = HELP;
    } else if (commandString.equalsIgnoreCase(QUIT.getCommand())) {
      searchedCommand = QUIT;
    } else {
      searchedCommand = SHOOT;
    }

    return searchedCommand;
  }

  @Override
  public String toString() {
    return "<" + getCommand() + "> " + getDescription();
  }

}
