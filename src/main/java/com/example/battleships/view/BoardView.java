package com.example.battleships.view;

import com.example.battleships.command.Commands;
import com.example.battleships.model.board.BoardField;
import com.example.battleships.model.board.GridBoard;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public abstract class BoardView {

  protected static final String OFFSET = "  ";
  private static final char A_CAPITAL_LETTER = 65;
  private static final String TITLE_NUMBERS = "   1  2  3  4  5  6  7  8  9  10";

  @Autowired
  protected GridBoard gridBoard;

  public void drawBoard() {
    drawDescription();
  }

  private void drawDescription() {
    BoardField fields[][] = gridBoard.getGrid();
    System.out.println(TITLE_NUMBERS);
    char asciiLetter = A_CAPITAL_LETTER;
    for (BoardField[] row : fields) {
      System.out.print(asciiLetter++ + OFFSET);
      for (BoardField cell : row) {
        drawFieldCells(cell);
      }
      System.out.println();
    }
    System.out.println(Commands.SHOOT.getDescription());
  }

  protected abstract void drawFieldCells(BoardField cell);
}
