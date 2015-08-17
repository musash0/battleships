package com.example.battleships.utils;

import com.example.battleships.utils.gridAlocation.Position;

import java.text.ParseException;

public interface Parser {
  Position parse(String commandString) throws ParseException;
}
