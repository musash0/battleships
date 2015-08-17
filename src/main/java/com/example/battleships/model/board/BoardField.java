package com.example.battleships.model.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represent field from the gridBoard
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardField {

  @NonNull
  private BoardFieldStatus value;
  private boolean isHit;

  /**
   * Creates new field with the representation status
   *
   * @param fieldStatus
   */
  public static BoardField create(BoardFieldStatus fieldStatus) {
    return new BoardField(fieldStatus);
  }

  /**
   * Creates new field with the representation status
   *
   * @param fieldStatus Status of field from the boardGrid
   * @param isHit Set hit to the field
   */
  public static BoardField create(BoardFieldStatus fieldStatus, boolean isHit) {
    return new BoardField(fieldStatus, isHit);
  }
}
