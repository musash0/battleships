package com.example.battleships;

import com.example.battleships.command.CommandExecutor;
import com.example.battleships.command.Commands;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class BattleshipGame {

  public static void main(String[] args) {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    CommandExecutor executor = (CommandExecutor) applicationContext.getBean("commandExecutor");

    //Print available commands
    executor.execute(Commands.SHOOT.getCommand());

    Scanner input = new Scanner(System.in);
    String command;

    while (true) {
      command = input.nextLine().trim();
      executor.execute(command);

      //quit normally
      if (Commands.QUIT.equals(Commands.findCommand(command))) {
        break;
      }
    }
  }


}
