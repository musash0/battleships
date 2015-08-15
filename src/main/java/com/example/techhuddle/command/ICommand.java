package com.example.techhuddle.command;

public interface ICommand {

  public static final String SYS_ERR_MSG_PREF = "(ERR) ";
  public static final String SYS_INFO_MSG_PREF = "(INFO) ";

  void execute(String command);
}
