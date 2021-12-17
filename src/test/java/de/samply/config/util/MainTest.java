package de.samply.config.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MainTest {

  protected static final Logger logger = LoggerFactory.getLogger(MainTest.class);


  public static void main(String[] args) {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = myDateObj.format(myFormatObj);

    logger.info("This is a Test");
    File f = new File("logs/log-" + formattedDate + ".txt");
    if (f.exists() && !f.isDirectory()) {
      System.out.println("Succes");
    } else{
      System.out.println("File not found");
    }
  }
}

