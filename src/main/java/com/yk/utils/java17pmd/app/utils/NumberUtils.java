package com.yk.utils.java17pmd.app.utils;

public final class NumberUtils {

  private NumberUtils() {
    throw new AssertionError("Instance is not allowed.");
  }

  // try to rename it to fo(n)
  public static String convertNumberToString(int number) {
    return "[" + number + "]";
  }
}
