# Command Line Audio Player

A simple audio player that allows you to play, stop, reset, and loop an audio file from the command line.

## Usage
Compile code:
```
cd src
javac AudioPlayer.java
```

Run the program and enter your choice when prompted:

```
java AudioPlayer
[option]
```
```
Options
    p  -  Play audio
    s  -  Stop audio
    r  -  Reset audio playback to the beginning
    l  -  Loop audio playback
    q  -  Quit the program
```

## Notes
- Currently only supports `.wav` audio file format, other audio formats will result in an error.
- Default audio is already provided, but you can also add your audio files to the `/audio` directory and play them by updating this code on line 12:
```
String audioFile = "YourAudioFileName";
```
