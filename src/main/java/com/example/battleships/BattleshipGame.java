package com.example.battleships;

import com.example.battleships.command.CommandExecutor;
import com.example.battleships.command.Commands;
import com.example.battleships.utils.ShipGenerator;
import com.example.battleships.utils.gridAlocation.IShipGenerator;
import com.example.battleships.view.BoardView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class BattleshipGame {

  public static void main(String[] args) {

    try {
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

      CommandExecutor executor = (CommandExecutor) applicationContext.getBean("commandExecutor");
      IShipGenerator shipGenerator = (IShipGenerator) applicationContext.getBean(ShipGenerator.NAME);
      shipGenerator.generate();
      BoardView view = (BoardView) applicationContext.getBean("boardView");
      view.draw();

      //Print available commands
      executor.execute(Commands.HELP.getCommand());

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
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
