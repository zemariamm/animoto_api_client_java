package com.animoto.api.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil {
  public static String readFile(String fileName) throws Exception {
    File file = new File(fileName);
    StringBuffer contents = new StringBuffer();
    BufferedReader reader = null;

    try {
      reader = new BufferedReader(new FileReader(file));
      String text = null;

      // repeat until all lines is read
      while ((text = reader.readLine()) != null) {
        contents.append(text).append(System.getProperty("line.separator"));
      }
    } 
    catch (FileNotFoundException e) {
      throw new Exception(e);
    } 
    catch (IOException e) {
      throw new Exception(e);
    } 
    finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } 
      catch (IOException e) {}
    }
    return contents.toString();
  }
}
