import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import javax.sound.sampled.*;

public class AudioPlayer {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException { 
        Scanner scanner = new Scanner(System.in);
        String userResponse = "";
        
        // Customize audio file
        String audioFile = "Strollin.wav";       
        File file = new File("../audio/" + audioFile);

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        while (!userResponse.equals("q")) {
            System.out.print("Options: p=play, s=stop, r=reset, l=loop, q=quit | Enter choice: ");
            userResponse = scanner.next().toLowerCase().trim();

            switch (userResponse) {
                case "p":
                    // Start playing audio
                    clip.start();
                    break;
                case "s":
                    // Stop audio playback
                    clip.stop(); 
                    break;
                case "r":
                    // Reset playback to the beginning
                    clip.setMicrosecondPosition(0);
                    break;
                case "l":
                    // Loop audio
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    clip.setFramePosition(0);

                    // Break out of loop
                    System.out.print("Playing audio in a loop. Press Enter to stop...");
                    System.in.read();
                    clip.stop();
                    break;
                case "q":
                    // Quit audio player 
                    clip.close(); 
                    break;               
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        }

        scanner.close();
        audioStream.close();
        System.out.println("Player closed.");
    }
}