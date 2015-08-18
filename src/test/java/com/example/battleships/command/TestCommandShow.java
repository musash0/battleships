package com.example.battleships.command;

import com.example.battleships.view.ShipsView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TestCommandShow {

  @Mock
  private ShipsView shipsView;

  @InjectMocks
  private CommandShow commandShow;

  @Test
  public void testShow() throws ParseException {
    commandShow.execute("show");
    verify(shipsView, times(1)).draw();
  }
}
