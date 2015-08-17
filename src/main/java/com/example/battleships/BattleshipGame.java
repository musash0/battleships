package com.example.battleships;

import com.example.battleships.command.CommandExecutor;
import com.example.battleships.command.Commands;
import com.example.battleships.model.board.GridBoard;
import com.example.battleships.model.ship.Ship;
import com.example.battleships.utils.ShipGenerator;
import com.example.battleships.utils.gridAlocation.IShipGenerator;
import com.example.battleships.view.BoardView;
import com.example.battleships.view.GameBoardView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

import static com.example.battleships.utils.BattleshipConstants.SYS_ERR_MSG_PREF;

public class BattleshipGame {

  public static void main(String[] args) {
    try {
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

      CommandExecutor executor = (CommandExecutor) applicationContext.getBean("commandExecutor");
      //Print available commands
      executor.execute(Commands.HELP.getCommand());

      IShipGenerator shipGenerator = (IShipGenerator) applicationContext.getBean(ShipGenerator.NAME);
      shipGenerator.generate();
      BoardView view = (BoardView) applicationContext.getBean(GameBoardView.NAME);
      view.drawBoard();

      Scanner input = new Scanner(System.in);
      String command;

      while (true) {
        command = input.nextLine().trim();
        executor.execute(command);

        //quit normally
        if (Commands.QUIT.equals(Commands.findCommand(command))) {
          break;
        }

        if (isGameEnded()) {
          System.out.println("Game complete! Total shots: " + GridBoard.getAllShotsCounter());
          break;
        }
      }
    } catch (Exception e) {
      System.err.println(SYS_ERR_MSG_PREF + e.getMessage());
    }
  }

  private static boolean isGameEnded() {
    boolean gameEnded = false;
    if (Ship.getAllShipsCounter() == GridBoard.getHitShipsCounter() || GridBoard.getAllShotsCounter() == 100) {
      gameEnded = true;
    }
    return gameEnded;
  }

}
