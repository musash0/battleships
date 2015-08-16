package com.example.battleships.command;

public class CommandQuit extends AbstractCommand {

  public static final String NAME = "commandQuit";

  @Override
  public void execute(String commandString) {
    System.out.println("------ THANK YOU! :) -------");
  }
}
