package com.rohim.cli;

import com.rohim.core.PortChecker;

public class Main {
  public static void main(String[] args) {
    if (args.length != 2 && args.length != 3) {
      System.out.println("Usage: roh <host> <port>");
      System.out.println("Usage: roh <host> <port> <timeoutSecs>");
      System.exit(1);
    }

    System.out.println(PortChecker.checkPort(
      args[0], Integer.parseInt(args[1]), args.length == 3 ? Integer.parseInt(args[2]) : null));
  }
}