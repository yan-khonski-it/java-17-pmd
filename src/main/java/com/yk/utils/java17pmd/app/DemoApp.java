package com.yk.utils.java17pmd.app;

import com.yk.utils.java17pmd.app.core.SomeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// UnusedImports
//  import java.util.ArrayList;

public class DemoApp {

  private static final Logger LOGGER = LogManager.getLogger(DemoApp.class);

  public static void main(String[] args) {
    // a - ShortVariable
    int aVariable = 5;

    @SuppressWarnings("PMD.ShortVariable") // Here PMD ignores short name.
    int b = 6;

    int cResult = aVariable + b;
    LOGGER.info("c: {}", cResult);

    // SystemPrintln
    // System.out.println("susing system out println");

    // SomeClass someClass = new SomeClass(); - LocalVariableCouldBeFinal
    SomeClass someClass = new SomeClass();
    LOGGER.info("someClass: {}", someClass);
  }
}
