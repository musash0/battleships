package com.example.battleships;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestMainClass {

  @InjectMocks
  BattleshipGame battleShipGame;

  @Test
  public void testClass() {
//    Mockito.when(battleShipGame.getOne()).thenReturn(1);
//    battleShipGame.getOne();
  }
}
