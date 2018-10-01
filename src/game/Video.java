package game;

import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Video 
{
	  static MediaPlayer videoRecipes;
	  static MediaPlayer videoTutorial;
	  public static void tutorial(JFXPanel fxPanel) {
	      Scene scene = createTutorial();
	      fxPanel.setScene(scene);
	  }
	  
	  public static Scene createTutorial()
	  {
		  	File file = new File("./Video/leila.mp4");
			
			String path = file.toURI().toASCIIString();
			
			videoTutorial = new MediaPlayer(new Media(path));
			
		  	Group  root  =  new  Group(new MediaView(videoTutorial));
	      	Scene  scene  =  new  Scene(root);
		  	
	      	videoTutorial.play();
		    
		    return (scene);
	  }
	  
	  public static void stopTutorial()
	  {
		  videoTutorial.stop();
	  }
	  
	  public static void intro(JFXPanel fxPanel) {
	      Scene scene = createIntro();
	      fxPanel.setScene(scene);
	  }
	  
	  public static Scene createIntro()
	  {
		  	File file = new File("./Video/intro.mp4");
			
			String path = file.toURI().toASCIIString();
			
			MediaPlayer video = new MediaPlayer(new Media(path));
			
		  	Group  root  =  new  Group(new MediaView(video));
	      	Scene  scene  =  new  Scene(root);
		  	
		    video.play();
		    
		    return (scene);
	  }
	  
	  public static void token(int i,JFXPanel fxPanel) {
	      Scene scene = createToken(i);
	      fxPanel.setScene(scene);
	  }
	  
	  public static Scene createToken(int i)
	  {
		  	File file = new File("./Video/Lancio "+i+".mp4");
			
			String path = file.toURI().toASCIIString();
			
			MediaPlayer video = new MediaPlayer(new Media(path));
			
		  	Group  root  =  new  Group(new MediaView(video));
	      	Scene  scene  =  new  Scene(root);
		  	
		    video.play();
		    
		    return (scene);
	  }
	  
	  public static void dice1(JFXPanel fxPanel) {
	      Scene scene = createDice1();
	      fxPanel.setScene(scene);
	  }
	  
	  public static Scene createDice1()
	  {
		  	File file = new File("./Video/dadi/dado gira.mp4");
			
			String path = file.toURI().toASCIIString();
			
			MediaPlayer video = new MediaPlayer(new Media(path));
			
		  	Group  root  =  new  Group(new MediaView(video));
	      	Scene  scene  =  new  Scene(root);
		  	
		    video.play();
		    
		    return (scene);
	  }
	  
	  public static void dice2(int i,JFXPanel fxPanel) {
	      Scene scene = createDice2(i);
	      fxPanel.setScene(scene);
	  }
	  
	  public static Scene createDice2(int i)
	  {
		  	File file = new File("./Video/dadi/"+i+".mp4");
			
			String path = file.toURI().toASCIIString();
			
			MediaPlayer video = new MediaPlayer(new Media(path));
			
		  	Group  root  =  new  Group(new MediaView(video));
	      	Scene  scene  =  new  Scene(root);
		  	
		    video.play();
		    
		    return (scene);
	  }
	  
	  public static void recipes(int i,JFXPanel fxPanel) {
	      Scene scene = createRecipes(i);
	      fxPanel.setScene(scene);
	  }
	  
	  public static Scene createRecipes(int i)
	  {
		  	File file = new File("./Video/"+i+".mp4");
			
			String path = file.toURI().toASCIIString();
			
			videoRecipes = new MediaPlayer(new Media(path));
			
		  	Group  root  =  new  Group(new MediaView(videoRecipes));
	      	Scene  scene  =  new  Scene(root);
		  	
	      	videoRecipes.play();
		    
		    return (scene);
	  }
	  
	  public static void stopRecipes()
	  {
		  videoRecipes.stop();
	  }
	  
	  public static void ripalimosani(JFXPanel fxPanel) {
	      Scene scene = createRipalimosani();
	      fxPanel.setScene(scene);
	  }
	  
	  public static Scene createRipalimosani()
	  {
		  	File file = new File("./Video/6.mp4");
			
			String path = file.toURI().toASCIIString();
			
			MediaPlayer video = new MediaPlayer(new Media(path));
			
		  	Group  root  =  new  Group(new MediaView(video));
	      	Scene  scene  =  new  Scene(root);
		  	
		    video.play();
		    
		    return (scene);
	  }
	  
	  public static void credits(JFXPanel fxPanel) {
	      Scene scene = createCredits();
	      fxPanel.setScene(scene);
	  }
	  
	  public static Scene createCredits()
	  {
		  	File file = new File("./Video/credits.mp4");
			
			String path = file.toURI().toASCIIString();
			
			MediaPlayer video = new MediaPlayer(new Media(path));
			
		  	Group  root  =  new  Group(new MediaView(video));
	      	Scene  scene  =  new  Scene(root);
		  	
		    video.play();
		    
		    return (scene);
	  }
}
