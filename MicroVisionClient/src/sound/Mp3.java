package sound;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Mp3 {
    @SuppressWarnings("unused")

    public Mp3() { }

    static java.io.BufferedInputStream BufferedInputStream;
    static java.io.FileInputStream FileInputStream;
    static Player player;

    public static void playMp3(String name) throws JavaLayerException {
        try {
            setSound(name);
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        player = new Player(BufferedInputStream);
        player.play();

    }

    public static void setSound(String option) throws FileNotFoundException{
        switch (option){
            case "1": FileInputStream = new FileInputStream("Ping.mp3");
                BufferedInputStream = new BufferedInputStream(FileInputStream);
                break;
                default:
                    break;
            }
        }
    }
