package com.rohim.cli;

import com.rohim.core.FileSplitter;
import com.rohim.core.PortChecker;

public class Main {
  public static void main(String[] args) {
    String command = args[0];

    switch (command) {
      case "ping":
        PortChecker.PortStatus portStatus = PortChecker.checkPort(
                args[1], Integer.parseInt(args[2]), args.length == 4 ? Integer.parseInt(args[3]) : null);
        System.out.println(portStatus);
        break;
      case "spf":
      case "splitfile":
        // get param from args
        String filePath = args[1];
        int linesPerChunk = Integer.parseInt(args[2]);

        // call util
        FileSplitter.splitFile(filePath, linesPerChunk);
        break;
      default:
        System.out.println("Unknown command: " + command);
        System.exit(1);
    }
    System.exit(0);
  }
}
