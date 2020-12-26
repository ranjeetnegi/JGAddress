package com.jagatguru.address.common;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Constants {

  public static final DateTimeFormatter FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").withLocale(Locale.ENGLISH)
          .withZone(ZoneId.of("UTC"));
  public static final Integer RESULT_SIZE_40 = 40;
}
