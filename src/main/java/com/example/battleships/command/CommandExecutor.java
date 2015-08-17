package com.example.battleships.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static com.example.battleships.utils.BattleshipConstants.SYS_ERR_MSG_PREF;
import static org.apache.commons.lang.StringUtils.isEmpty;

/**
 * CommandExecutor class is used to execute all type of commands that implement ICommand interface.
 */
public class CommandExecutor implements ICommand {

  public static final String NAME = "commandExecutor";

  @Autowired()
  private ApplicationContext context;

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(String commandString) {
    if (isEmpty(commandString)) {
      System.err.println(SYS_ERR_MSG_PREF + "Type a commandString!");
      return;
    }
    Commands command = Commands.findCommand(commandString);
    if (command != null) {
      ICommand executableCommand = null;
      try {
        executableCommand = context.getBean(command.getCommandClz());
        executableCommand.execute(commandString);
      } catch (Exception e) {
        System.err.println(SYS_ERR_MSG_PREF + "Unexpected exception: " + e.getMessage());
        if (executableCommand != null) {
          executableCommand.execute(Commands.HELP.getCommand());
        }
      }
    } else {
      System.out.println(SYS_ERR_MSG_PREF + "Unknown command!");
    }
  }
}
