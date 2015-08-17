package com.example.battleships.command;

import lombok.Getter;

public enum Commands {

  /**
   * Clear console.
   */
  SHOOT("", "Try to hit a ship. Enter coordinates (row, col), e.g. A5", CommandShoot.class),
  /**
   * Quit the program.
   */
  SHOW("show", "Show battleships on board.", CommandShow.class),
  /**
   * Print available commands.
   */
  HELP("help", "Print available commands.", CommandHelp.class),
  /**
   * Fetch a topic
   */
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

    String commandPrefix;
    int delimiterPos = commandString.indexOf(" ");
    if (delimiterPos > -1) {
      commandPrefix = commandString.substring(0, delimiterPos);
    } else {
      commandPrefix = commandString;
    }

    Commands searchedCommand;
    if (commandPrefix.equalsIgnoreCase(SHOW.getCommand())) {
      searchedCommand = SHOW;
    } else if (commandPrefix.equalsIgnoreCase(HELP.getCommand())) {
      searchedCommand = HELP;
    } else if (commandPrefix.equalsIgnoreCase(QUIT.getCommand())) {
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
