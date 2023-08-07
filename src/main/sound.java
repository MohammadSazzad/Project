package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class sound {
    Clip clip;
    URL soundURL[]= new URL[30];
    public sound(){
        soundURL[0]=getClass().getResource("/sound/sci-fi-survival-dreamscape-6319.wav");
        soundURL[1]=getClass().getResource("/sound/mixkit-achievement-completed-2068.wav");
        soundURL[2]=getClass().getResource("/sound/Unlock.wav");
        soundURL[3]=getClass().getResource("/sound/Background_music.wav");
    }
    public void setFile(int i){
        try{
            AudioInputStream ais= AudioSystem.getAudioInputStream(soundURL[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
