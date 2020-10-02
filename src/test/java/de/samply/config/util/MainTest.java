package de.samply.config.util;

import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileNotFoundException;

public class MainTest {

  public static void main(String[] args) throws FileNotFoundException {
    Configurator.initialize(null, FileFinderUtil.findFile("log4j2.xml").getAbsolutePath());

    for (File f : FileFinderUtil.getUserConfigFiles("test", "samply")) {
      System.out.println("File: " + f.getAbsolutePath());
    }
  }
}
