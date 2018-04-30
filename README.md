# loglib
Basic logging library.

## Basic Example
```
Class LogTester : Loggable {
  override fun getTAG() : String { return "LogTester" }
  
  fun doStuff() {
    Logger.log(this, "A log message", Logger.levels.DEBUG)
    Logger.log(this, "A Warning", Logger.levels.WARNING)
  }
}
```

The Logger class has a collection of Handlers to manage the recording of messages. By default, a single handler is attached to the Logger.
More Handler classes can be added by calling `Logger.addHandler(h : Handler)` function. 

The Logger class can add a FileHandler, a Handler class that writes the log messages to a log file, by simply calling `Logger.enableFileLogging()`.

Custom Handlers can be created easily, by implementing the `Handler` interface.

## Filtering and Log Levels
Logger can create messages on a multitude of different 'importance levels'. Messages and Handlers can both be assigned a log level to work from.
