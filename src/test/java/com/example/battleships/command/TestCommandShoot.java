package com.example.battleships.command;

import com.example.battleships.model.board.GridBoard;
import com.example.battleships.utils.Parser;
import com.example.battleships.utils.gridAllocation.Position;
import com.example.battleships.view.BoardView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCommandShoot {

  @Mock
  private GridBoard gridBoard;

  @Mock
  private BoardView gameBoardView;

  @Mock
  private Parser coordinatesParser;

  @InjectMocks
  private CommandShoot commandShoot;

  @Test
  public void testShoot() throws ParseException {
    commandShoot.execute(anyString());
    verify(coordinatesParser, times(1)).parse(anyString());
    verify(gridBoard, times(1)).hitBoard(any(Position.class));
    verify(gameBoardView, times(1)).drawBoard();
  }

  @Test
  public void testException() throws ParseException {
    when(coordinatesParser.parse(anyString())).thenThrow(ParseException.class);
    commandShoot.execute(anyString());
    verify(coordinatesParser, times(1)).parse(anyString());
    verify(gridBoard, times(0)).hitBoard(any(Position.class));
    verify(gameBoardView, times(0)).drawBoard();
  }
}
