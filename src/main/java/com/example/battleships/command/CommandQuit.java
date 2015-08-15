package com.example.battleships.command;

public class CommandQuit extends AbstractCommand {

  @Override
  public void execute(String commandString) {
    System.out.println("------ THANK YOU! :) -------");
  }
}
