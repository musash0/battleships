package com.example.battleships.command;

/**
 * Interface provides the ability to implement executable string as a command
 */
public interface ICommand {

  /**
   * Execute string that is read from input
   *
   * @param commandString The executable command
   */
  void execute(String commandString);
}
