package com.example.battleships.model.board;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Data;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardField {

  @NonNull
  private BoardFieldStatus value;
  private boolean isHit;

  public static BoardField create(BoardFieldStatus value) {
    return new BoardField(value);
  }

  public static BoardField create(BoardFieldStatus value, boolean isHit) {
    return new BoardField(value, isHit);
  }
}
