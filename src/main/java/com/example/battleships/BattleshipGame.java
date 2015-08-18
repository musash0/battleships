package com.example.battleships;

import com.example.battleships.command.CommandExecutor;
import com.example.battleships.command.Commands;
import com.example.battleships.model.grid.Grid;
import com.example.battleships.model.ship.Ship;
import com.example.battleships.utils.shipGenerator.IShipGenerator;
import com.example.battleships.utils.shipGenerator.ShipGenerator;
import com.example.battleships.view.GameView;
import com.example.battleships.view.GridView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

import static com.example.battleships.utils.BattleshipConstants.ALL_FIELDS_NUMBER;
import static com.example.battleships.utils.BattleshipConstants.SYS_ERR_MSG_PREF;

public class BattleshipGame {

  public static void main(String[] args) {
    try {
      ApplicationContext applicationContext =
              new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
      CommandExecutor executor = getCommandExecutor(applicationContext);
      generateShips(applicationContext);
      generateGridView(applicationContext);
      listenForUserInput(executor);
    } catch (Exception e) {
      System.err.println(SYS_ERR_MSG_PREF + e.getMessage());
    }
  }

  /**
   * User input listener
   */
  private static void listenForUserInput(CommandExecutor executor) {
    Scanner input = new Scanner(System.in);
    String command;
    while (true) {
      command = input.nextLine().trim();
      executor.execute(command);

      //quit normally
      if (Commands.QUIT.equals(Commands.findCommand(command))) {
        break;
      }
      if (isGameComplete()) {
        System.out.println("Game complete! Total shots: " + Grid.getAllShotsCounter());
        break;
      }
    }
  }

  /**
   * Generate the executor of commands
   */
  private static CommandExecutor getCommandExecutor(ApplicationContext applicationContext) {
    CommandExecutor executor =
            (CommandExecutor) applicationContext.getBean(CommandExecutor.NAME);
    //Print available commands
    executor.execute(Commands.HELP.getCommand());
    return executor;
  }

  /**
   * Generate grid view
   */
  private static void generateGridView(ApplicationContext applicationContext) {
    GameView view = (GameView) applicationContext.getBean(GridView.NAME);
    view.draw();
  }

  /**
   * Generate ships for the grid
   */
  private static void generateShips(ApplicationContext applicationContext) {
    IShipGenerator shipGenerator =
            (IShipGenerator) applicationContext.getBean(ShipGenerator.NAME);
    shipGenerator.generate();
  }

  /**
   * Check if game is complete
   */
  private static boolean isGameComplete() {
    boolean gameEnded = false;
    if (Ship.getAllShipsCounter() == Grid.getHitShipsCounter()
            || Grid.getAllShotsCounter() == ALL_FIELDS_NUMBER) {
      gameEnded = true;
    }
    return gameEnded;
  }

}
