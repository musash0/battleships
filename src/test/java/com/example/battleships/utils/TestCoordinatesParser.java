package com.example.battleships.utils;

import com.example.battleships.utils.gridAllocation.Position;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class TestCoordinatesParser {

  @Test
  public void testLeftUpper() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    Position position = coordinatesParser.parse("a1");
    assertEquals(0, position.getRow());
    assertEquals(0, position.getColumn());
  }

  @Test
     public void testRightUpper() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    Position position = coordinatesParser.parse("a10");
    assertEquals(0, position.getRow());
    assertEquals(9, position.getColumn());
  }

  @Test
  public void testLeftBottom() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    Position position = coordinatesParser.parse("j1");
    assertEquals(9, position.getRow());
    assertEquals(0, position.getColumn());
  }

  @Test
  public void testRightBottom() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    Position position = coordinatesParser.parse("j10");
    assertEquals(9, position.getRow());
    assertEquals(9, position.getColumn());
  }

  @Test
  public void testLeftUpperCapitalLetters() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    Position position = coordinatesParser.parse("A1");
    assertEquals(0, position.getRow());
    assertEquals(0, position.getColumn());
  }

  @Test
  public void testRightUpperCapitalLetters() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    Position position = coordinatesParser.parse("A10");
    assertEquals(0, position.getRow());
    assertEquals(9, position.getColumn());
  }

  @Test
  public void testLeftBottomCapitalLetters() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    Position position = coordinatesParser.parse("J1");
    assertEquals(9, position.getRow());
    assertEquals(0, position.getColumn());
  }

  @Test
  public void testRightBottomCapitalLetters() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    Position position = coordinatesParser.parse("J10");
    assertEquals(9, position.getRow());
    assertEquals(9, position.getColumn());
  }

  @Test(expected = ParseException.class)
  public void testInvalidLetter() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    coordinatesParser.parse("k9");
  }

  @Test(expected = ParseException.class)
  public void testInvalidNumber() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    coordinatesParser.parse("k11");
  }

  @Test(expected = ParseException.class)
  public void testInvalidInput() throws ParseException {
    CoordinatesParser coordinatesParser = new CoordinatesParser();
    coordinatesParser.parse("adsf");
  }
}
