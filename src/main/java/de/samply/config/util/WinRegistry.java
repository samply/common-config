package de.samply.config.util;

/**
 * Pure Java Windows Registry access. Modified by petrucio@stackoverflow(828681) to add support for
 * reading (and writing but not creating/deleting keys) the 32-bits registry view from a 64-bits JVM
 * (KEY_WOW64_32KEY) and 64-bits view from a 32-bits JVM (KEY_WOW64_64KEY).
 * ***************************************************************************
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.Preferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Util used to access the windows registry.
 */
public class WinRegistry {

  private static final Logger logger = LoggerFactory.getLogger(WinRegistry.class);

  /**
   * Constant <code>HKEY_CURRENT_USER=0x80000001</code>.
   */
  public static final int HKEY_CURRENT_USER = 0x80000001;
  /**
   * Constant <code>HKEY_LOCAL_MACHINE=0x80000002</code>.
   */
  public static final int HKEY_LOCAL_MACHINE = 0x80000002;
  /**
   * Constant <code>REG_SUCCESS=0</code>.
   */
  public static final int REG_SUCCESS = 0;
  /**
   * Constant <code>REG_NOTFOUND=2</code>.
   */
  public static final int REG_NOTFOUND = 2;
  /**
   * Constant <code>REG_ACCESSDENIED=5</code>.
   */
  public static final int REG_ACCESSDENIED = 5;

  /**
   * Constant <code>KEY_WOW64_32KEY=0x0200</code>.
   */
  public static final int KEY_WOW64_32KEY = 0x0200;
  /**
   * Constant <code>KEY_WOW64_64KEY=0x0100</code>.
   */
  public static final int KEY_WOW64_64KEY = 0x0100;

  private static final int KEY_ALL_ACCESS = 0xf003f;
  private static final int KEY_READ = 0x20019;
  private static final Preferences userRoot = Preferences.userRoot();
  private static final Preferences systemRoot = Preferences.systemRoot();
  private static final Class<? extends Preferences> userClass = userRoot.getClass();
  private static Method regOpenKey = null;
  private static Method regCloseKey = null;
  private static Method regQueryValueEx = null;
  private static Method regEnumValue = null;
  private static Method regQueryInfoKey = null;
  private static Method regEnumKeyEx = null;
  private static Method regCreateKeyEx = null;
  private static Method regSetValueEx = null;
  private static Method regDeleteKey = null;
  private static Method regDeleteValue = null;

  static {
    try {
      regOpenKey =
          userClass.getDeclaredMethod("WindowsRegOpenKey", int.class, byte[].class, int.class);
      regOpenKey.setAccessible(true);
      regCloseKey = userClass.getDeclaredMethod("WindowsRegCloseKey", int.class);
      regCloseKey.setAccessible(true);
      regQueryValueEx =
          userClass.getDeclaredMethod("WindowsRegQueryValueEx", int.class, byte[].class);
      regQueryValueEx.setAccessible(true);
      regEnumValue =
          userClass.getDeclaredMethod("WindowsRegEnumValue", int.class, int.class, int.class);
      regEnumValue.setAccessible(true);
      regQueryInfoKey = userClass.getDeclaredMethod("WindowsRegQueryInfoKey1", int.class);
      regQueryInfoKey.setAccessible(true);
      regEnumKeyEx =
          userClass.getDeclaredMethod("WindowsRegEnumKeyEx", int.class, int.class, int.class);
      regEnumKeyEx.setAccessible(true);
      regCreateKeyEx =
          userClass.getDeclaredMethod("WindowsRegCreateKeyEx", int.class, byte[].class);
      regCreateKeyEx.setAccessible(true);
      regSetValueEx =
          userClass.getDeclaredMethod(
              "WindowsRegSetValueEx", int.class, byte[].class, byte[].class);
      regSetValueEx.setAccessible(true);
      regDeleteValue =
          userClass.getDeclaredMethod("WindowsRegDeleteValue", int.class, byte[].class);
      regDeleteValue.setAccessible(true);
      regDeleteKey = userClass.getDeclaredMethod("WindowsRegDeleteKey", int.class, byte[].class);
      regDeleteKey.setAccessible(true);
    } catch (Throwable e) {
      logger.error(e.getMessage(), e);
    }
  }

  private WinRegistry() {
  }

  /**
   * Read a value from key and value name.
   *
   * @param hkey      HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
   * @param key       a {@link java.lang.String} object.
   * @param valueName a {@link java.lang.String} object.
   * @param wow64     0 for standard registry access (32-bits for 32-bit app, 64-bits for 64-bits
   *                  app) or KEY_WOW64_32KEY to force access to 32-bit registry view, or
   *                  KEY_WOW64_64KEY to force access to 64-bit registry view
   * @return the value
   * @throws java.lang.IllegalArgumentException          if any.
   * @throws java.lang.IllegalAccessException            if any.
   * @throws java.lang.reflect.InvocationTargetException if any.
   */
  public static String readString(int hkey, String key, String valueName, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    if (hkey == HKEY_LOCAL_MACHINE) {
      return readString(systemRoot, hkey, key, valueName, wow64);
    } else if (hkey == HKEY_CURRENT_USER) {
      return readString(userRoot, hkey, key, valueName, wow64);
    } else {
      throw new IllegalArgumentException("hkey=" + hkey);
    }
  }

  private static String readString(Preferences root, int hkey, String key, String value, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    int[] handles =
        (int[])
            regOpenKey.invoke(
                root,
                new Object[]{
                    Integer.valueOf(hkey), toCstr(key), Integer.valueOf(KEY_READ | wow64)
                });
    if (handles[1] != REG_SUCCESS) {
      return null;
    }
    byte[] valb =
        (byte[])
            regQueryValueEx.invoke(root, new Object[]{Integer.valueOf(handles[0]), toCstr(value)});
    regCloseKey.invoke(root, Integer.valueOf(handles[0]));
    return (valb != null ? new String(valb, StandardCharsets.UTF_8).trim() : null);
  }

  /**
   * Read value(s) and value name(s) form given key.
   *
   * @param hkey  HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
   * @param key   a {@link java.lang.String} object.
   * @param wow64 0 for standard registry access (32-bits for 32-bit app, 64-bits for 64-bits app)
   *              or KEY_WOW64_32KEY to force access to 32-bit registry view, or KEY_WOW64_64KEY to
   *              force access to 64-bit registry view
   * @return the value name(s) plus the value(s)
   * @throws java.lang.IllegalArgumentException          if any.
   * @throws java.lang.IllegalAccessException            if any.
   * @throws java.lang.reflect.InvocationTargetException if any.
   */
  public static Map<String, String> readStringValues(int hkey, String key, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    if (hkey == HKEY_LOCAL_MACHINE) {
      return readStringValues(systemRoot, hkey, key, wow64);
    } else if (hkey == HKEY_CURRENT_USER) {
      return readStringValues(userRoot, hkey, key, wow64);
    } else {
      throw new IllegalArgumentException("hkey=" + hkey);
    }
  }

  private static Map<String, String> readStringValues(
      Preferences root, int hkey, String key, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    HashMap<String, String> results = new HashMap<String, String>();
    int[] handles =
        (int[])
            regOpenKey.invoke(
                root,
                new Object[]{
                    Integer.valueOf(hkey), toCstr(key), Integer.valueOf(KEY_READ | wow64)
                });
    if (handles[1] != REG_SUCCESS) {
      return null;
    }
    int[] info = (int[]) regQueryInfoKey.invoke(root, new Object[]{Integer.valueOf(handles[0])});

    int count = info[2]; // count
    int maxlen = info[3]; // value length max
    for (int index = 0; index < count; index++) {
      byte[] name =
          (byte[])
              regEnumValue.invoke(
                  root,
                  new Object[]{
                      Integer.valueOf(handles[0]), Integer.valueOf(index),
                      Integer.valueOf(maxlen + 1)
                  });
      String value = readString(hkey, key, new String(name, StandardCharsets.UTF_8), wow64);
      results.put(new String(name, StandardCharsets.UTF_8).trim(), value);
    }
    regCloseKey.invoke(root, Integer.valueOf(handles[0]));
    return results;
  }

  /**
   * Read the value name(s) from a given key.
   *
   * @param hkey  HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
   * @param key   a {@link java.lang.String} object.
   * @param wow64 0 for standard registry access (32-bits for 32-bit app, 64-bits for 64-bits app)
   *              or KEY_WOW64_32KEY to force access to 32-bit registry view, or KEY_WOW64_64KEY to
   *              force access to 64-bit registry view
   * @return the value name(s)
   * @throws java.lang.IllegalArgumentException          if any.
   * @throws java.lang.IllegalAccessException            if any.
   * @throws java.lang.reflect.InvocationTargetException if any.
   */
  public static List<String> readStringSubKeys(int hkey, String key, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    if (hkey == HKEY_LOCAL_MACHINE) {
      return readStringSubKeys(systemRoot, hkey, key, wow64);
    } else if (hkey == HKEY_CURRENT_USER) {
      return readStringSubKeys(userRoot, hkey, key, wow64);
    } else {
      throw new IllegalArgumentException("hkey=" + hkey);
    }
  }

  private static List<String> readStringSubKeys(Preferences root, int hkey, String key, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    List<String> results = new ArrayList<String>();
    int[] handles =
        (int[])
            regOpenKey.invoke(
                root,
                new Object[]{
                    Integer.valueOf(hkey), toCstr(key), Integer.valueOf(KEY_READ | wow64)
                });
    if (handles[1] != REG_SUCCESS) {
      return null;
    }
    int[] info = (int[]) regQueryInfoKey.invoke(root, new Object[]{Integer.valueOf(handles[0])});

    int count = info[0]; // Fix: info[2] was being used here with wrong
    // results. Suggested by davenpcj, confirmed by
    // Petrucio
    int maxlen = info[3]; // value length max
    for (int index = 0; index < count; index++) {
      byte[] name =
          (byte[])
              regEnumKeyEx.invoke(
                  root,
                  new Object[]{
                      Integer.valueOf(handles[0]), Integer.valueOf(index),
                      Integer.valueOf(maxlen + 1)
                  });
      results.add(new String(name, StandardCharsets.UTF_8).trim());
    }
    regCloseKey.invoke(root, Integer.valueOf(handles[0]));
    return results;
  }

  /**
   * Create a key.
   *
   * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
   * @param key  a {@link java.lang.String} object.
   * @throws java.lang.IllegalArgumentException          if any.
   * @throws java.lang.IllegalAccessException            if any.
   * @throws java.lang.reflect.InvocationTargetException if any.
   */
  public static void createKey(int hkey, String key)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    int[] ret;
    if (hkey == HKEY_LOCAL_MACHINE) {
      ret = createKey(systemRoot, hkey, key);
      regCloseKey.invoke(systemRoot, Integer.valueOf(ret[0]));
    } else if (hkey == HKEY_CURRENT_USER) {
      ret = createKey(userRoot, hkey, key);
      regCloseKey.invoke(userRoot, Integer.valueOf(ret[0]));
    } else {
      throw new IllegalArgumentException("hkey=" + hkey);
    }
    if (ret[1] != REG_SUCCESS) {
      throw new IllegalArgumentException("rc=" + ret[1] + "  key=" + key);
    }
  }

  private static int[] createKey(Preferences root, int hkey, String key)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    return (int[]) regCreateKeyEx.invoke(root, new Object[]{Integer.valueOf(hkey), toCstr(key)});
  }

  /**
   * Write a value in a given key/value name.
   *
   * @param hkey      a int.
   * @param key       a {@link java.lang.String} object.
   * @param valueName a {@link java.lang.String} object.
   * @param value     a {@link java.lang.String} object.
   * @param wow64     0 for standard registry access (32-bits for 32-bit app, 64-bits for 64-bits
   *                  app) or KEY_WOW64_32KEY to force access to 32-bit registry view, or
   *                  KEY_WOW64_64KEY to force access to 64-bit registry view
   * @throws java.lang.IllegalArgumentException          if any.
   * @throws java.lang.IllegalAccessException            if any.
   * @throws java.lang.reflect.InvocationTargetException if any.
   */
  public static void writeStringValue(
      int hkey, String key, String valueName, String value, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    if (hkey == HKEY_LOCAL_MACHINE) {
      writeStringValue(systemRoot, hkey, key, valueName, value, wow64);
    } else if (hkey == HKEY_CURRENT_USER) {
      writeStringValue(userRoot, hkey, key, valueName, value, wow64);
    } else {
      throw new IllegalArgumentException("hkey=" + hkey);
    }
  }

  private static void writeStringValue(
      Preferences root, int hkey, String key, String valueName, String value, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    int[] handles =
        (int[])
            regOpenKey.invoke(
                root,
                new Object[]{
                    Integer.valueOf(hkey), toCstr(key), Integer.valueOf(KEY_ALL_ACCESS | wow64)
                });
    regSetValueEx.invoke(root, Integer.valueOf(handles[0]), toCstr(valueName), toCstr(value));
    regCloseKey.invoke(root, Integer.valueOf(handles[0]));
  }

  /**
   * delete a value from a given key/value name.
   *
   * @param hkey  a int.
   * @param key   a {@link java.lang.String} object.
   * @param value a {@link java.lang.String} object.
   * @param wow64 0 for standard registry access (32-bits for 32-bit app, 64-bits for 64-bits app)
   *              or KEY_WOW64_32KEY to force access to 32-bit registry view, or KEY_WOW64_64KEY to
   *              force access to 64-bit registry view
   * @throws java.lang.IllegalArgumentException          if any.
   * @throws java.lang.IllegalAccessException            if any.
   * @throws java.lang.reflect.InvocationTargetException if any.
   */
  public static void deleteValue(int hkey, String key, String value, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    int rc = -1;
    if (hkey == HKEY_LOCAL_MACHINE) {
      rc = deleteValue(systemRoot, hkey, key, value, wow64);
    } else if (hkey == HKEY_CURRENT_USER) {
      rc = deleteValue(userRoot, hkey, key, value, wow64);
    }
    if (rc != REG_SUCCESS) {
      throw new IllegalArgumentException("rc=" + rc + "  key=" + key + "  value=" + value);
    }
  }

  // ========================================================================
  private static int deleteValue(Preferences root, int hkey, String key, String value, int wow64)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    int[] handles =
        (int[])
            regOpenKey.invoke(
                root,
                new Object[]{
                    Integer.valueOf(hkey), toCstr(key), Integer.valueOf(KEY_ALL_ACCESS | wow64)
                });
    if (handles[1] != REG_SUCCESS) {
      return handles[1]; // can be REG_NOTFOUND, REG_ACCESSDENIED
    }
    int rc =
        ((Integer)
            regDeleteValue.invoke(
                root, new Object[]{Integer.valueOf(handles[0]), toCstr(value)}))
            .intValue();
    regCloseKey.invoke(root, Integer.valueOf(handles[0]));
    return rc;
  }

  /**
   * Delete a given key.
   *
   * @param hkey a int.
   * @param key  a {@link java.lang.String} object.
   * @throws java.lang.IllegalArgumentException          if any.
   * @throws java.lang.IllegalAccessException            if any.
   * @throws java.lang.reflect.InvocationTargetException if any.
   */
  public static void deleteKey(int hkey, String key)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    int rc = -1;
    if (hkey == HKEY_LOCAL_MACHINE) {
      rc = deleteKey(systemRoot, hkey, key);
    } else if (hkey == HKEY_CURRENT_USER) {
      rc = deleteKey(userRoot, hkey, key);
    }
    if (rc != REG_SUCCESS) {
      throw new IllegalArgumentException("rc=" + rc + "  key=" + key);
    }
  }

  private static int deleteKey(Preferences root, int hkey, String key)
      throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    int rc =
        ((Integer) regDeleteKey.invoke(root, new Object[]{Integer.valueOf(hkey), toCstr(key)}))
            .intValue();
    return rc; // can REG_NOTFOUND, REG_ACCESSDENIED, REG_SUCCESS
  }

  // ========================================================================
  // utility
  private static byte[] toCstr(String str) {
    byte[] result = new byte[str.length() + 1];

    for (int i = 0; i < str.length(); i++) {
      result[i] = (byte) str.charAt(i);
    }
    result[str.length()] = 0;
    return result;
  }
}
