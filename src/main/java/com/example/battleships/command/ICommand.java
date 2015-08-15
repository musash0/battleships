package com.example.battleships.command;

public interface ICommand {

  public static final String SYS_ERR_MSG_PREF = "(ERR) ";
  public static final String SYS_INFO_MSG_PREF = "(INFO) ";
  public static final String SYS_RESULT_MSG_PREF = "*** ";

  void execute(String commandString);
}
