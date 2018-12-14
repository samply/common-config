# Samply Common Config

This library offers utilities to find and deserialize configuration files
depending on the operating system. It also offers configuration objects that
have been created from XSD files with `xjc`.


## Usage

The application must use a `prefix`, which defines the properties and
environment variables that are used to find the requested file.

Use the FileFinderUtil to find a configuration file, e.g.

```
File file = FileFinderUtil.findFile("config.xml", "samply");
```

The FileFinderUtil will now search for the `config.xml` file
in the following locations:

- location defined by the Java property `samply.confdir` (defined at runtime with the `-Dsamply.confdir` argument)
- location defined by the environment variable `SAMPLY_CONFDIR` (defined at runtime with `SAMPLY_CONFDIR=`)
- user home directory (`~/.config/samply/`, e.g. `home/paul/.config/samply` on Linux, `C:\Users\paul\.config\samply` on Windows)
- OS Specific location (e.g. `/etc/samply/` for Linux, uses the location
  defined in the Registry `HKEY_LOCAL_MACHINE/SOFTWARE/SAMPLY/ConfDir` for
Windows Systems) for files that are likely to be changed by the user/administrator
- OS Specific location (e.g. `/usr/local/share/` for Linux, uses the location
  defined in the Registry `HKEY_LOCAL_MACHINE/SOFTWARE/SAMPLY/ConfDistDir` for
Windows Systems) for files that remain untouched
- the location defined by the `fallback` parameter, if there is one


You can also use the JAXBUtil to deserialize an XML file into an object. If possible you
should use the ObjectFactory in the JAXBContext, e.g.

```
Postgresql sql = JAXBUtil.unmarshall(file, JAXBContext.newInstance(ObjectFactory.class), Postgresql.class);
```

This method will unmarshall the given file into a Postgresql instance.


## Build

Use maven to build the jar:

```
mvn clean package
```

Use it as a dependency:

```xml
<dependency>
    <groupId>de.mig.samply</groupId>
    <artifactId>common-config</artifactId>
    <version>VERSION</version>
</dependency>
```
