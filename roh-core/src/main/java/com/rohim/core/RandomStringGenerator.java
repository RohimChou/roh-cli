package com.rohim.core;

import java.security.SecureRandom;

public class RandomStringGenerator {
  /*
   * 7 chars probably wouldn't collide about 500000 requests
   * 6 chars probably wouldn't collide about 50000 requests
   */ 
  public static String generate(int length) {
    // 65 chars
    String chars = 
      "ABCDEFGHJKMNPQRSTUVWXYZ" +
      "abcdefghijkmnopqrstuvwxyz" + 
      "0123456789" +
      "-+#@_=";
    SecureRandom random = new SecureRandom();
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      // int index = (int) (chars.length() * Math.random());
      int index = random.nextInt(chars.length());
      sb.append(chars.charAt(index));
    }

    return sb.toString();
  }
}