/*
 * Copyright (C) 2015 Working Group on Joint Research, University Medical Center Mainz
 * Copyright (C) since 2016 The Samply Community
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 *
 * Additional permission under GNU GPL version 3 section 7:
 *
 * If you modify this Program, or any covered work, by linking or combining it
 * with Jersey (https://jersey.java.net) (or a modified version of that
 * library), containing parts covered by the terms of the General Public
 * License, version 2.0, the licensors of this Program grant you additional
 * permission to convey the resulting work.
 */

package de.samply.config.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The FileFinderUtil can be used to find files in the filesystem, depending on
 * the operating system and system configuration.
 */
public class FileFinderUtil {

    /**
     * Disable instantiation.
     */
    private FileFinderUtil() {
    }

    private static final Logger logger = LoggerFactory.getLogger(FileFinderUtil.class);

    /**
     * Searches all known paths for the given file name and returns the first
     * file it finds. Uses "samply" as prefix and no fallback.
     *
     * @param file The filename
     * @return the {@link java.io.File} handle.
     * @throws java.io.FileNotFoundException if file could not be found.
     */
    public static File findFile(String file) throws FileNotFoundException {
        return findFile(file, "samply", null);
    }

    /**
     * Searches all known paths and the fallback path for the given file name and returns the first
     * file it finds.
     *
     * @param file     The filename
     * @param prefix   The project prefix, e.g. "samply" or "osse"
     * @param fallback The fallback folder. The $fallback/(conf|classes) folders will be included in the search path. May be null.
     * @return the {@link java.io.File} handle.
     * @throws java.io.FileNotFoundException if file could not be found.
     */
    public static File findFile(String file, String prefix, String fallback) throws FileNotFoundException {
        return findFile(file, getConfigurationDirs(prefix, fallback));
    }

    /**
     * Searches all known paths for the given file name and returns
     * the first file it finds. Uses "samply" as prefix.
     *
     * @param file   The filename
     * @param prefix The fallback folder. The $fallback/(conf|classes) folders will be included in the search path. May be null.
     * @return the {@link java.io.File} handle.
     * @throws java.io.FileNotFoundException if file could not be found.
     */
    public static File findFile(String file, String prefix) throws FileNotFoundException {
        return findFile(file, getConfigurationDirs(prefix, null));
    }

    /**
     * Searches the file in the given folders and returns the first file it finds
     *
     * @param file    The filename
     * @param folders The list of folders that will be searched.
     * @return the {@link java.io.File} handle.
     * @throws java.io.FileNotFoundException if file could not be found.
     */
    public static File findFile(String file, List<String> folders) throws FileNotFoundException {
        for (String path : folders) {
            logger.debug("Checking " + path + " for the file " + file);
            File input = new File(path + File.separator + file);
            if (input.exists()) {
                logger.info("File found: " + input.getAbsolutePath());
                return input;
            }
        }
        throw new FileNotFoundException(file);
    }

    /**
     * Returns the directory for log files.
     *
     * @param prefix The project prefix, e.g. "samply" or "osse"
     * @return The path to the log dir.
     */
    public static String getLogDir(String prefix) {
        String prefixLower = prefix.toLowerCase();
        String env = prefix.toUpperCase() + "_LOGDIR";
        String prop = prefixLower + ".logdir";

        if (System.getProperty(prop) != null) {
            return System.getProperty(prop);
        }

        if (System.getenv(env) != null) {
            return System.getenv(env);
        }

        switch (OSFamily.getCurrent()) {
            case LINUX:
                logger.info("Linux operating system detected");
                return "/var/log/" + prefixLower + File.separator;

            case MAC:
                logger.info("MacOS system detected");
                return "/var/log/" + prefixLower + File.separator;

            case WINDOWS:
                try {
                    logger.info("Windows operating system detected");
                    return WinRegistry.readString(WinRegistry.HKEY_LOCAL_MACHINE,
                            "SOFTWARE\\" + prefix.toUpperCase(), "LogDir", 0);
                } catch (Exception e) {
                    logger.error("Exception thrown reading the windows registry: ", e);
                    logger.debug("ignoring the windows registry");
                }
                return null;

            default:
                logger.info("Unknown operating system...");
                return null;
        }
    }

    /**
     * Returns all known folders for configuration files. Order:
     * <pre>
     * 1. Java OPTs (${prefix}.confdir)
     * 2. Environment variable  (${PREFIX}_CONFDIR)
     * 3. OS specific user-edited (/etc/${prefix} or Windows registry entry)
     * 4. OS specific (/usr/local/share/${prefix} or Windows registry entry)
     * 5. User folder ($HOME/.config/${prefix})
     * 6. Fallback (classes/, conf/)
     * </pre>
     *
     * @param prefix       The project prefix, e.g. "samply" or "osse"
     * @param fallbackRoot The fallback folder. The $fallback/(conf|classes) folders will be included in the search path. May be null.
     * @return a list of paths to configuration folders.
     */
    public static List<String> getConfigurationDirs(String prefix, String fallbackRoot) {
        List<String> target = new LinkedList<>();

        if (prefix != null) {
            String prefixLower = prefix.toLowerCase();
            String env = prefix.toUpperCase() + "_CONFDIR";
            String prop = prefixLower + ".confdir";

            if (System.getProperty(prop) != null) {
                target.add(System.getProperty(prop));
            }

            if (System.getenv(env) != null) {
                target.add(System.getenv(env));
            }

            target.add(System.getProperty("user.home") + File.separator + ".config" + File.separator + prefixLower + File.separator);

            switch (OSFamily.getCurrent()) {
                case LINUX:
                    target.add("/etc/" + prefixLower + File.separator);
                    target.add("/usr/local/share/" + prefixLower + File.separator);
                    logger.info("Linux operating system detected");
                    break;

                case MAC:
                    target.add("/etc/" + prefixLower + File.separator);
                    target.add("/usr/local/share/" + prefixLower + File.separator);
                    logger.info("MacOS system detected");
                    break;

                case WINDOWS:
                    try {
                        String confDirValue = WinRegistry.readString(WinRegistry.HKEY_LOCAL_MACHINE,
                                "SOFTWARE\\" + prefix.toUpperCase(), "ConfDir", 0);

                        logger.info("Windows operating system detected");
                        if (confDirValue != null) {
                            target.add(confDirValue);
                            logger.debug("Registry key for conf dir found!");
                        } else {
                            logger.debug("Registry key for conf dir not found! Skipping...");
                        }

                        String confDistDirValue = WinRegistry.readString(WinRegistry.HKEY_LOCAL_MACHINE,
                                "SOFTWARE\\" + prefix.toUpperCase(), "ConfDistDir", 0);
                        if (confDistDirValue != null) {
                            target.add(confDistDirValue);
                            logger.debug("Registry key for conf dist dir found!");
                        } else {
                            logger.debug("Registry key for conf dist dir not found! Skipping...");
                        }
                        break;
                    } catch (Exception e) {
                        // The key does not exist... just ignore
                        logger.error("Exception reading the registry: ", e);
                        logger.debug("ignoring the windows registry");
                    }

                default:
                    logger.info("Unknown operating system...");
            }
        } else {
            logger.info("No prefix defined, only running fallback and deployed directories.");
        }

        if (fallbackRoot != null) {
            target.add(fallbackRoot + File.separator + "classes" + File.separator);
            target.add(fallbackRoot + File.separator + "test-classes" + File.separator);
            target.add(fallbackRoot + File.separator + "conf" + File.separator);
            target.add(fallbackRoot + File.separator + "classes" + File.separator + "conf" + File.separator);
            target.add(fallbackRoot + File.separator + "test-classes" + File.separator + "conf" + File.separator);
        } else {
            target.add("classes" + File.separator);
            target.add("test-classes" + File.separator);
            target.add("conf" + File.separator);
            target.add("classes" + File.separator + "conf" + File.separator);
            target.add("test-classes" + File.separator + "conf" + File.separator);
        }

        return target;
    }

    /**
     * Returns a list of files from the first ${name}.d directory it finds.
     *
     * @param prefix The project name (e.g. "auth")
     * @param name   The project prefix, e.g. "samply" or "osse"
     * @return A list of file handles for user configuration files.
     */
    public static List<File> getUserConfigFiles(String name, String prefix) {
        String folderName = name + ".d";

        for (String path : getConfigurationDirs(prefix, null)) {
            logger.debug("Checking " + path + " for the folder " + folderName);
            File input = new File(path + File.separator + folderName);
            if (input.exists() && input.isDirectory()) {
                logger.info("User Config Folder found: " + input.getAbsolutePath());

                /**
                 * Make sure that all file handles are indeed files
                 */
                File[] filesArray = input.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.isFile();
                    }
                });

                if (filesArray != null) {
                    List<File> files = Arrays.asList(filesArray);

                    /**
                     * And sort them!
                     */
                    Collections.sort(files);
                    return files;
                } else {
                    return Collections.emptyList();
                }
            }
        }

        return Collections.emptyList();
    }
}
