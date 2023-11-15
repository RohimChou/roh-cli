package com.rohim.core;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Split large file into multiple files
 */
public class FileSplitter {
  public static void splitFile(String filePath, int linesPerChunk) {
    Charset inOutEncoding = StandardCharsets.UTF_16LE;

    // reader
    try (final BufferedReader reader = new BufferedReader(
            new InputStreamReader(new FileInputStream(filePath), inOutEncoding))) {

      int chunkNum = 1;
      String line;
      while ((line = reader.readLine()) != null) {
        // writer
        String newFilePath = getNewFilePath(filePath, chunkNum);
        try (final BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(newFilePath), inOutEncoding))) {

          // write bom
          writer.write('\ufeff');

          int counter = 0;
          while (line != null && ++counter < linesPerChunk) {
            writer.write(line);
            writer.write(System.lineSeparator());
            // read next line
            line = reader.readLine();
          }

          // end of chunk
          writer.flush();
          System.out.printf("%s %s Generated%n", chunkNum, newFilePath);
          ++chunkNum;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String getNewFilePath(String filePath, int chunkNum) {
    return getFolderPath(filePath) + "/" + getFileBaseName(filePath)
            + "." + String.format("%02d", chunkNum) + "." + getFileExtension(filePath);
  }

  private static String getFolderPath(String filePath) {
    File file = new File(filePath);
    return file.getParent();
  }

  private static String getFileExtension(String filePath) {
    // /path/to.a/file
    // \\path\\to\\archive.tar.gz
    String extension = "";

    int lastDotIndex = filePath.lastIndexOf('.');
    int lastFileSepIndex = Math.max(filePath.lastIndexOf('/'), filePath.lastIndexOf('\\'));

    if (lastDotIndex > lastFileSepIndex) {
      extension = filePath.substring(lastDotIndex + 1);
    }

    return extension;
  }

  private static String getFileBaseName(String filePath) {
    // /path/to.a/file
    // \\path\\to\\archive.tar.gz
    File file = new File(filePath);
    String fileName = file.getName();
    String fileExtension = getFileExtension(filePath);

    if (fileExtension.isEmpty()) {
      return fileName;
    }

    return fileName.replace("." + fileExtension, "");
  }
}
