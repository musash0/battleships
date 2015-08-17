package com.example.battleships;

import com.example.battleships.command.CommandExecutor;
import com.example.battleships.command.Commands;
import com.example.battleships.utils.shipGenerator.IShipGenerator;
import com.example.battleships.utils.shipGenerator.ShipGenerator;
import com.example.battleships.view.BoardView;
import com.example.battleships.view.GameBoardView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

import static com.example.battleships.model.board.GridBoard.getAllShotsCounter;
import static com.example.battleships.model.board.GridBoard.getHitShipsCounter;
import static com.example.battleships.model.ship.Ship.getAllShipsCounter;
import static com.example.battleships.utils.BattleshipConstants.ALL_BOARD_FIELDS_NUMBER;
import static com.example.battleships.utils.BattleshipConstants.SYS_ERR_MSG_PREF;

public class BattleshipGame {

  public static void main(String[] args) {
    try {
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
      CommandExecutor executor = getCommandExecutor(applicationContext);
      generateShips(applicationContext);
      generateBoardView(applicationContext);
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
        System.out.println("Game complete! Total shots: " + getAllShotsCounter());
        break;
      }
    }
  }

  /**
   * Generate the executor of commands
   */
  private static CommandExecutor getCommandExecutor(ApplicationContext applicationContext) {
    CommandExecutor executor = (CommandExecutor) applicationContext.getBean("commandExecutor");
    //Print available commands
    executor.execute(Commands.HELP.getCommand());
    return executor;
  }

  /**
   * Generate board view
   */
  private static void generateBoardView(ApplicationContext applicationContext) {
    BoardView view = (BoardView) applicationContext.getBean(GameBoardView.NAME);
    view.drawBoard();
  }

  /**
   * Generate ships for the board
   */
  private static void generateShips(ApplicationContext applicationContext) {
    IShipGenerator shipGenerator = (IShipGenerator) applicationContext.getBean(ShipGenerator.NAME);
    shipGenerator.generate();
  }

  /**
   * Check if game is complete
   */
  private static boolean isGameComplete() {
    boolean gameEnded = false;
    if (getAllShipsCounter() == getHitShipsCounter() || getAllShotsCounter() == ALL_BOARD_FIELDS_NUMBER) {
      gameEnded = true;
    }
    return gameEnded;
  }

}
