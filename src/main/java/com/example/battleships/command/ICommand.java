package com.example.battleships.command;

import java.text.ParseException;

public interface ICommand {

  void execute(String commandString) throws ParseException;
}
