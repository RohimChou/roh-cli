package com.rohim.core;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Check if a remote port is open.
 */
public class PortChecker {
  public enum PortStatus {
    OPEN("open"),
    TIMEOUT("timeout"),
    UNKOWN_HOST("unknown host"),
    UNKOWN_ERROR("unknown error"), 
    PORT_OUT_OF_RANGE("port out of range");

    private final String status;

    PortStatus(String status) {
      this.status = status;
    }

    public String getStatus() {
      return status;
    }
  }

  /**
   * Check if a remote port is open. (timeout: 2 seconds)
   * 
   * @param host e.g. "google.com", "192.168.1.2"
   * @param port e.g. 443, 80
   */
  public static PortStatus checkPort(String host, int port) {
    return checkPort(host, port, 2);
  }

  /**
   * Check if a remote port is open.
   * 
   * @param host        e.g. "google.com", "192.168.1.2"
   * @param port        e.g. 443, 80
   * @param timeoutSecs e.g. 2
   * @return
   */
  public static PortStatus checkPort(String host, int port, Integer timeoutSecs) {
    if (timeoutSecs == null) {
      timeoutSecs = 2;
    }
      
    try {
      Socket socket = new Socket();
      socket.connect(new InetSocketAddress(host, port), timeoutSecs * 1000);

      socket.close();
      return PortStatus.OPEN;
    } catch (java.net.SocketTimeoutException e) {
      System.out.println(e);
      return PortStatus.TIMEOUT;
    } catch (java.net.UnknownHostException e) {
      System.out.println(e);
      return PortStatus.UNKOWN_HOST;
    } catch (Exception e) {
      System.out.println(e);
      // if argument is invalid, throw it
      if (e instanceof java.lang.IllegalArgumentException) {
        throw (java.lang.IllegalArgumentException) e;
      }
      
      return PortStatus.UNKOWN_ERROR;
    }
  }
}
