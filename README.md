## Overview

This repository contains an academic assignment for the course **Object-Oriented Programming**.

# PamakSense

An object-oriented Java model of a humidity sensor network. The program implements
sensors, the connections between them, and the zones in which they are placed.

## Classes

### `Sensor`
Represents a sensor in the network.

- **Fields:** name, Bluetooth address, list of connected sensors, zone (`Zone`).
- **Bluetooth address:** 6 bytes in hexadecimal form, with uppercase letters A-F,
  separated by `:` (e.g. `10:43:AC:D8:9F:0B`). If the address does not follow this
  format, the sensor is not created and an error message is printed.
- **Methods:**
  - check whether two sensors are connected (`true`/`false`)
  - connect to another sensor (bidirectional). Trying to connect a sensor to itself
    or to an already connected sensor prints an error message
  - return the list of common connections with another sensor
  - print the connected sensors
  - print the name of the zone the sensor is located in
  - print the neighbors within distance ≤ 2 in the graph (no duplicates)

### `Zone`
A zone with a name, a description and a list of sensors.

- **Placing a sensor:** the sensor is added to the zone and removed from its
  previous zone, if any.
- **Printing:** the number and names of the sensors in the zone.

### `PrecisionZone` (subclass of `Zone`)
A precision zone, in which only precision sensors can be placed, i.e. sensors whose
name starts with `Precise_`. If the restriction is not satisfied, an error message
is printed and the sensor is not placed.

### `Main`
Creates sensors and zones, makes connections and placements, and demonstrates the
functionality of the classes above in the console.

## Compile and run

From the project's `src` folder:

javac *.java
java Main


If the classes are inside a package, adjust the commands accordingly, or run the
program from the IDE (Run As → Java Application on the `Main` class).

## Author

Nikoleta Chatziandreou
