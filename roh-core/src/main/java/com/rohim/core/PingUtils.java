package com.rohim.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PingUtils {
  public static void ping(String host) {
    try {
      String command = "ping " + host;
      // for linux, mac, restrict to 4 pings
      String osName = System.getProperty("os.name").toLowerCase();
      if (!osName.contains("win")) {
        command = "ping -c 4 " + host;
      }
      // Execute the ping command
      Process process = Runtime.getRuntime().exec(command);

      // Read the output
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }

      // Wait for the process to finish and get the exit code
      int exitCode = process.waitFor();
      // System.out.println("exitCode : " + exitCode);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
