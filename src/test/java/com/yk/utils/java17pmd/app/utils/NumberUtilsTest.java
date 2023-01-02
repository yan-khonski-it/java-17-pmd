package com.yk.utils.java17pmd.app.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberUtilsTest {

  @Test
  void testNumberIsConverted() {
    // given:
    int number = 0;

    // when:
    String convertedNumber = NumberUtils.convertNumberToString(number);

    // then:
    assertThat(convertedNumber).isEqualTo("[0]");
  }
}