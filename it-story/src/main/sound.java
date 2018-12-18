package main;

import java.applet.*;
import java.net.URL;

public class sound {

    URL url = sound.class.getResource("jump.wav");
    URL background1 = sound.class.getResource("001.wav");
    URL background2 = sound.class.getResource("002.wav");
    URL background3 = sound.class.getResource("003.wav");
    URL background4 = sound.class.getResource("004.wav");

    AudioClip clip = Applet.newAudioClip(url);
    AudioClip clip1 = Applet.newAudioClip(background1);
    AudioClip clip2 = Applet.newAudioClip(background2);
    AudioClip clip3 = Applet.newAudioClip(background3);
    AudioClip clip4 = Applet.newAudioClip(background4);

    public sound() {
        System.out.println("sound : open");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("end");
    }

    public void jump() {
        clip.play();
        System.out.println("sound : jump");
    }

    public void background1() {
        clip1.play();
        System.out.println("sound : background1");

    }

    public void background2() {
        clip1.stop();
        clip2.play();
        System.out.println("sound : background2");
        clip1.stop();
    }

    public void background3() {
        clip2.stop();
        clip1.stop();
        clip3.play();
        System.out.println("sound : background3");

    }

    public void background4() {
        clip3.stop();
        clip4.play();
        System.out.println("sound : background4");
    }

    public void background5() {
        clip4.stop();
    }

}
