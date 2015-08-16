package com.example.battleships.command;

import java.lang.reflect.Constructor;

import static org.apache.commons.lang.StringUtils.isEmpty;

public class CommandExecutor extends AbstractCommand {

  private static final String SYS_PROP_OS = "os.name";
  private static final String WIN_OS_NAME = "Windows";
  private static final String WIN_OS_CLR = "cls";
  private static final String UNIX_OS_CLR = "clear";


  @Override
  public void execute(String commandString) {

    if (isEmpty(commandString)) {
      System.err.println(SYS_ERR_MSG_PREF + "Type a commandString!");
      return;
    }

    Commands command = Commands.findCommand(commandString);
    if (command != null) {
      try {

        Constructor<? extends ICommand>
                constructor =
                command.getCommandClz().getConstructor();

        ICommand executableCommand = constructor.newInstance();
        executableCommand.execute(commandString);

      } catch (Exception e) {
        System.err.println(SYS_ERR_MSG_PREF + "Unexpected exception: " + e.getMessage());
      }

    } else {
      System.out.println(SYS_ERR_MSG_PREF + "Unknown command!");
    }
  }

  private void clearConsole() {
    try {
      String os = System.getProperty(SYS_PROP_OS);
      if (os.contains(WIN_OS_NAME)) {
        Runtime.getRuntime().exec(WIN_OS_CLR);
      } else {
        Runtime.getRuntime().exec(UNIX_OS_CLR);
      }
    } catch (Exception e) {
      System.err.println(SYS_ERR_MSG_PREF + "This operation is still not supported! :)");
    }
  }
}
