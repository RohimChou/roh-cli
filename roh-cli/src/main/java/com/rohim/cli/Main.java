package com.rohim.cli;

import com.rohim.core.*;

public class Main {
  public static void main(String[] args) {
    String command = args[0];

    switch (command) {
      case "ping":
        String host = args[1];
        if (args.length == 2) {
           PingUtils.ping(host);
        } else {
          int port = Integer.parseInt(args[2]);
          Integer timeoutSecs = args.length >= 4 ? Integer.parseInt(args[3]) : null;
          PortChecker.PortStatus portStatus = PortChecker.checkPort(host, port, timeoutSecs);
          System.out.println(portStatus);
        }
        break;
      case "spf":
      case "splitfile":
        // get param from args
        String filePath = args[1];
        int linesPerChunk = Integer.parseInt(args[2]);

        // call util
        FileSplitter.splitFile(filePath, linesPerChunk);
        break;
      case "randomstr":
      case "ranstr":
        // get param from args
        int length = Integer.parseInt(args[1]);
        int count = args.length >= 3 ? Integer.parseInt(args[2]) : 1;

        // call util
        for (int i = 0; i < count; i++) {
          String randomString = RandomStringGenerator.generate(length);
          System.out.println(randomString);
        }
        break;
      case "listen":
        int port = Integer.parseInt(args[1]);
        PortListener.Listen(port);
        break;
      default:
        System.out.println("Unknown command: " + command);
        System.exit(1);
    }
    System.exit(0);
  }
}
