package Games.Game1.Code;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {

    private Clip clip;

    public void playMusic(String fp){
        try{
            File musicFile = new File(fp);
            if(!musicFile.exists()){
                System.out.println("File not found !");
                return;
            }
            AudioInputStream audioSystem = AudioSystem.getAudioInputStream(musicFile);
            clip = AudioSystem.getClip();
            clip.open(audioSystem);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException e){
            e.printStackTrace();
        }
    }

    public void playEffect(String fp){
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(fp));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void stopMusic(){
        if(clip != null && clip.isRunning()){
            clip.stop();
        }
    }

}
