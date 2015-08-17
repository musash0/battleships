package com.example.battleships.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.apache.commons.lang.StringUtils.isEmpty;

public class CommandExecutor extends AbstractCommand {

  @Autowired()
  private ApplicationContext context;

  @Override
  public void execute(String commandString) {
    if (isEmpty(commandString)) {
      System.err.println(SYS_ERR_MSG_PREF + "Type a commandString!");
      return;
    }

    Commands command = Commands.findCommand(commandString);
    if (command != null) {
      try {
        ICommand executableCommand = context.getBean(command.getCommandClz());
        executableCommand.execute(commandString);
      } catch (Exception e) {
        System.err.println(SYS_ERR_MSG_PREF + "Unexpected exception: " + e.getMessage());
      }
    } else {
      System.out.println(SYS_ERR_MSG_PREF + "Unknown command!");
    }
  }
}
