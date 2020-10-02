package de.samply.config.util;

/**
 * The OS family describes the operating system family in an easier way than "os.name" from the
 * system properties.
 */
public enum OsFamily {
  LINUX,
  WINDOWS,
  MAC,
  UNKNOWN;

  /**
   * Returns the OS family of this system.
   *
   * @return a {@link OsFamily} object.
   */
  public static OsFamily getCurrent() {
    String osName = System.getProperty("os.name");

    if (osName.toLowerCase().startsWith("windows")) {
      return OsFamily.WINDOWS;
    }

    if (osName.toLowerCase().equals("linux")) {
      return OsFamily.LINUX;
    }

    if (osName.toLowerCase().startsWith("mac os")) {
      return OsFamily.MAC;
    }

    return OsFamily.UNKNOWN;
  }
}
