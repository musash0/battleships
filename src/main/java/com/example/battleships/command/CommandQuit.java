package com.example.battleships.command;

/**
 * Execute quit from app
 */
public class CommandQuit implements ICommand {

  public static final String NAME = "commandQuit";

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(String commandString) {
    System.out.println("------ THANK YOU! :) -------");
  }
}
