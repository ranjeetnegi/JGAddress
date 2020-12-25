package com.jagatguru.address.common;

import java.sql.Timestamp;
import java.time.Instant;

public class Utility {
  /**
   * Get Current Timestamp
   *
   * @return Timestamp
   */
  public static Timestamp getCurrentTimestampInUTC() {
    return Timestamp.valueOf(Constants.FORMATTER.format(Instant.now()));
  }
}
