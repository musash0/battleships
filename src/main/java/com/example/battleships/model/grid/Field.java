package com.example.battleships.model.grid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represent field from the grid
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Field {

  @NonNull
  private FieldStatus status;
  private boolean isHit;

  /**
   * Creates new field with the representation status
   *
   * @param fieldStatus Status of field from the grid
   */
  public static Field create(FieldStatus fieldStatus) {
    return new Field(fieldStatus);
  }

  /**
   * Creates new field with the representation status
   *
   * @param fieldStatus Status of field from the grid
   * @param isHit Set hit to the field
   */
  public static Field create(FieldStatus fieldStatus, boolean isHit) {
    return new Field(fieldStatus, isHit);
  }
}
