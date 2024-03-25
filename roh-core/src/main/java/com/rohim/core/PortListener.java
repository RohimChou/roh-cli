package com.rohim.core;

import java.net.ServerSocket;
import java.net.Socket;

public class PortListener {
  public static void Listen(int port) {
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("Server started on port " + port);
      Socket socket = serverSocket.accept();
      System.out.println("Client connected");
      serverSocket.close();
    } catch (java.io.IOException e) {
      e.printStackTrace();
    }
  }
}
