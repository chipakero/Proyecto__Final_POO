/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paanel;

/**
 *
 * @author Diego
 */
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sound {
	
	private AudioClip clip;
	   private URL url = null;
	
	
	public Sound (String fileName) {
		try {
                    url = new URL("file:soundtrack.wav");
                   clip = Applet.newAudioClip(url);
                 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							clip.stop();
							clip.play();
						}
					}
				}.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stop(){
		if(clip == null) return;
		clip.stop();
	}
	
	public void loop() {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							
							clip.loop();
						}
					}
				}.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
