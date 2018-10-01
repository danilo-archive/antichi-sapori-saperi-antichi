package game;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
   

public class Sound
{
	Clip background;
	Clip baranello;
   
	public void playSoundBackground() 
	{
		try {
			URL url = this.getClass().getClassLoader().getResource("Living Mice remix.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         
			background = AudioSystem.getClip();
         
			background.open(audioIn);
			background.start();
			
			FloatControl volume = (FloatControl) background.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-25);//to control volume
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
   
	public void stopSoundBackground() 
	{
		background.stop();
	}
	
	public void SoundButton() 
	{
		try {
			URL url = this.getClass().getClassLoader().getResource("button.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         
			Clip clip = AudioSystem.getClip();
         
			clip.open(audioIn);
			clip.start();
         
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(0);//to control volume
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
   
	public void soundRightAnswerSound() 
	{
		try {
			URL url = this.getClass().getClassLoader().getResource("Right answer sound.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         
			Clip clip = AudioSystem.getClip();
         
			clip.open(audioIn);
			clip.start();
         
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-5);//to control volume
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
   
	public void soundWrongAnswerSound() 
	{
		try {
			URL url = this.getClass().getClassLoader().getResource("Wrong answer sound.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         
			Clip clip = AudioSystem.getClip();
         
			clip.open(audioIn);
			clip.start();
			
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(6);//to control volume(max is 6.0206)
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
         e.printStackTrace();
		}
	}

   	public void playBaranello() 
   	{
   		try {
   			URL url = this.getClass().getClassLoader().getResource("baranello.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        
			baranello = AudioSystem.getClip();
        
			baranello.open(audioIn);
			baranello.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
   
   	public void stopBaranello()
   	{
   		baranello.stop();
   	}
   	
   	public void soundDomanda() 
   	{
   		try {
   			URL url = this.getClass().getClassLoader().getResource("domanda.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        
			
			Clip clip = AudioSystem.getClip();
        
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
   
   	public void soundWin() 
   	{
   		try {
   			URL url = this.getClass().getClassLoader().getResource("Win sound.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        
			
			Clip clip = AudioSystem.getClip();
        
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}