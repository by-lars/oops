package de.uulm.in.pm.api;

import de.uulm.in.pm.api.*;

/** Main class. */
public class Main {

  /** Run tests. */
  public static void main(String[] args) {
    //AbstractBird tweety = new AbstractBird(100, 2);
    Eagle amos = new Eagle(100, "Amos");
    System.out.println(amos);
    Eagle amos2 = new Eagle(100, "Amos");
    System.out.println(amos == amos2);
    System.out.println(amos.equals(amos2));

  }
}

