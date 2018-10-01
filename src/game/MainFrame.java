package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class MainFrame
{	
	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = env.getScreenDevices()[0];
	DisplayMode oldMode = device.getDisplayMode();
	DisplayMode newMode = new DisplayMode(1024,768,oldMode.getBitDepth(),oldMode.getRefreshRate());//for setting the full screen
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//use toolkit for getting the screen size
	
	Core core=new Core();
	Sound sound=new Sound();
	
	int portrait1=1;//set default portrait
    int pedina1=1;//set default token
    String name1="Giocatore 1";//set default name
    int posgioc1;//variable used for count player1's position
    JLabel pedGioc1=new JLabel();//token for player1
    
    int portrait2=2;//set default portrait
    int pedina2=2;//set default token
    String name2="Giocatore 2";//set default name
    int posgioc2;//variable used for count player2's position
    JLabel pedGioc2=new JLabel();//token for player2
    
    int dado;
    
    String namePortrait[]={"Donna Sannita","Guerriero Sannita"};
    String nameIcon[]={"Campana di Agnone","Diavolo dei Misteri","Armi dei Sanniti","Uva Tintilia"};
    
    JFrame main=new JFrame();//main frame
    JFrame mainMenu=new JFrame();//main manu frame
    JLayeredPane choosePane = new JLayeredPane();
    JLayeredPane mainPane = new JLayeredPane();// this is mainPane in the main frame
    JLayeredPane popupPane=new JLayeredPane();//this is mainPane in secondary frame
    JLayeredPane recipesPane=new JLayeredPane();//this is used for scrolling recipes
    JLayeredPane billboard=new JLayeredPane();//needs for moving player's tokens and city's led
    
    JFXPanel videoDado1=new JFXPanel();
    JFXPanel videoDado2=new JFXPanel();//used for show dice animation
    
    JButton lanciaDado1= new JButton();
    JButton lanciaDado2= new JButton();//set throw dice's buttons here, so I can control them everywhere in the code
  
    JButton exit= new JButton();//to exit from the game
    
    boolean first;	//to choose the first player
    
    String[] città=new String[28];//an array with the name of every city
    
    BufferedImage liceo=null;
    BufferedImage imgTabellone = null;	
    BufferedImage imgDonna = null;		
	BufferedImage imgGuerriero = null;
	BufferedImage imgDonna2 = null;		
	BufferedImage imgGuerriero2 = null;
	BufferedImage imgCampana = null;
	BufferedImage imgDiavolo = null;
	BufferedImage imgScudo = null;
	BufferedImage imgUva = null;
	BufferedImage pedGuerriero = null;
	BufferedImage pedCampana = null;
	BufferedImage pedDiavolo = null;
	BufferedImage pedScudo = null;
	BufferedImage pedUva = null; 
	
	BufferedImage icon=null;
	BufferedImage imgCasella=null;
	BufferedImage imgInfoCasella=null;
	

    BufferedImage sfondo=null;
    BufferedImage sfondoPopup=null;
	BufferedImage buttonStart0=null;
    BufferedImage buttonStart1=null;
    BufferedImage buttonLearn0=null;
    BufferedImage buttonExit0=null;
    BufferedImage buttonExit1=null;
    BufferedImage buttonSkip0=null;
    
	BufferedImage ledBig=null;
	BufferedImage ledSmall=null;//to load every images
	
	HashMap<Integer, Point> idPuntiPlayer1 = new HashMap<Integer, Point>();//points for moving player1
	HashMap<Integer, Point> idPuntiPlayer2 = new HashMap<Integer, Point>();//points for moving player2
	HashMap<Integer, Point> idPuntiMappa = new HashMap<Integer, Point>();//points for city's led
	
	public void initIdPuntiPlayer1()//the point on the billboard, where player1 move
	{
		idPuntiPlayer1.clear();
		idPuntiPlayer1.put(0,new Point(64*4,64*6));
		idPuntiPlayer1.put(1,new Point(64*3,64*6));
		idPuntiPlayer1.put(2,new Point(64*2,64*6));
		idPuntiPlayer1.put(3,new Point(64,64*6));
		idPuntiPlayer1.put(4,new Point(0,64*6));
		idPuntiPlayer1.put(5,new Point(0,64*5));
		idPuntiPlayer1.put(6,new Point(0,64*4));
		idPuntiPlayer1.put(7,new Point(0,64*3));
		idPuntiPlayer1.put(8,new Point(0,64*2));
		idPuntiPlayer1.put(9,new Point(0,64));
		idPuntiPlayer1.put(10,new Point(0,0));
		idPuntiPlayer1.put(11,new Point(64,0));
		idPuntiPlayer1.put(12,new Point(64*2,0));
		idPuntiPlayer1.put(13,new Point(64*3,0));
		idPuntiPlayer1.put(14,new Point(64*4,0));
		idPuntiPlayer1.put(15,new Point(64*5,0));
		idPuntiPlayer1.put(16,new Point(64*6,0));			
		idPuntiPlayer1.put(17,new Point(64*7,0));
		idPuntiPlayer1.put(18,new Point(64*8,0));
		idPuntiPlayer1.put(19,new Point(64*8,64));
		idPuntiPlayer1.put(20,new Point(64*8,64*2));
		idPuntiPlayer1.put(21,new Point(64*8,64*3));
		idPuntiPlayer1.put(22,new Point(64*8,64*4));
		idPuntiPlayer1.put(23,new Point(64*8,64*5));
		idPuntiPlayer1.put(24,new Point(64*8,64*6));
		idPuntiPlayer1.put(25,new Point(64*7,64*6));
		idPuntiPlayer1.put(26,new Point(64*6,64*6));
		idPuntiPlayer1.put(27,new Point(64*5,64*6));
	}
	
	public void initIdPuntiPlayer2()//the point on the billboard, where player1 move
	{
		idPuntiPlayer2.clear();
		idPuntiPlayer2.put(0,new Point(64*4+32,64*6+32));
		idPuntiPlayer2.put(1,new Point(64*3+32,64*6+32));
		idPuntiPlayer2.put(2,new Point(64*2+32,64*6+32));
		idPuntiPlayer2.put(3,new Point(64+32,64*6+32));
		idPuntiPlayer2.put(4,new Point(0+32,64*6+32));
		idPuntiPlayer2.put(5,new Point(0+32,64*5+32));
		idPuntiPlayer2.put(6,new Point(0+32,64*4+32));
		idPuntiPlayer2.put(7,new Point(0+32,64*3+32));
		idPuntiPlayer2.put(8,new Point(0+32,64*2+32));
		idPuntiPlayer2.put(9,new Point(0+32,64+32));
		idPuntiPlayer2.put(10,new Point(0+32,0+32));
		idPuntiPlayer2.put(11,new Point(64+32,0+32));
		idPuntiPlayer2.put(12,new Point(64*2+32,0+32));
		idPuntiPlayer2.put(13,new Point(64*3+32,0+32));
		idPuntiPlayer2.put(14,new Point(64*4+32,0+32));
		idPuntiPlayer2.put(15,new Point(64*5+32,0+32));
		idPuntiPlayer2.put(16,new Point(64*6+32,0+32));			
		idPuntiPlayer2.put(17,new Point(64*7+32,0+32));
		idPuntiPlayer2.put(18,new Point(64*8+32,0+32));
		idPuntiPlayer2.put(19,new Point(64*8+32,64+32));
		idPuntiPlayer2.put(20,new Point(64*8+32,64*2+32));
		idPuntiPlayer2.put(21,new Point(64*8+32,64*3+32));
		idPuntiPlayer2.put(22,new Point(64*8+32,64*4+32));
		idPuntiPlayer2.put(23,new Point(64*8+32,64*5+32));
		idPuntiPlayer2.put(24,new Point(64*8+32,64*6+32));
		idPuntiPlayer2.put(25,new Point(64*7+32,64*6+32));
		idPuntiPlayer2.put(26,new Point(64*6+32,64*6+32));
		idPuntiPlayer2.put(27,new Point(64*5+32,64*6+32));
	}
	
	public void initIdMappa()//the point on billboard, used for city's led
	{
		idPuntiMappa.clear();
		idPuntiMappa.put(1,new Point(391,261));
		idPuntiMappa.put(2,new Point(220,198));
		idPuntiMappa.put(3,new Point(216,167));
		
		idPuntiMappa.put(5,new Point(113,305));
		idPuntiMappa.put(6,new Point(316,232));

		idPuntiMappa.put(8,new Point(197,178));
		idPuntiMappa.put(9,new Point(370,307));
		
		idPuntiMappa.put(11,new Point(301,208));
		idPuntiMappa.put(12,new Point(283,328));
		idPuntiMappa.put(13,new Point(295,293));
		
		idPuntiMappa.put(15,new Point(310,247));
		idPuntiMappa.put(16,new Point(407,88));			
		idPuntiMappa.put(17,new Point(309,148));
		
		idPuntiMappa.put(19,new Point(266,238));
		idPuntiMappa.put(20,new Point(157,261));
		
		idPuntiMappa.put(22,new Point(286,269));
		idPuntiMappa.put(23,new Point(97,220));
		
		idPuntiMappa.put(25,new Point(343,204));
		idPuntiMappa.put(26,new Point(288,183));
	}
	
	@SuppressWarnings("deprecation")
	public void turorial1()// show leila's video
	{
		JFrame tutorialFrame=new JFrame();//tutorial frame
		tutorialFrame.setBounds(0,0,1024,768);
		tutorialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tutorialFrame.setUndecorated(true);
		tutorialFrame.setVisible(true);
        
        JLayeredPane video=new JLayeredPane();
        video.setBounds(0,0,1024,768);
        tutorialFrame.getContentPane().add(video);//a layered pane for show video 
        
        JFXPanel leilaVideo=new JFXPanel();
        leilaVideo.setBounds(0,0,1024,768);
        leilaVideo.show();
        video.add(leilaVideo, JLayeredPane.PALETTE_LAYER);//for the videos
        
        if(device.isFullScreenSupported())//check if full screen is supported on deploy machine
		{
			device.setFullScreenWindow(tutorialFrame);
			device.setDisplayMode(newMode);//full-screen
		}
		else
		{
			tutorialFrame.setUndecorated(true);//in this way seems like a fake full-screen
		}
 		
 		Timer timer=new Timer(66000,null); //add a time to close the frame when video stops
        timer.addActionListener(new ActionListener() {
		     
			public void actionPerformed(ActionEvent ae){
		    	Video.stopTutorial();
		    	leilaVideo.hide();
		    	tutorialFrame.hide();
		    	device.setFullScreenWindow(null);}});
		    	
        JButton skip=new JButton();//a simple button that skip the video and close the frame
		skip.setBounds(64*15,(64*11)+32,64,32);
		video.add(skip, JLayeredPane.DRAG_LAYER);
		skip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
		     Video.stopTutorial();
		     leilaVideo.hide();
		     tutorialFrame.hide();
		     device.setFullScreenWindow(null);
    		 timer.stop();
		     }});
        
        timer.setRepeats(false);
        timer.start();
        
 		Platform.runLater(new Runnable() {//start video
 	          @Override
 	          public void run() 
 	          {
 	              Video.tutorial(leilaVideo);
 	          }});
 		try
 		{
 			buttonSkip0=ImageIO.read(this.getClass().getResource("/resources/layout/salta0.png"));
 			
 			skip.setIcon(new ImageIcon(buttonSkip0));
 		}catch(IOException e){}
	}
	
	public void startScreen()//frame with main menu
	{
		mainMenu.setType(Type.POPUP);
		mainMenu.setBounds((screenSize.width-448)/2,(screenSize.height-448)/2,448,448);
		mainMenu.setAlwaysOnTop(true);
		mainMenu.getContentPane().add(popupPane);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popupPane.setLayout(null);//create frame

		JLabel background=new JLabel();
		background.setBounds(0, -32,488,488);
		popupPane.add(background, JLayeredPane.DEFAULT_LAYER);//background
		
		JButton [] b=new JButton[3];//array of 3 button
		for(int i=0;i<=2;i++)
		{
			b[i]=new JButton();
			b[i].setBounds(64, 160+96*i,320, 64);
			popupPane.add(b[i], JLayeredPane.PALETTE_LAYER);
		}
		b[0].addActionListener(new ActionListener() {//start the game
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		         popupPane.removeAll();
		         popupPane.updateUI();
		         mainMenu.dispose();
		         chooseScreen();}});
		
		b[1].addActionListener(new ActionListener() {//show the video tutorial
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 turorial1();
		    	 }});
		
		b[2].addActionListener(new ActionListener() {//exit
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	System.exit(0);}});
		
		try{//set image
			icon = ImageIO.read(this.getClass().getResource("/resources/layout/icona gioco.png"));
			ImageIcon imgIcon = new ImageIcon(icon);
			mainMenu.setIconImage(imgIcon.getImage());
			
			sfondo= ImageIO.read(this.getClass().getResource("/resources/layout/background_start.jpg"));
			buttonStart0=ImageIO.read(this.getClass().getResource("/resources/layout/avvia partita0.png"));
			buttonLearn0=ImageIO.read(this.getClass().getResource("/resources/layout/impara a giocare0.png"));
			buttonExit0=ImageIO.read(this.getClass().getResource("/resources/layout/esci0.png"));
			
			b[0].setIcon(new ImageIcon(buttonStart0));
			b[1].setIcon(new ImageIcon(buttonLearn0));
			b[2].setIcon(new ImageIcon(buttonExit0));
			background.setIcon(new ImageIcon(sfondo));
		}catch(IOException e){}//set mainPane
		
		mainMenu.setResizable(false);
		mainMenu.setVisible(true);
	}

	public void chooseScreen()	//this is the frame where both player could set the name, portrait and token
	{
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setUndecorated(true);
		main.setBounds(0,0,1024,768);//the lowest resolution to fit every monitor
		main.setVisible(true);
		main.getContentPane().add(choosePane);
		
		choosePane.setLayout(null);// is easier select the layout by pixel
		
		if(device.isFullScreenSupported())
		{
			device.setFullScreenWindow(main);
			device.setDisplayMode(newMode);//full-screen
		}
		else
		{
			main.setUndecorated(true);//to make the frame like a fake full-screen
		}
		
		JFXPanel introVideo=new JFXPanel();
		introVideo.setBounds(0,0,1024,768);
		choosePane.add(introVideo, JLayeredPane.POPUP_LAYER); //used for the intro
		
		Timer timer=new Timer(10500,null);//add a timer to hide video panel after end
        timer.addActionListener(new ActionListener() {
		     @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae){
		    	introVideo.hide();
		    	choosePane.updateUI();}});
		    	
        timer.setRepeats(false);
        timer.start();
        
 		Platform.runLater(new Runnable() {//start video
 	          @Override
 	          public void run() 
 	          {
 	              Video.intro(introVideo);
 	          }});
 		
		JLabel dietro=new JLabel();
		dietro.setBounds(0,0,1024,768);
        choosePane.add(dietro, JLayeredPane.DEFAULT_LAYER);//set background
		
        JLabel[] labelChooseName=new JLabel[2];//with a string to remind players to add their name
        JTextField[] insertNamePlayer=new JTextField[2];//to add player name
        JLabel[] labelChoosePortait=new JLabel[2];//with a string to remind players to select portrait
        JLabel[] labelChoosePedine=new JLabel[2];//with a string to remind players to select icon
        JLabel[] choosePortrait=new JLabel[2];//it show your portrait choice
        JLabel[] choosePedina=new JLabel[2];//it show your icon choice
        
        int a[]={1,2};
    	String nameIconLocal[]={"Campana di Agnone","Diavolo dei Misteri"};//two array that are used in the following for block
        
        for(int i=0;i<=1;i++)//declare the arrays
        {
            labelChooseName[i]=new JLabel("Inserisci il tuo nome: ");
            labelChooseName[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            labelChooseName[i].setBounds(64+32+(64*8*i),64,(64*2)+32,32);
            choosePane.add(labelChooseName[i], JLayeredPane.PALETTE_LAYER);
            
            insertNamePlayer[i]=new JTextField("Giocatore "+a[i]);
            insertNamePlayer[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            insertNamePlayer[i].setBounds((64*4)+(64*8*i),64,(64*2)+32,32);
            choosePane.add(insertNamePlayer[i], JLayeredPane.PALETTE_LAYER);
            
            labelChoosePortait[i]=new JLabel("Scegli il tuo personaggio", SwingConstants.CENTER);
            labelChoosePortait[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            labelChoosePortait[i].setBounds(32+64+(64*8*i),64*2,64*5,32);
            choosePane.add(labelChoosePortait[i], JLayeredPane.PALETTE_LAYER);
            
            labelChoosePedine[i]=new JLabel("Scegli la tua pedina", SwingConstants.CENTER);
            labelChoosePedine[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            labelChoosePedine[i].setBounds(32+64+(64*8*i),64*6,64*5,32);
            choosePane.add(labelChoosePedine[i], JLayeredPane.PALETTE_LAYER);
            
            choosePortrait[i]=new JLabel(namePortrait[i], SwingConstants.CENTER);
            choosePortrait[i].setFont(new Font("Tahoma", Font.ITALIC, 15));
            choosePortrait[i].setBounds((64*3)+(64*8*i),(64*3)+64-(32/2),64*2,32);
            choosePane.add(choosePortrait[i], JLayeredPane.PALETTE_LAYER);
            
            choosePedina[i]=new JLabel(nameIconLocal[i], SwingConstants.CENTER);
            choosePedina[i].setFont(new Font("Tahoma", Font.ITALIC, 15));
            choosePedina[i].setBounds(64+32+(64*8*i),(64*8)+32,64*5,32);
            choosePane.add(choosePedina[i], JLayeredPane.PALETTE_LAYER);
        }
		
        JToggleButton donnaPlayer1 = new JToggleButton();
		JToggleButton guerrieroPlayer1 = new JToggleButton();
		JToggleButton campanaPlayer1 = new JToggleButton();
		JToggleButton diavoloPlayer1 = new JToggleButton();
		JToggleButton scudoPlayer1 = new JToggleButton();
		JToggleButton uvaPlayer1 = new JToggleButton();//Buttons for player1 chooses
		
		guerrieroPlayer1.setSelected(true);
		diavoloPlayer1.setSelected(true);
		scudoPlayer1.setSelected(true);
   	 	uvaPlayer1.setSelected(true);//set default player1 chooses
		
		JToggleButton donnaPlayer2 = new JToggleButton();
		JToggleButton guerrieroPlayer2 = new JToggleButton();
		JToggleButton campanaPlayer2 = new JToggleButton();
		JToggleButton diavoloPlayer2 = new JToggleButton();
		JToggleButton scudoPlayer2 = new JToggleButton();
		JToggleButton uvaPlayer2 = new JToggleButton();//Buttons for player1 chooses
		
		
		donnaPlayer2.setSelected(true);
		campanaPlayer2.setSelected(true);
		scudoPlayer2.setSelected(true);
		uvaPlayer2.setSelected(true);//set default player1 chooses
		
		JButton start=new JButton();
        start.setBounds((64*7)-16,(64*10)+64-16,(64*2)+32,64);
        choosePane.add(start, JLayeredPane.PALETTE_LAYER);
		start.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 name1=insertNamePlayer[0].getText();
		    	 name2=insertNamePlayer[1].getText();//get the text players insert into text fields for setting as players'names
		    	 insertNamePlayer[0].setEditable(false);
		    	 insertNamePlayer[1].setEditable(false);//to avoid editing after button press
		    	 
		    	 donnaPlayer2.setEnabled(false);
		    	 guerrieroPlayer2.setEnabled(false);
		    	 campanaPlayer2.setEnabled(false);
		    	 diavoloPlayer2.setEnabled(false);
		    	 scudoPlayer2.setEnabled(false);
		    	 uvaPlayer2.setEnabled(false);
		    	 
		    	 donnaPlayer1.setEnabled(false);
		    	 guerrieroPlayer1.setEnabled(false);
		    	 campanaPlayer1.setEnabled(false);
		    	 diavoloPlayer1.setEnabled(false);
		    	 scudoPlayer1.setEnabled(false);
		    	 uvaPlayer1.setEnabled(false);//to avoid change after button press 
		    	 
		    	 start.setEnabled(false);//to avoid a little bug
		    	 
		    	 turnoPopup(name1,name2);//show secondary screen to choose the first player
	    		 }});
        
        exit.setBounds((64*15),(64*11)+32, 64, 34);
        choosePane.add(exit, JLayeredPane.PALETTE_LAYER);
        exit.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	System.exit(0);}});//button to exit from the game
		
		try{ //set icons for both player1 and player2
			buttonStart1=ImageIO.read(this.getClass().getResource("/resources/layout/avvia partita_scelta.png"));
			buttonExit1=ImageIO.read(this.getClass().getResource("/resources/layout/esci1.png"));
			sfondo= ImageIO.read(this.getClass().getResource("/resources/layout/background_choose.png"));
			imgDonna = ImageIO.read(this.getClass().getResource("/resources/portrair/donna sannita(piccola).png"));
			imgGuerriero = ImageIO.read(this.getClass().getResource("/resources/portrair/guerriero sannita(piccola).png"));
			imgCampana = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina campana.png"));
			imgDiavolo = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina diavolo.png"));
			imgScudo = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina spada e scudo.png"));
			imgUva = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina uva.png"));
			
			start.setIcon(new ImageIcon(buttonStart1));
			exit.setIcon(new ImageIcon(buttonExit1));
			
			dietro.setIcon(new ImageIcon(sfondo));
			donnaPlayer1.setIcon(new ImageIcon(imgDonna));
			guerrieroPlayer1.setIcon(new ImageIcon(imgGuerriero));
			campanaPlayer1.setIcon(new ImageIcon(imgCampana));
			diavoloPlayer1.setIcon(new ImageIcon(imgDiavolo));
			scudoPlayer1.setIcon(new ImageIcon(imgScudo));
			uvaPlayer1.setIcon(new ImageIcon(imgUva));
			
			donnaPlayer2.setIcon(new ImageIcon(imgDonna));
			guerrieroPlayer2.setIcon(new ImageIcon(imgGuerriero));
			campanaPlayer2.setIcon(new ImageIcon(imgCampana));
			diavoloPlayer2.setIcon(new ImageIcon(imgDiavolo));
			scudoPlayer2.setIcon(new ImageIcon(imgScudo));
			uvaPlayer2.setIcon(new ImageIcon(imgUva));
		}catch (IOException e){}
		
		donnaPlayer1.setBounds(96,160,96,192);
		guerrieroPlayer1.setBounds(320,160,96,192);
		campanaPlayer1.setBounds(96,416,128,128);
		diavoloPlayer1.setBounds(288,416,128,128);
		scudoPlayer1.setBounds(96,576,128,128);
		uvaPlayer1.setBounds(288,576,128,128);//set buttons's propriety player1 
		
		donnaPlayer2.setBounds(606,160,96,192);
		guerrieroPlayer2.setBounds(832,160,96,192);
		campanaPlayer2.setBounds(606,416,128,128);
		diavoloPlayer2.setBounds(800,416,128,128);
		scudoPlayer2.setBounds(606,576,128,128);
		uvaPlayer2.setBounds(800,576,128,128);//set buttons's propriety player2
		
		choosePane.add(donnaPlayer1, JLayeredPane.PALETTE_LAYER);
		choosePane.add(guerrieroPlayer1, JLayeredPane.PALETTE_LAYER);
		choosePane.add(campanaPlayer1, JLayeredPane.PALETTE_LAYER);
		choosePane.add(diavoloPlayer1, JLayeredPane.PALETTE_LAYER);
		choosePane.add(scudoPlayer1, JLayeredPane.PALETTE_LAYER);
		choosePane.add(uvaPlayer1, JLayeredPane.PALETTE_LAYER);//add into main frame (player1)
		/*add listener to buttons for setting the choose of player1
		 */
		donnaPlayer1.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 donnaPlayer1.setSelected(false);
		    	 guerrieroPlayer1.setSelected(true);
		    	 choosePortrait[0].setText(namePortrait[0]);
		    	 setPortrait1(portrait1=1);}});
		      
		guerrieroPlayer1.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 donnaPlayer1.setSelected(true);
		    	 guerrieroPlayer1.setSelected(false);
		    	 choosePortrait[0].setText(namePortrait[1]);
		    	 setPortrait1(portrait1=2);}});
		     
		campanaPlayer1.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 campanaPlayer1.setSelected(false);
		    	 diavoloPlayer1.setSelected(true);
		    	 scudoPlayer1.setSelected(true);
		    	 uvaPlayer1.setSelected(true);
		    	 choosePedina[0].setText(nameIcon[0]);
		    	 setPedina1(pedina1=1);}});
		     
		diavoloPlayer1.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 campanaPlayer1.setSelected(true);
		    	 diavoloPlayer1.setSelected(false);
		    	 scudoPlayer1.setSelected(true);
		    	 uvaPlayer1.setSelected(true);
		    	 choosePedina[0].setText(nameIcon[1]);
		    	 setPedina1(pedina1=2);}});
		     
		scudoPlayer1.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 campanaPlayer1.setSelected(true);
		    	 diavoloPlayer1.setSelected(true);
		    	 scudoPlayer1.setSelected(false);
		    	 uvaPlayer1.setSelected(true);
		    	 choosePedina[0].setText(nameIcon[2]);
		    	 setPedina1(pedina1=3);}});
		     
		uvaPlayer1.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 campanaPlayer1.setSelected(true);
		    	 diavoloPlayer1.setSelected(true);
		    	 scudoPlayer1.setSelected(true);
		    	 uvaPlayer1.setSelected(false);
		    	 choosePedina[0].setText(nameIcon[3]);
		    	 setPedina1(pedina1=4);}});
		      
		choosePane.add(donnaPlayer2, JLayeredPane.PALETTE_LAYER);
		choosePane.add(guerrieroPlayer2, JLayeredPane.PALETTE_LAYER);
		choosePane.add(campanaPlayer2, JLayeredPane.PALETTE_LAYER);
		choosePane.add(diavoloPlayer2, JLayeredPane.PALETTE_LAYER);
		choosePane.add(scudoPlayer2, JLayeredPane.PALETTE_LAYER);
		choosePane.add(uvaPlayer2, JLayeredPane.PALETTE_LAYER);//add into main frame(player2)
		/*add listener to buttons for setting the choose of player1
		 */
		donnaPlayer2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 donnaPlayer2.setSelected(false);
		    	 guerrieroPlayer2.setSelected(true);
		    	 choosePortrait[1].setText(namePortrait[0]);
		    	 setPortrait2(portrait2=1);}});
		      
		guerrieroPlayer2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 donnaPlayer2.setSelected(true);
		    	 guerrieroPlayer2.setSelected(false);
		    	 choosePortrait[1].setText(namePortrait[1]);
		    	 setPortrait2(portrait2=2);}});
		     
		campanaPlayer2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 campanaPlayer2.setSelected(false);
		    	 diavoloPlayer2.setSelected(true);
		    	 scudoPlayer2.setSelected(true);
		    	 uvaPlayer2.setSelected(true);
		    	 choosePedina[1].setText(nameIcon[0]);
		    	 setPedina2(pedina2=1);}});
		     
		diavoloPlayer2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 campanaPlayer2.setSelected(true);
		    	 diavoloPlayer2.setSelected(false);
		    	 scudoPlayer2.setSelected(true);
		    	 uvaPlayer2.setSelected(true);
		    	 choosePedina[1].setText(nameIcon[1]);
		    	 setPedina2(pedina2=2);}});
		     
		scudoPlayer2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 campanaPlayer2.setSelected(true);
		    	 diavoloPlayer2.setSelected(true);
		    	 scudoPlayer2.setSelected(false);
		    	 uvaPlayer2.setSelected(true);
		    	 choosePedina[1].setText(nameIcon[2]);
		    	 setPedina2(pedina2=3);}});
		     
		uvaPlayer2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 campanaPlayer2.setSelected(true);
		    	 diavoloPlayer2.setSelected(true);
		    	 scudoPlayer2.setSelected(true);
		    	 uvaPlayer2.setSelected(false);
		    	 choosePedina[1].setText(nameIcon[3]);
		    	 setPedina2(pedina2=4);}});
	}
	
	@SuppressWarnings("deprecation")
	public void turnoPopup(String name1, String name2)//in this secondary frame you can random choose the first player
	{
		setFirst();//it decides the first player
		
		popupPane.show();
		popupPane.setBounds(64*4,64*3,64*8,64*6);
		popupPane.setLayout(null);
		
		choosePane.add(popupPane,JLayeredPane.POPUP_LAYER);//set the pop-up
		
		JLabel background=new JLabel();
		background.setBounds(0,0,64*8,64*6);
		popupPane.add(background, JLayeredPane.DEFAULT_LAYER);//background
		
		JLabel text=new JLabel("<html><p align=center><font size=4>Verrà lanciata una moneta per scoprire chi muove per primo.</font><br>"+name1+"= Testa &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+name2+"= Croce"+"</p></html>", SwingConstants.CENTER);
        text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		text.setBounds(64,(64*4), 64*6,64);
		popupPane.add(text, JLayeredPane.PALETTE_LAYER);//text
		
		JButton throwMonet=new JButton("Lancia la moneta");
		throwMonet.setBounds((64*2)+32,64*5,64*3,32);
		popupPane.add(throwMonet, JLayeredPane.PALETTE_LAYER);
		throwMonet.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//show video and then the statement that declare the first
		    	sound.SoundButton();
		    	 
		    	JButton start=new JButton("Avvia Partita");
		 		start.setBounds((64*2)+32,64*5,64*3,32);//it will be shown after video
		 		start.addActionListener(new ActionListener() {//add a listener to button start to close everything in pop-up frame
		 			public void actionPerformed(ActionEvent ae){ 
		 				sound.SoundButton();
		     		    choosePane.hide();//remove everything from choose screen
		 	   	    	choosePane.updateUI();
		 	   	    	popupPane.removeAll();//remove all to prevent post showing in an other instance of backgoundPop
		 	   	    	popupPane.hide();
		 	   	    	popupPane.updateUI();
		     		    mainScreen();}});//start main screen
		    	 
		    	 JFXPanel throwMonetVideo=new JFXPanel();
		    	 throwMonetVideo.setBounds(32, 32, 64*7, (64*3)+32);
		    	 throwMonetVideo.show();
		 		 popupPane.add(throwMonetVideo, JLayeredPane.PALETTE_LAYER);//for the video
		 		 
		    	 popupPane.remove(throwMonet);
		    	 popupPane.updateUI();
		    	 
		    	 
		    	 Timer timer=new Timer(5000,null);//timer that show the first after monet 
		    	 timer.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent ae){//timer used for showing another button for start the game and change the text
		    		 popupPane.add(start, JLayeredPane.PALETTE_LAYER);
		    		 if(first==true) text.setText("<html><p align=center><font size=4>E'uscito testa, quindi "+name1+" muove per primo</font></p></html>");//if the first is the player1 show this text
		    		 else text.setText("<html><p align=center><font size=4>E'uscito croce, quindi "+name2+" muove per primo</font></p></html>");//else show this text
		    		 popupPane.updateUI();}});
		    			    	
		    	 timer.setRepeats(false);
		    	 timer.start();
		    	    
		    	 Platform.runLater(new Runnable() {//start video
		         @Override
		         public void run() 
		         {
		        	 if(first==true) Video.token(0,throwMonetVideo);
		        	 else Video.token(1,throwMonetVideo);
		         }});
		    }});
		
		try{
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			background.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}//set image 
	}
	
	public void mainScreen() //the screen of the game
	{
		setNomiCitta();//set immediately the array
		sound.playSoundBackground();
		main.getContentPane().add(mainPane);
		mainPane.setLayout(null);
		
		billboard.setBounds((64*3)+32,64,64*9,64*7);
		billboard.setLayout(null);
		mainPane.add(billboard);
		
		JLabel dietro=new JLabel();
		dietro.setBounds(0,0,1024,768);
        mainPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
        
        JLabel logoLiceo=new JLabel();
        logoLiceo.setBounds((64*7)+16,(64*10)+32,64+32,64+32);
        mainPane.add(logoLiceo, JLayeredPane.PALETTE_LAYER);
        
		JLabel labelName1=new JLabel(name1, SwingConstants.CENTER);
		labelName1.setBounds(0,0,64*3,64);
		labelName1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mainPane.add(labelName1, JLayeredPane.PALETTE_LAYER);//text of player1's name
		
		JLabel portraitPlayer1=new JLabel();
		portraitPlayer1.setBounds(0,64,(64*2)+32,(64*6)+32);
		mainPane.add(portraitPlayer1, JLayeredPane.PALETTE_LAYER);//image choose by player1
		
		JLabel labelPedina1=new JLabel();
		labelPedina1.setBounds((64*4)+32,(64*8)+32,(64*2)+32,32);
		labelPedina1.setHorizontalAlignment(SwingConstants.CENTER);
		labelPedina1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainPane.add(labelPedina1, JLayeredPane.PALETTE_LAYER);//text with token's name(the text is set after)
		
		JLabel iconPlayer1=new JLabel();
		iconPlayer1.setBounds((64*4)+32,64*9,(64*2)+32,(64*2)+32);
		mainPane.add(iconPlayer1, JLayeredPane.PALETTE_LAYER);//token choose by player1

		
		JLabel labelName2=new JLabel(name2,SwingConstants.CENTER);
		labelName2.setBounds(64*13,0,64*3,64);
		labelName2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mainPane.add(labelName2, JLayeredPane.PALETTE_LAYER);//text of player2's name
		
		JLabel portraitPlayer2=new JLabel();
		portraitPlayer2.setBounds((64*14)-32,64,(64*2)+32,(64*6)+32);
		mainPane.add(portraitPlayer2, JLayeredPane.PALETTE_LAYER);//image choose by player2
		
		JLabel labelPedina2=new JLabel();
		labelPedina2.setBounds(64*9,(64*8)+32,(64*2)+32,32);
		labelPedina2.setHorizontalAlignment(SwingConstants.CENTER);
		labelPedina2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainPane.add(labelPedina2, JLayeredPane.PALETTE_LAYER);//text with token's name(the text is set after)
		
		JLabel iconPlayer2=new JLabel();
		iconPlayer2.setBounds(64*9,64*9,(64*2)+32,(64*2)+32);
		mainPane.add(iconPlayer2, JLayeredPane.PALETTE_LAYER);//token choose by player1
		
        mainPane.add(exit, JLayeredPane.PALETTE_LAYER);
        
        /*set the billboard
        */
        
        JLabel tab=new JLabel();
		tab.setBounds(0,0,64*9,64*7);
		billboard.add(tab);//image of ground
		
		pedGioc1.setBounds(64*4,64*6,32,32);
		billboard.add(pedGioc1,JLayeredPane.PALETTE_LAYER);//token on the ground
		
		pedGioc2.setBounds(64*4+32,64*6+32,32,32);
		billboard.add(pedGioc2,JLayeredPane.PALETTE_LAYER);//token on the ground
        
		try{//set image
			liceo=ImageIO.read(this.getClass().getResource("/resources/layout/nuovo logo_low.png"));
			sfondo= ImageIO.read(this.getClass().getResource("/resources/layout/background_main.png"));
			imgTabellone=ImageIO.read(this.getClass().getResource("/resources/layout/tabellone.png"));
			imgDonna = ImageIO.read(this.getClass().getResource("/resources/portrair/donna p1.png"));
			imgGuerriero = ImageIO.read(this.getClass().getResource("/resources/portrair/guerriero p1.png"));
			imgDonna2 = ImageIO.read(this.getClass().getResource("/resources/portrair/donna p2.png"));
			imgGuerriero2 = ImageIO.read(this.getClass().getResource("/resources/portrair/guerriero p2.png"));
			imgCampana = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina campana(grande).png"));
			imgDiavolo = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina diavolo(grande).png"));
			imgScudo = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina spada e scudo(grande).png"));
			imgUva = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina uva(grande).png"));
			pedCampana = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina campana(piccola).png"));
			pedDiavolo = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina diavolo(piccola).png"));
			pedScudo = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina spada e scudo(piccola).png"));
			pedUva = ImageIO.read(this.getClass().getResource("/resources/pedine/pedina uva(piccola).png"));
			
			dietro.setIcon(new ImageIcon(sfondo));
			logoLiceo.setIcon(new ImageIcon(liceo));
			tab.setIcon(new ImageIcon(imgTabellone));//set the image of billboard
			
			/*set image and text by chooses
			 */
			switch(portrait1){
				case 1:	portraitPlayer1.setIcon(new ImageIcon(imgDonna));
					break;
				case 2: portraitPlayer1.setIcon(new ImageIcon(imgGuerriero));
					break;
			}
			switch(portrait2){
				case 1:	portraitPlayer2.setIcon(new ImageIcon(imgDonna2));
					break;
				case 2: portraitPlayer2.setIcon(new ImageIcon(imgGuerriero2));
					break;
			}
			
			switch(pedina1){
				case 1:
					labelPedina1.setText(nameIcon[0]);
					iconPlayer1.setIcon(new ImageIcon(imgCampana));
					pedGioc1.setIcon(new ImageIcon(pedCampana));
					break;
				case 2:
					labelPedina1.setText(nameIcon[1]);
					iconPlayer1.setIcon(new ImageIcon(imgDiavolo));
					pedGioc1.setIcon(new ImageIcon(pedDiavolo));
					break;
				case 3:
					labelPedina1.setText(nameIcon[2]);
					iconPlayer1.setIcon(new ImageIcon(imgScudo));
					pedGioc1.setIcon(new ImageIcon(pedScudo));
					break;
				case 4:
					labelPedina1.setText(nameIcon[3]);
					iconPlayer1.setIcon(new ImageIcon(imgUva));
					pedGioc1.setIcon(new ImageIcon(pedUva));
					break;
			}
			switch(pedina2){
			case 1:
				labelPedina2.setText(nameIcon[0]);
				iconPlayer2.setIcon(new ImageIcon(imgCampana));
				pedGioc2.setIcon(new ImageIcon(pedCampana));
				break;
			case 2:
				labelPedina2.setText(nameIcon[1]);
				iconPlayer2.setIcon(new ImageIcon(imgDiavolo));
				pedGioc2.setIcon(new ImageIcon(pedDiavolo));
				break;
			case 3:
				labelPedina2.setText(nameIcon[2]);
				iconPlayer2.setIcon(new ImageIcon(imgScudo));
				pedGioc2.setIcon(new ImageIcon(pedScudo));
				break;
			case 4:
				labelPedina2.setText(nameIcon[3]);
				iconPlayer2.setIcon(new ImageIcon(imgUva));
				pedGioc2.setIcon(new ImageIcon(pedUva));
				break;
			}
		}catch (IOException e){}
		
        lanciaDado1.setBounds(0, 64*8, 64*3, 64*3);
        lanciaDado1.setEnabled(false);
        
        lanciaDado2.setBounds(64*13, 64*8, 64*3, 64*3);
        lanciaDado2.setEnabled(false);
        
        goodLuckPopup();//show secondary screen to tell good luck
        
        initIdPuntiPlayer1();//instance the points for moving player1's token on the billboard
        initIdPuntiPlayer2();//instance the points for moving player2's token on the billboard
        initIdMappa();//instance the points for led on the billboard
        
        lanciaDado1.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	setPosgioc1();
		    	lanciaDado1.setText(null);
		    	lanciaDado1.setEnabled(false);
		    	lanciaDado2.setEnabled(false);
		    	screenDadoPlayer1(posgioc1,dado);
		    	} } );
        
        lanciaDado2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	setPosgioc2();
		        lanciaDado2.setText(null);
		    	lanciaDado1.setEnabled(false);
		    	lanciaDado2.setEnabled(false);
		    	screenDadoPlayer2(posgioc1, dado);
		    	} } );
	}
	
	@SuppressWarnings("deprecation")
	public void goodLuckPopup()//simple pop-up to tell good luck
	{
		mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
		popupPane.show();
		popupPane.setBounds((64*4)+32,(64*3)+32,64*7,64*2);
		popupPane.setLayout(null);//create the frame
		
		JLabel dietro=new JLabel();
		dietro.setBounds(0,0,64*7,64*2);
		popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
		
		JLabel textGoodluck=new JLabel("<html><p align=center>Sta per iniziare questo nuovo viaggio<br><font size=6>Buona fortuna e buon divertimento</font><font size=10>!</font></p></html>",SwingConstants.CENTER);
		textGoodluck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textGoodluck.setBounds(0,0,64*7,64+32);
		popupPane.add(textGoodluck, JLayeredPane.PALETTE_LAYER);//text
		
		JButton start=new JButton("Parti");
		start.setFont(new Font("Tahoma", Font.PLAIN, 16));
		start.setBounds((64*2)+32,64+32-10,64*2, 32);
		popupPane.add(start, JLayeredPane.PALETTE_LAYER);
		
		start.addActionListener(new ActionListener() {//button to start the game(before start show the info of first cell)
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	popupPane.removeAll();
		    	popupPane.hide();
		    	popupPane.updateUI();//remove and hide everything to prevent a post showing of popupPane
		    	showCasella0();} } );//show info of first cell
		
		try{
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			dietro.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}
	}

	@SuppressWarnings("deprecation")
	public void showCasella0()//an image of first cell
	{
		mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
		popupPane.show();
		popupPane.setBounds((64*4)+32,64*2,64*7,64*5);
		popupPane.setLayout(null);//create the frame
		
		JLabel dietro=new JLabel();
		dietro.setBounds(0,0,64*7,64*5);
		popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
			
		JLabel text0=new JLabel("<html><p align=center>Il tuo viaggio comincia dal Liceo Scientifico A.Romita</p></html>",SwingConstants.CENTER);
		text0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text0.setBounds(0,0,64*7,32);
		popupPane.add(text0, JLayeredPane.PALETTE_LAYER);//text
		
		JLabel casella0=new JLabel();
		casella0.setBounds(64+32,32,64*4,64*4);
		popupPane.add(casella0, JLayeredPane.PALETTE_LAYER);//image of cell
		
		JButton vedi=new JButton("Vedi");
		vedi.setBounds((64*2)+32,(64*4)+32,64*2,32);
		popupPane.add(vedi, JLayeredPane.PALETTE_LAYER);
		vedi.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	popupPane.removeAll();
		    	popupPane.hide();
		    	popupPane.updateUI();//remove everything to prevent post showing in an other instance of backgoundPop
		    	showInfoCasella00();
		    	} } );
		
		try {
			imgCasella = ImageIO.read(this.getClass().getResource("/resources/caselle/0.png"));
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			
			casella0.setIcon(new ImageIcon(imgCasella));
			dietro.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}
		
		}

	@SuppressWarnings("deprecation")
	public void showInfoCasella00() //info of first cell
	{
		mainPane.hide();
		JScrollPane scrollPane = new JScrollPane(recipesPane);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		
		main.getContentPane().add(scrollPane);
		recipesPane.setBounds(0, 0, 1024,768);
		recipesPane.setLayout(new BorderLayout());
		
		JLabel info=new JLabel();
		recipesPane.add(info,BorderLayout.CENTER, JLayeredPane.DRAG_LAYER);//image of recipe
		
		/* two button with same listener for skip
		 * 
		 */
		
		JButton domanda=new JButton("Comincia la partita");
		recipesPane.add(domanda,BorderLayout.NORTH, JLayeredPane.DRAG_LAYER);
		domanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				sound.SoundButton();
		    	scrollPane.hide();
		    	scrollPane.updateUI();
		    	main.getContentPane().remove(scrollPane);
		    	recipesPane.removeAll();
		    	recipesPane.updateUI();
		    	mainPane.show();
		    	if (first==true)//if the first is player1
		    	{
		    		screenTurnoPlayer1();//show alert to remind player 1 to throw dice
		    	}
		    	else//if the first is player2
		    	{
		    		screenTurnoPlayer2(); //show alert to remind player 2 to throw dice
		    	}} } );
		JButton domanda2=new JButton("Comincia la partita");
		recipesPane.add(domanda2,BorderLayout.SOUTH, JLayeredPane.DRAG_LAYER);
		domanda2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	scrollPane.hide();
			    scrollPane.updateUI();
			    main.getContentPane().remove(scrollPane);
			    recipesPane.removeAll();
			    recipesPane.updateUI();
			    mainPane.show();
		    	if (first==true)//if the first is player1
		    	{
		    		screenTurnoPlayer1();//show alert to remind player 1 to throw dice
		    	}
		    	else//if the first is player2
		    	{
		    		screenTurnoPlayer2(); //show alert to remind player 2 to throw dice
		    	}} } );
		
		try{//set image
			imgInfoCasella=ImageIO.read(this.getClass().getResource("/resources/fototesto/0.jpg"));
			info.setIcon(new ImageIcon(imgInfoCasella));
		}catch(IOException e){}
	}
	
	@SuppressWarnings("deprecation")
	public void screenTurnoPlayer1()//simple alert to remind player1 to throw dice
	{
		mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
		popupPane.show();
		popupPane.setBounds((64*4)+32,(64*3)+32,64*7,64*2);
		popupPane.setLayout(null);//create frame
		
		JLabel ilTurno1=new JLabel(name1+", ora è il tuo turno",SwingConstants.CENTER);
		ilTurno1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ilTurno1.setBounds(0,0,64*7,64+32);
		popupPane.add(ilTurno1,JLayeredPane.PALETTE_LAYER);//text
		
		JButton start=new JButton("Vai");
		start.setFont(new Font("Tahoma", Font.PLAIN, 16));
		start.setBounds((64*2)+32,64+32-10, 64*2, 32);
		popupPane.add(start,JLayeredPane.PALETTE_LAYER);//button to close the alert 
		
		try{
			JLabel dietro=new JLabel();
			dietro.setBounds(0,0,64*7,64*2);
			popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
			
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			
			dietro.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}
		
		start.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	popupPane.removeAll();
		    	popupPane.updateUI();
		    	popupPane.hide();
		    	
		    	mainPane.add(lanciaDado1, JLayeredPane.MODAL_LAYER);//button for throw dice(default disable until other action
		    	lanciaDado1.setContentAreaFilled(false);
		    	
		    	
				videoDado1.setBounds(0,64*8,64*3,64*3);//set the jfxpanel to show video
				mainPane.add(videoDado1, JLayeredPane.PALETTE_LAYER);
				
				Timer timer=new Timer(3000,null); 
		        timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
					public void actionPerformed(ActionEvent ae){
				        lanciaDado1.setText(name1+ ", lancia il dado");
				    	lanciaDado1.setEnabled(true);
				    	lanciaDado2.setEnabled(false);//let enable the button of player1 and disable the other one
				    	mainPane.updateUI();}});
				    	
		        timer.setRepeats(false);
		        timer.start();
		        
		 		Platform.runLater(new Runnable() {//start video
		 	          @Override
		 	          public void run() 
		 	          {
		 	              Video.dice1(videoDado1);
		 	          }});
		    	} } );
	}
	
	@SuppressWarnings("deprecation")
	public void screenTurnoPlayer2()//simple alert to remind player2 to throw dice
	{
		mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
		popupPane.show(true);
		popupPane.setBounds((64*4)+32,(64*3)+32,64*7,64*2);
		popupPane.setLayout(null);//create frame
		
		JLabel ilTurno2=new JLabel(name2+", ora è il tuo turno",SwingConstants.CENTER);
		ilTurno2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ilTurno2.setBounds(0,0,64*7,64+32);
		popupPane.add(ilTurno2,JLayeredPane.PALETTE_LAYER);//text
		
		JButton start=new JButton("Vai");
		start.setFont(new Font("Tahoma", Font.PLAIN, 16));
		start.setBounds((64*2)+32,64+32-10, 64*2, 32);
		popupPane.add(start,JLayeredPane.PALETTE_LAYER);//button to close the alert
		
		try{
			JLabel dietro=new JLabel();
			dietro.setBounds(0,0,64*7,64*2);
			popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
			
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			
			dietro.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}
		
		start.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	popupPane.removeAll();
		    	popupPane.updateUI();
		    	popupPane.hide();
		    	
		    	mainPane.add(lanciaDado2, JLayeredPane.MODAL_LAYER);//button for throw dice(default disable until other action
		    	lanciaDado2.setContentAreaFilled(false);
		    	
		    	videoDado2.setBounds(64*13,64*8,64*3,64*3);//set the jfxpanel to show video
				mainPane.add(videoDado2, JLayeredPane.PALETTE_LAYER);
				
				
				Timer timer=new Timer(3000,null); 
		        timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
					public void actionPerformed(ActionEvent ae){
				        lanciaDado2.setText(name2+ ", lancia il dado");
				    	lanciaDado1.setEnabled(false);
				    	lanciaDado2.setEnabled(true);//let enable the button of player1 and disable the other one
				    	mainPane.updateUI();}});
				    	
		        timer.setRepeats(false);
		        timer.start();
		        
		 		Platform.runLater(new Runnable() {//start video
		 	          @Override
		 	          public void run() 
		 	          {
		 	              Video.dice1(videoDado2);
		 	          }});
		 		} } );
	}
	
	@SuppressWarnings("deprecation")
	public void screenDadoPlayer1(int posgioc1, int dado)
	{
		JFXPanel fxPanel=new JFXPanel();//used for the videos
		fxPanel.setBounds((64*4)+32,64*2,64*7,64*5);
		mainPane.add(fxPanel, JLayeredPane.DRAG_LAYER);//set the jfxpanel to show video
		
		Timer timer=new Timer(4000,null); 
        timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
			public void actionPerformed(ActionEvent ae){
		        fxPanel.hide();
		        popupPane.show();
		        popupPane.setBounds((64*4)+32,64*2,64*7,64*5);
				popupPane.setLayout(null);
		        mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
				
				JLabel text=new JLabel("<html><p align=center>"+name1+", è uscito il numero "+dado+",<br> quindi ora andrai sulla casella n."+ posgioc1+"</p></html>",SwingConstants.CENTER);
				text.setFont(new Font("Tahoma", Font.PLAIN, 22));
				text.setBounds(32,32,64*6,(64*2)+32);
				popupPane.add(text,JLayeredPane.PALETTE_LAYER);//
				
				JButton vai=new JButton("Vai "+città[posgioc1]);
				vai.setBounds(64,(64*3)+32,64*5,64);
				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
				
				try{
					JLabel dietro=new JLabel();
					dietro.setBounds(0,0,64*7,64*5);
					popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
					
					sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
					
					dietro.setIcon(new ImageIcon(sfondoPopup));
				}catch(IOException e){}
				
				vai.addActionListener(new ActionListener() {
				     public void actionPerformed(ActionEvent ae) {
				    	sound.SoundButton();
					    pedGioc1.setLocation(idPuntiPlayer1.get(posgioc1));
					    popupPane.removeAll();
						popupPane.hide();
				    	popupPane.updateUI();
				    	
				    	Timer timer1=new Timer(1500,null); 
				        timer1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae){
								if(posgioc1==0||posgioc1==4 || posgioc1==7|| posgioc1==10||posgioc1==14||posgioc1==18||posgioc1==21||posgioc1==24||posgioc1==27)
						    	{
						    		showCasellaNPlayer1(posgioc1,name1);
						    	}
						    	else
						    	{
						    		sound.SoundButton();
						    		JLabel led=new JLabel();
						    		if(posgioc1==15||posgioc1==20) 
						    		{
						    			led.setSize(22,22);
						    			try{ //set icons for both player1 and player2
						    				ledBig=ImageIO.read(this.getClass().getResource("/resources/layout/led acceso grande.png"));
						    				led.setIcon(new ImageIcon(ledBig));
						    			}catch(IOException e){}
						    		}
						    		else if(posgioc1==1||posgioc1==8||posgioc1==12||posgioc1==23||posgioc1==23)
						    		{
						    			led.setSize(22,22);
						    			try{ //set icons for both player1 and player2
						    				ledBig=ImageIO.read(this.getClass().getResource("/resources/layout/led acceso verde grande.png"));
						    				led.setIcon(new ImageIcon(ledBig));
						    			}catch(IOException e){}
						    		}
						    		else 
						    		{
						    			led.setSize(12,12);
						    			try{ //set icons for both player1 and player2
						    				ledSmall=ImageIO.read(this.getClass().getResource("/resources/layout/led acceso piccolo.png"));
						    				led.setIcon(new ImageIcon(ledSmall));
						    			}catch(IOException e){}
						    		}
						    		led.setLocation(idPuntiMappa.get(posgioc1));
						    		billboard.add(led, JLayeredPane.PALETTE_LAYER);
						    		
						    		Timer timer2=new Timer(2500,null); 
							        timer2.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent ae){
											billboard.remove(led);
											showCasellaNPlayer1(posgioc1,name1);
										}});
							        timer2.setRepeats(false);
							        timer2.start();
						    	}}});
				        timer1.setRepeats(false);
				        timer1.start();
				    	} } );}});
		    	
        timer.setRepeats(false);
        timer.start();
        
 		Platform.runLater(new Runnable() {//start video
 	          @Override
 	          public void run() 
 	          {
 	              Video.dice2(dado,fxPanel);
 	          }});
	}
	
	@SuppressWarnings("deprecation")
	public void screenDadoPlayer2(int posgioc1, int dado)
	{
		JFXPanel fxPanel=new JFXPanel();//used for the videos
		mainPane.add(fxPanel, JLayeredPane.DRAG_LAYER);
		fxPanel.setBounds((64*4)+32,64*2,64*7,64*5);//set the jfxpanel to show video
		
		Timer timer=new Timer(4000,null); 
        timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
			public void actionPerformed(ActionEvent ae){
		        fxPanel.hide();
		        popupPane.show();
		        popupPane.setBounds((64*4)+32,64*2,64*7,64*5);
				popupPane.setLayout(null);
		        mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
				
				JLabel text=new JLabel("<html><p align=center>"+name2+", è uscito il numero "+dado+",<br> quindi ora andrai sulla casella n."+ posgioc2+"</p></html>",SwingConstants.CENTER);
				text.setFont(new Font("Tahoma", Font.PLAIN, 22));
				text.setBounds(32,32,64*6,(64*2)+32);
				popupPane.add(text,JLayeredPane.PALETTE_LAYER);//
				
				JButton vai=new JButton("Vai "+città[posgioc2]);
				vai.setBounds(64,(64*3)+32,64*5,64);
				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
				
				try{
					JLabel dietro=new JLabel();
					dietro.setBounds(0,0,64*7,64*5);
					popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
					
					sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
					
					dietro.setIcon(new ImageIcon(sfondoPopup));
				}catch(IOException e){}
				
				vai.addActionListener(new ActionListener() {
				     public void actionPerformed(ActionEvent ae) {
				    	sound.SoundButton();
					    pedGioc2.setLocation(idPuntiPlayer2.get(posgioc2));
					    popupPane.removeAll();
						popupPane.hide();
				    	popupPane.updateUI();
				    	
				    	Timer timer1=new Timer(1500,null); 
				        timer1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae){
								if(posgioc2==0||posgioc2==4 || posgioc2==7|| posgioc2==10||posgioc2==14||posgioc2==18||posgioc2==21||posgioc2==24||posgioc2==27)
						    	{
						    		showCasellaNPlayer2(posgioc2,name2);
						    	}
						    	else
						    	{
						    		sound.SoundButton();
						    		JLabel led=new JLabel();
						    		if(posgioc2==15||posgioc2==20) 
						    		{
						    			led.setSize(22,22);
						    			try{ //set icons for both player1 and player2
						    				ledBig=ImageIO.read(this.getClass().getResource("/resources/layout/led acceso grande.png"));
						    				led.setIcon(new ImageIcon(ledBig));
						    			}catch(IOException e){}
						    		}
						    		else if(posgioc2==1||posgioc2==8||posgioc2==12||posgioc2==23||posgioc2==23)
						    		{
						    			led.setSize(22,22);
						    			try{ //set icons for both player1 and player2
						    				ledBig=ImageIO.read(this.getClass().getResource("/resources/layout/led acceso verde grande.png"));
						    				led.setIcon(new ImageIcon(ledBig));
						    			}catch(IOException e){}
						    		}
						    		else 
						    		{
						    			led.setSize(12,12);
						    			try{ //set icons for both player1 and player2
						    				ledSmall=ImageIO.read(this.getClass().getResource("/resources/layout/led acceso piccolo.png"));
						    				led.setIcon(new ImageIcon(ledSmall));
						    			}catch(IOException e){}
						    		}
						    		led.setLocation(idPuntiMappa.get(posgioc2));
						    		billboard.add(led, JLayeredPane.PALETTE_LAYER);
						    		
						    		Timer timer2=new Timer(2500,null); 
							        timer2.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent ae){
											billboard.remove(led);
											showCasellaNPlayer2(posgioc2,name2);
										}});
							        timer2.setRepeats(false);
							        timer2.start();
						    	}	
							}});
				        timer1.setRepeats(false);
				        timer1.start();
				    	} } );}});
		    	
        timer.setRepeats(false);
        timer.start();
        
 		Platform.runLater(new Runnable() {//start video
 	          @Override
 	          public void run() 
 	          {
 	              Video.dice2(dado,fxPanel);
 	          }});
	}
	
	@SuppressWarnings("deprecation")
	public void showCasellaNPlayer1(int posgioc1, String name1)//an image of the cell by position of player1
	{
		mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
		popupPane.show();
		popupPane.setBounds((64*4)+32,64*2,64*7,64*5);
		popupPane.setLayout(null);//create frame
		
		JLabel dietro=new JLabel();
		dietro.setBounds(0,0,64*7,64*5);
		popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
		
		JLabel text=new JLabel(name1+", sei arrivato "+città[posgioc1],SwingConstants.CENTER);
		if(portrait1==1)text.setText(name1+", sei arrivata "+città[posgioc1]);
		text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text.setBounds(0,0,64*7,32);
		popupPane.add(text,JLayeredPane.PALETTE_LAYER);// text join in a city(look the array in the bottom of the code)(to adjust)
		
		JLabel casellan=new JLabel();
		casellan.setBounds(64+32,32,64*4,64*4);
		popupPane.add(casellan,JLayeredPane.PALETTE_LAYER);//image of cell
		
		try{
			imgCasella = ImageIO.read(this.getClass().getResource("/resources/caselle/"+posgioc1+".png"));//choose by position of player1
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			
			casellan.setIcon(new ImageIcon(imgCasella));
			dietro.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}
		
		JButton vedi=new JButton("Vedi");
		if(posgioc1==4||posgioc1==10||posgioc1==18||posgioc1==24) vedi.setText("Prosegui");
		vedi.setBounds((64*2)+32,(64*4)+32,64*2,32);
		popupPane.add(vedi,JLayeredPane.PALETTE_LAYER);
		vedi.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//to continue the game or proclaim winner
		    	sound.SoundButton();
		    	if (posgioc1==6)
		    	{
		    		sound.stopSoundBackground();
		    		
		    		JFXPanel video=new JFXPanel();
					video.setBounds(0,0,1024,768);
					mainPane.add(video, JLayeredPane.DRAG_LAYER);
						 
					Timer timer=new Timer(13000,null); 
					timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
						public void actionPerformed(ActionEvent ae){
							video.hide();
					    	mainPane.updateUI();
					    	
					    	popupPane.removeAll();
				    		popupPane.updateUI();
				    		popupPane.hide();
				    		showInfoCasellaNPlayer1();}});
							    	
					timer.setRepeats(false);
					timer.start();
					        
					Platform.runLater(new Runnable() {//start video
					@Override
					public void run() 
					{
						Video.ripalimosani(video);
					}});
		    	}
		    	else
		    	{
		    		popupPane.removeAll();
		    		popupPane.updateUI();
		    		popupPane.hide();
		    		if(posgioc1==4||posgioc1==10||posgioc1==18||posgioc1==24) screenTurnoPlayer2();
		    		else showInfoCasellaNPlayer1();
		    	}}});
	}
	
	@SuppressWarnings("deprecation")
	public void showCasellaNPlayer2(int posgioc2, String name2)//an image of the cell by position of player1
	{
		mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
		popupPane.show();
		popupPane.setBounds((64*4)+32,64*2,64*7,64*5);
		popupPane.setLayout(null);//create frame 
	
		JLabel dietro=new JLabel();
		dietro.setBounds(0,0,64*7,64*5);
		popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
		
		JLabel text=new JLabel(name2+", sei arrivato "+città[posgioc2],SwingConstants.CENTER);
		if(portrait2==1)text.setText(name2+", sei arrivata "+città[posgioc2]);
		text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text.setBounds(0,0,64*7,32);
		popupPane.add(text,JLayeredPane.PALETTE_LAYER);// text join in a city(look the array in the bottom of the code)(to adjust)
	
		JLabel casellan=new JLabel();
		casellan.setBounds(64+32,32,64*4,64*4);
		popupPane.add(casellan,JLayeredPane.PALETTE_LAYER);//image of cell
		
		try 
		{
			imgCasella = ImageIO.read(this.getClass().getResource("/resources/caselle/"+posgioc2+".png"));//choose by position of player2
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			
			casellan.setIcon(new ImageIcon(imgCasella));
			dietro.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}
		
		JButton vedi=new JButton("Vedi");
		if(posgioc2==4||posgioc2==10||posgioc2==18||posgioc2==24) vedi.setText("Prosegui");
		vedi.setBounds((64*2)+32,(64*4)+32,64*2,32);
		popupPane.add(vedi,JLayeredPane.PALETTE_LAYER);
		vedi.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//to continue the game or proclaim winner
		    	sound.SoundButton();
		    	if (posgioc2==6)
		    	{
		    		sound.stopSoundBackground();
		    		JFXPanel video=new JFXPanel();
					video.setBounds(0,0,1024,768);
					mainPane.add(video, JLayeredPane.DRAG_LAYER);
						 
					Timer timer=new Timer(13000,null); 
					timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
						public void actionPerformed(ActionEvent ae){
							video.hide();
					    	mainPane.updateUI();
					    	
					    	popupPane.removeAll();
					    	popupPane.updateUI();
				    		popupPane.hide();
				    		showInfoCasellaNPlayer2();}});
							    	
					timer.setRepeats(false);
					timer.start();
					        
					Platform.runLater(new Runnable() {//start video
					@Override
					public void run() 
					{
						Video.ripalimosani(video);
					}});
		    	}
		    	else
		    	{
		    		popupPane.removeAll();
		    		popupPane.updateUI();
		    		popupPane.hide();
		    		if(posgioc2==4||posgioc2==10||posgioc2==18||posgioc2==24) screenTurnoPlayer1();
		    		else showInfoCasellaNPlayer2();
		    	}} } );
	}
	
	@SuppressWarnings("deprecation")
	public void showInfoCasellaNPlayer1() 
	{
		int d[]=new int[26];
    	d[9]=137000;
    	d[11]=74000;
    	d[15]=75000;
    	d[17]=62000;
    	d[20]=35000;
    	d[21]=58000;
    	d[25]=91000;
    	
    	sound.stopSoundBackground();
		if(posgioc1==22) sound.playBaranello();
		
		mainPane.hide();
		JScrollPane scrollPane = new JScrollPane(recipesPane);
		scrollPane.show();
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		
		main.getContentPane().add(scrollPane);
		recipesPane.setBounds(0, 0, 1024,768);
		recipesPane.setLayout(new BorderLayout());
		
		JLabel info=new JLabel();
		try{//set image
			imgInfoCasella=ImageIO.read(this.getClass().getResource("/resources/fototesto/"+posgioc1+".jpg"));
			info.setIcon(new ImageIcon(imgInfoCasella));//set the image of ground
		}catch(IOException e){info.setText("Immagine assente");}
		recipesPane.add(info,BorderLayout.CENTER, JLayeredPane.DRAG_LAYER);//JLabel with recipe
		
		JButton domanda=new JButton("Vai alla domanda");
		if(posgioc1==9||posgioc1==11||posgioc1==15||posgioc1==17||posgioc1==20||posgioc1==21||posgioc1==25) domanda.setText("Vedi il video e procedi alla domanda");
		if(posgioc1==27)domanda.setText(name1+", hai vinto!");
		recipesPane.add(domanda,BorderLayout.NORTH, JLayeredPane.DRAG_LAYER);
		domanda.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 if(posgioc1==22) sound.stopBaranello();
		    	 
		    	 scrollPane.hide();
				 scrollPane.updateUI();
				 main.getContentPane().remove(scrollPane);
				 recipesPane.removeAll();
				 recipesPane.updateUI();
				 mainPane.show();
				 if(posgioc1==9||posgioc1==11||posgioc1==15||posgioc1==17||posgioc1==20||posgioc1==21||posgioc1==25)
				 {
					JFXPanel video=new JFXPanel();
					video.setBounds(0,0,1024,768);
					mainPane.add(video, JLayeredPane.POPUP_LAYER);
						 
					Timer timer=new Timer(d[posgioc1],null); 
					timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
						public void actionPerformed(ActionEvent ae){
							sound.playSoundBackground();
							video.hide();
					    	mainPane.updateUI();
					    	domandaPlayer1(posgioc1);}});
							    	
					JButton skip=new JButton();
					skip.setBounds(64*15,(64*11)+32,64,32);
					mainPane.add(skip, JLayeredPane.DRAG_LAYER);
					skip.addActionListener(new ActionListener() {
					     public void actionPerformed(ActionEvent ae) {
					     Video.stopRecipes();
					     sound.playSoundBackground();
					     video.hide();
			    		 skip.hide();
			    		 timer.stop();
			    		 domandaPlayer1(posgioc1);
					     }});
					
					timer.setRepeats(false);
					timer.start();
					        
					Platform.runLater(new Runnable() {//start video
					@Override
					public void run() 
					{
						Video.recipes(posgioc1,video);
					}});
					
					try
			 		{
			 			buttonSkip0=ImageIO.read(this.getClass().getResource("/resources/layout/salta0.png"));
			 			
			 			skip.setIcon(new ImageIcon(buttonSkip0));
			 		}catch(IOException e){}
				 }
				 else if(posgioc1==27) proclaimWinner(name1);
				 else 
				 {
					 sound.playSoundBackground();
					 domandaPlayer1(posgioc1);
				 }} } );
		JButton domanda2=new JButton("Vai alla domanda");
		if(posgioc1==9||posgioc1==11||posgioc1==15||posgioc1==17||posgioc1==20||posgioc1==21||posgioc1==25) domanda2.setText("Vedi il video e procedi alla domanda");
		if(posgioc1==27)domanda.setText(name1+", hai vinto!");
		recipesPane.add(domanda2,BorderLayout.SOUTH, JLayeredPane.DRAG_LAYER);
		domanda2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	if(posgioc1==22) sound.stopBaranello();
		    	
		    	scrollPane.hide();
			    scrollPane.updateUI();
			    main.getContentPane().remove(scrollPane);
			    recipesPane.removeAll();
			    recipesPane.updateUI();
			    mainPane.show();
			    if(posgioc1==9||posgioc1==11||posgioc1==15||posgioc1==17||posgioc1==20||posgioc1==21||posgioc1==25)
				{
					JFXPanel video=new JFXPanel();
					video.setBounds(0,0,1024,768);
					mainPane.add(video, JLayeredPane.POPUP_LAYER);
					 
					Timer timer=new Timer(d[posgioc1],null); 
				    timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
				    	public void actionPerformed(ActionEvent ae){
				    		 sound.playSoundBackground();
				    		 video.hide();
				    		 mainPane.updateUI();
				    		 domandaPlayer1(posgioc1);}});
				    
				    JButton skip=new JButton();
					skip.setBounds(64*15,(64*11)+32,64,32);
					mainPane.add(skip, JLayeredPane.DRAG_LAYER);
					skip.addActionListener(new ActionListener() {
					     public void actionPerformed(ActionEvent ae) {
					    	 sound.playSoundBackground();
					    	 Video.stopRecipes();
						     video.hide();
				    		 skip.hide();
				    		 timer.stop();
				    		 domandaPlayer1(posgioc1);
					     }});
				    
				    timer.setRepeats(false);
				    timer.start();
				        
				 	Platform.runLater(new Runnable() {//start video
				 	@Override
				 		public void run() 
				 	    {
				 	    	Video.recipes(posgioc1,video);
				 	    }});
				 	try
			 		{
			 			buttonSkip0=ImageIO.read(this.getClass().getResource("/resources/layout/salta0.png"));
			 			
			 			skip.setIcon(new ImageIcon(buttonSkip0));
			 		}catch(IOException e){}
				}
			    else if(posgioc1==27) proclaimWinner(name1);
			    else 
			    {
			    	sound.playSoundBackground();
			    	domandaPlayer1(posgioc1);
			    }} } );
	}
	
	@SuppressWarnings("deprecation")
	public void showInfoCasellaNPlayer2() 
	{
		int d[]=new int[26];
    	d[9]=137000;
    	d[11]=74000;
    	d[15]=75000;
    	d[17]=62000;
    	d[20]=35000;
    	d[21]=58000;
    	d[25]=91000;
		
    	sound.stopSoundBackground();
		if(posgioc2==22) sound.playBaranello();
		
		mainPane.hide();
		JScrollPane scrollPane = new JScrollPane(recipesPane);
		scrollPane.show();
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		
		main.getContentPane().add(scrollPane);
		recipesPane.setBounds(0, 0, 1024,768);
		recipesPane.setLayout(new BorderLayout());
		
		JLabel info=new JLabel();
		try{//set image
			imgInfoCasella=ImageIO.read(this.getClass().getResource("/resources/fototesto/"+posgioc2+".jpg"));
			info.setIcon(new ImageIcon(imgInfoCasella));//set the image of ground
		}catch(IOException e){info.setText("Immagine assente");}
		recipesPane.add(info,BorderLayout.CENTER, JLayeredPane.DRAG_LAYER);//JLabel with recipe
		
		JButton domanda=new JButton("Vai alla domanda");
		if(posgioc2==9||posgioc2==11||posgioc2==15||posgioc2==17||posgioc2==20||posgioc2==21||posgioc2==25) domanda.setText("Vedi il video e procedi alla domanda");
		if(posgioc2==27)domanda.setText(name2+", hai vinto!");
		recipesPane.add(domanda,BorderLayout.NORTH, JLayeredPane.DRAG_LAYER);
		domanda.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	 sound.SoundButton();
		    	 if(posgioc2==22) sound.stopBaranello();
		    	 
		    	 scrollPane.hide();
				 scrollPane.updateUI();
				 main.getContentPane().remove(scrollPane);
				 recipesPane.removeAll();
				 recipesPane.updateUI();
				 mainPane.show();
				 if(posgioc2==9||posgioc2==11||posgioc2==15||posgioc2==17||posgioc2==20||posgioc2==21||posgioc2==25)
				 {
					JFXPanel video=new JFXPanel();
					video.setBounds(0,0,1024,768);
					mainPane.add(video, JLayeredPane.POPUP_LAYER);
							 
					Timer timer=new Timer(d[posgioc2],null); 
					timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
					public void actionPerformed(ActionEvent ae){
						sound.playSoundBackground();
						video.hide();
						mainPane.updateUI();
						domandaPlayer2(posgioc2);}});
								    	
					JButton skip=new JButton();
					skip.setBounds(64*15,(64*11)+32,64,32);
					mainPane.add(skip, JLayeredPane.DRAG_LAYER);
					skip.addActionListener(new ActionListener() {
					     public void actionPerformed(ActionEvent ae) {
					    	 sound.playSoundBackground();
					    	 Video.stopRecipes();
						     video.hide();
				    		 skip.hide();
				    		 timer.stop();
				    		 domandaPlayer2(posgioc2);
					     }});
					
					timer.setRepeats(false);
					timer.start();
						        
					Platform.runLater(new Runnable() {//start video
					@Override
					public void run() 
					{
						Video.recipes(posgioc2,video);
					}});
					
					try
			 		{
			 			buttonSkip0=ImageIO.read(this.getClass().getResource("/resources/layout/salta0.png"));
			 			
			 			skip.setIcon(new ImageIcon(buttonSkip0));
			 		}catch(IOException e){}
				 }
				 else if(posgioc2==27) proclaimWinner(name2);
				 else 
				 {
					 sound.playSoundBackground();
					 domandaPlayer2(posgioc2);
				 } }} );
		
		JButton domanda2=new JButton("Vai alla domanda");
		if(posgioc2==9||posgioc2==11||posgioc2==15||posgioc2==17||posgioc2==20||posgioc2==21||posgioc2==25) domanda.setText("Vedi il video e procedi alla domanda");
		if(posgioc2==27)domanda.setText(name2+", hai vinto!");
		recipesPane.add(domanda2,BorderLayout.SOUTH, JLayeredPane.DRAG_LAYER);
		domanda2.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		    	sound.SoundButton();
		    	if(posgioc2==22) sound.stopBaranello();
		    	
		    	scrollPane.hide();
			    scrollPane.updateUI();
			    main.getContentPane().remove(scrollPane);
			    recipesPane.removeAll();
			    recipesPane.updateUI();
			    mainPane.show();
			    if(posgioc2==9||posgioc2==11||posgioc2==15||posgioc2==17||posgioc2==20||posgioc2==21||posgioc2==25)
				{
			    	JFXPanel video=new JFXPanel();
					video.setBounds(0,0,1024,768);
					mainPane.add(video, JLayeredPane.POPUP_LAYER);
							 
					Timer timer=new Timer(d[posgioc2],null); 
					timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
					public void actionPerformed(ActionEvent ae){
						sound.playSoundBackground();
						video.hide();
						mainPane.updateUI();
						domandaPlayer2(posgioc2);}});
							
					JButton skip=new JButton();
					skip.setBounds(64*15,(64*11)+32,64,32);
					mainPane.add(skip, JLayeredPane.DRAG_LAYER);
					skip.addActionListener(new ActionListener() {
					     public void actionPerformed(ActionEvent ae) {
					    	 sound.playSoundBackground();
					    	 Video.stopRecipes();
						     video.hide();
				    		 skip.hide();
				    		 timer.stop();
				    		 domandaPlayer2(posgioc2);
					     }});
					
					timer.setRepeats(false);
					timer.start();
						        
					Platform.runLater(new Runnable() {//start video
					@Override
					public void run() 
					{
						Video.recipes(posgioc2,video);
					}});
					
					try
			 		{
			 			buttonSkip0=ImageIO.read(this.getClass().getResource("/resources/layout/salta0.png"));
			 			
			 			skip.setIcon(new ImageIcon(buttonSkip0));
			 		}catch(IOException e){}
				}
			    else if(posgioc2==27) proclaimWinner(name2);
			    else 
			    {
			    	sound.playSoundBackground();
			    	domandaPlayer2(posgioc2);
			    }} } );
	}
	
	@SuppressWarnings("deprecation")
	public void domandaPlayer1(int posgioc1)//pop up to answer the question for player1
	{
		mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
		popupPane.show();
		popupPane.setBounds((64*4)+32,64*2,64*7,64*5);
		popupPane.setLayout(null);
		
		Point b1=new Point(16,64*3);
		Point b2=new Point((64*3)+32+16,64*3);
		Point b3=new Point(64*2,64*4);//there are the 3 points where button will be placed 
		
		JLabel textDomanda=new JLabel();
		textDomanda.setBounds(32,32,64*6,64*2);
		textDomanda.setText(core.getDomanda(posgioc1));
		textDomanda.setHorizontalAlignment(SwingConstants.CENTER);
		popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);//question text
		
		JLabel time=new JLabel("30", SwingConstants.CENTER);
		time.setFont(new Font("Tahoma", Font.PLAIN, 20));
		time.setForeground(Color.RED);
		time.setBounds(64*6,0,64,64);
		popupPane.add(time,JLayeredPane.PALETTE_LAYER);
		
		JButton[] risposte=new JButton[4];//array of 3 button(0 button not considerate)
		for(int i=1;i<=3;i++)
		{
			risposte[i]=new JButton(core.getRisposta(posgioc1,i));
			risposte[i].setSize(64*3,32+16);
			risposte[i].setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		
		long startTime=System.currentTimeMillis();
		
		Timer countdown=new Timer(1000,null);
		countdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				long diffTime = startTime-System.currentTimeMillis();
                
                int seconds = (int) (diffTime / 1000 % 60)+30;

                String s = String.valueOf(seconds).toString();;
                
                time.setText (s);
                if(seconds==0)
                {
                	sound.soundWrongAnswerSound();
    		    	countdown.stop();
    		    	risposte[1].hide();
    		    	risposte[2].hide();
    		    	risposte[3].hide();
    		    	time.hide();
    		    	popupPane.remove(textDomanda);
    		    	
    		    	popupPane.updateUI();

    		    	setPosgioc1Back();
    		    	pedGioc1.setLocation(idPuntiPlayer1.get(posgioc1-dado));
    		    	billboard.updateUI();
    		    	
    		    	textDomanda.setText("<html><p align=center>Mi dispiace, "+name1+",hai esaurito il tempo per rispondere alla domanda, dovrai tornare "+città[posgioc1-dado]+"</p></html>");
    		    	textDomanda.setFont(new Font("Tahoma", Font.PLAIN, 16));
    				popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);
    				
    				JButton vai=new JButton("Torna indietro");
    				vai.setBounds(64*2,(64*3)+32,64*3,64);
    				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
    				
    				vai.addActionListener(new ActionListener() {
    				     public void actionPerformed(ActionEvent ae) {
    				    	sound.SoundButton();
    				    	popupPane.removeAll();
    				    	popupPane.hide();
    					    popupPane.updateUI();
    					    screenTurnoPlayer2();}});
                }
                }});
		countdown.start();
		
		int i=(int)Math.round((Math.random()*2)+1);//there are 3 possible layout for location of button(in this way the correct answer it won't be in same place
		if(i==1)
		{
			risposte[1].setLocation(b1);
			risposte[2].setLocation(b2);
			risposte[3].setLocation(b3);
			
			Timer timer=new Timer(1000,null); 
			timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				popupPane.add(risposte[1],JLayeredPane.PALETTE_LAYER);
				sound.soundDomanda();
				Timer timer1=new Timer(1000,null); 
				timer1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
					popupPane.add(risposte[2],JLayeredPane.PALETTE_LAYER);
					sound.soundDomanda();
					Timer timer2=new Timer(1000,null); 
					timer2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae){
						popupPane.add(risposte[3],JLayeredPane.PALETTE_LAYER);
						sound.soundDomanda();
						}});
								    	
					timer2.setRepeats(false);
					timer2.start();
					}});
							    	
				timer1.setRepeats(false);
				timer1.start();}});
						    	
			timer.setRepeats(false);
			timer.start();
		}
		else if(i==2)
		{
			risposte[1].setLocation(b2);
			risposte[2].setLocation(b1);
			risposte[3].setLocation(b3);
			
			Timer timer=new Timer(1000,null); 
			timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				popupPane.add(risposte[2],JLayeredPane.PALETTE_LAYER);
				sound.soundDomanda();
				Timer timer1=new Timer(1000,null); 
				timer1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
					popupPane.add(risposte[1],JLayeredPane.PALETTE_LAYER);
					sound.soundDomanda();
					Timer timer2=new Timer(1000,null); 
					timer2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae){
						popupPane.add(risposte[3],JLayeredPane.PALETTE_LAYER);
						sound.soundDomanda();
						}});
								    	
					timer2.setRepeats(false);
					timer2.start();
					}});
							    	
				timer1.setRepeats(false);
				timer1.start();}});
						    	
			timer.setRepeats(false);
			timer.start();
		}
		else
		{
			risposte[1].setLocation(b3);
			risposte[2].setLocation(b2);
			risposte[3].setLocation(b1);
			
			Timer timer=new Timer(1000,null); 
			timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				popupPane.add(risposte[3],JLayeredPane.PALETTE_LAYER);
				sound.soundDomanda();
				Timer timer1=new Timer(1000,null); 
				timer1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
					popupPane.add(risposte[2],JLayeredPane.PALETTE_LAYER);
					sound.soundDomanda();
					Timer timer2=new Timer(1000,null); 
					timer2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae){
						popupPane.add(risposte[1],JLayeredPane.PALETTE_LAYER);
						sound.soundDomanda();
						}});
								    	
					timer2.setRepeats(false);
					timer2.start();
					}});
							    	
				timer1.setRepeats(false);
				timer1.start();}});
						    	
			timer.setRepeats(false);
			timer.start();
		}
				
		try{
			JLabel dietro=new JLabel();
			dietro.setBounds(0,0,64*7,64*5);
			popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
			
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			
			dietro.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}
		
		risposte[1].addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//listener for set the correct question
		    	sound.soundRightAnswerSound();
		    	countdown.stop();
		    	risposte[1].hide();
		    	risposte[2].hide();
		    	risposte[3].hide();
		    	time.hide();
		    	popupPane.remove(textDomanda);
		    	popupPane.updateUI();
		    	
		    	textDomanda.setText("<html><p align=center>Complimenti, "+name1+", hai risposto correttamente, puoi continuare il tuo viaggio</p></html>");
		    	textDomanda.setFont(new Font("Tahoma", Font.PLAIN, 16));
				popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);
				
				JButton vai=new JButton("Continua");
				vai.setBounds(64*2,(64*3)+32,64*3,64);
				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
				vai.addActionListener(new ActionListener() {
				     public void actionPerformed(ActionEvent ae) {
				    	sound.SoundButton();
				    	popupPane.removeAll();
				    	popupPane.hide();
					    popupPane.updateUI();
					    screenTurnoPlayer2();} } );} } );//player2 moves now
		risposte[2].addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//listener for set the wrong question
		    	sound.soundWrongAnswerSound();
		    	countdown.stop();
		    	risposte[1].hide();
		    	risposte[2].hide();
		    	risposte[3].hide();
		    	time.hide();
		    	popupPane.remove(textDomanda);
		    	popupPane.updateUI();

		    	setPosgioc1Back();
		    	pedGioc1.setLocation(idPuntiPlayer1.get(posgioc1-dado));
		    	billboard.updateUI();
		    	
		    	textDomanda.setText("<html><p align=center>Mi dispiace, "+name1+",non hai risposto correttamente, dovrai tornare "+città[posgioc1-dado]+"</p></html>");
		    	textDomanda.setFont(new Font("Tahoma", Font.PLAIN, 16));
				popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);
				
				JButton vai=new JButton("Torna indietro");
				vai.setBounds(64*2,(64*3)+32,64*3,64);
				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
				
				vai.addActionListener(new ActionListener() {
				     public void actionPerformed(ActionEvent ae) {
				    	sound.SoundButton();
				    	popupPane.removeAll();
				    	popupPane.hide();
					    popupPane.updateUI();
					    screenTurnoPlayer2();} } );} } );//player2 moves now
		risposte[3].addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//listener for set the wrong question
		    	sound.soundWrongAnswerSound();
		    	countdown.stop();
		    	risposte[1].hide();
		    	risposte[2].hide();
		    	risposte[3].hide();
		    	time.hide();
		    	popupPane.remove(textDomanda);
		    	popupPane.updateUI();
		    	
		    	setPosgioc1Back();
		    	pedGioc1.setLocation(idPuntiPlayer1.get(posgioc1-dado));
		    	billboard.updateUI();
		    	
		    	textDomanda.setText("<html><p align=center>Mi dispiace, "+name1+",non hai risposto correttamente, dovrai tornare "+città[posgioc1-dado]+"</p></html>");
		    	textDomanda.setFont(new Font("Tahoma", Font.PLAIN, 16));
				popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);
				
				JButton vai=new JButton("Torna indietro");
				vai.setBounds(64*2,(64*3)+32,64*3,64);
				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
				vai.addActionListener(new ActionListener() {
				     public void actionPerformed(ActionEvent ae) {
				    	sound.SoundButton();
				    	popupPane.removeAll();
				    	popupPane.hide();
					    popupPane.updateUI();
					    screenTurnoPlayer2();} } );} } );//player2 moves now
	}
	
	@SuppressWarnings("deprecation")
	public void domandaPlayer2(int posgioc2)//pop up to answer the question for player2
	{
		mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
		popupPane.show();
		popupPane.setBounds((64*4)+32,64*2,64*7,64*5);
		popupPane.setLayout(null);
		
		Point b1=new Point(16,64*3);
		Point b2=new Point((64*3)+32+16,64*3);
		Point b3=new Point(64*2,64*4);//there are the 3 points where button will be placed 
		
		JLabel textDomanda=new JLabel();
		textDomanda.setBounds(32,32,64*6,64*2);
		textDomanda.setText(core.getDomanda(posgioc2));
		textDomanda.setHorizontalAlignment(SwingConstants.CENTER);
		popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);//question text
		
		JLabel time=new JLabel("30", SwingConstants.CENTER);
		time.setFont(new Font("Tahoma", Font.PLAIN, 20));
		time.setForeground(Color.RED);
		time.setBounds(64*6,0,64,64);
		popupPane.add(time,JLayeredPane.PALETTE_LAYER);
		
		JButton[] risposte=new JButton[4];//array of 3 button(0 button not considerate)
		for(int i=1;i<=3;i++)
		{
			risposte[i]=new JButton(core.getRisposta(posgioc2,i));
			risposte[i].setSize(64*3,32+16);
			risposte[i].setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		
		long startTime=System.currentTimeMillis();
		
		Timer countdown=new Timer(1000,null);
		countdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				long diffTime = startTime-System.currentTimeMillis();
                
                int seconds = (int) (diffTime / 1000 % 60)+30;

                String s = String.valueOf(seconds).toString();;
                
                time.setText (s);
                if(seconds==0)
                {
                	sound.soundWrongAnswerSound();
    		    	countdown.stop();
    		    	risposte[1].hide();
    		    	risposte[2].hide();
    		    	risposte[3].hide();
    		    	time.hide();
    		    	popupPane.remove(textDomanda);
    		    	popupPane.updateUI();

    		    	setPosgioc2Back();
    		    	pedGioc2.setLocation(idPuntiPlayer2.get(posgioc2-dado));
    		    	billboard.updateUI();
    		    	
    		    	textDomanda.setText("<html><p align=center>Mi dispiace, "+name2+",hai esaurito il tempo per rispondere alla domanda, dovrai tornare "+città[posgioc2-dado]+"</p></html>");
    		    	textDomanda.setFont(new Font("Tahoma", Font.PLAIN, 16));
    				popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);
    				
    				JButton vai=new JButton("Torna indietro");
    				vai.setBounds(64*2,(64*3)+32,64*3,64);
    				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
    				
    				vai.addActionListener(new ActionListener() {
    				     public void actionPerformed(ActionEvent ae) {
    				    	sound.SoundButton();
    				    	popupPane.removeAll();
    				    	popupPane.hide();
    					    popupPane.updateUI();
    					    screenTurnoPlayer1();}});
                }
                }});
		countdown.start();
		
		int i=(int)Math.round((Math.random()*2)+1);//there are 3 possible layout for location of button(in this way the correct answer it won't be in same place
		if(i==1)
		{
			risposte[1].setLocation(b1);
			risposte[2].setLocation(b2);
			risposte[3].setLocation(b3);
			
			Timer timer=new Timer(1000,null); 
			timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				popupPane.add(risposte[1],JLayeredPane.PALETTE_LAYER);
				sound.soundDomanda();
				Timer timer1=new Timer(1000,null); 
				timer1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
					popupPane.add(risposte[2],JLayeredPane.PALETTE_LAYER);
					sound.soundDomanda();
					Timer timer2=new Timer(1000,null); 
					timer2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae){
						popupPane.add(risposte[3],JLayeredPane.PALETTE_LAYER);
						sound.soundDomanda();
						}});
								    	
					timer2.setRepeats(false);
					timer2.start();
					}});
							    	
				timer1.setRepeats(false);
				timer1.start();}});
						    	
			timer.setRepeats(false);
			timer.start();
		}
		else if(i==2)
		{
			risposte[1].setLocation(b2);
			risposte[2].setLocation(b1);
			risposte[3].setLocation(b3);
			
			Timer timer=new Timer(1000,null); 
			timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				popupPane.add(risposte[2],JLayeredPane.PALETTE_LAYER);
				sound.soundDomanda();
				Timer timer1=new Timer(1000,null); 
				timer1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
					popupPane.add(risposte[1],JLayeredPane.PALETTE_LAYER);
					sound.soundDomanda();
					Timer timer2=new Timer(1000,null); 
					timer2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae){
						popupPane.add(risposte[3],JLayeredPane.PALETTE_LAYER);
						sound.soundDomanda();
						}});
								    	
					timer2.setRepeats(false);
					timer2.start();
					}});
							    	
				timer1.setRepeats(false);
				timer1.start();}});
						    	
			timer.setRepeats(false);
			timer.start();
		}
		else
		{
			risposte[1].setLocation(b3);
			risposte[2].setLocation(b2);
			risposte[3].setLocation(b1);
			
			Timer timer=new Timer(1000,null); 
			timer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				popupPane.add(risposte[3],JLayeredPane.PALETTE_LAYER);
				sound.soundDomanda();
				Timer timer1=new Timer(1000,null); 
				timer1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae){
					popupPane.add(risposte[2],JLayeredPane.PALETTE_LAYER);
					sound.soundDomanda();
					Timer timer2=new Timer(1000,null); 
					timer2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae){
						popupPane.add(risposte[1],JLayeredPane.PALETTE_LAYER);
						sound.soundDomanda();
						}});
								    	
					timer2.setRepeats(false);
					timer2.start();
					}});
							    	
				timer1.setRepeats(false);
				timer1.start();}});
						    	
			timer.setRepeats(false);
			timer.start();
		}
		try{
			JLabel dietro=new JLabel();
			dietro.setBounds(0,0,64*7,64*5);
			popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
			
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			
			dietro.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}
		
		risposte[1].addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//listener for set the correct question
		    	sound.soundRightAnswerSound();
		    	countdown.stop();
		    	risposte[1].hide();
		    	risposte[2].hide();
		    	risposte[3].hide();
		    	time.hide();
		    	popupPane.remove(textDomanda);
		    	popupPane.updateUI();
		    	
		    	textDomanda.setText("<html><p align=center>Complimenti, "+name2+", hai risposto correttamente, puoi continuare il tuo viaggio</p></html>");
		    	textDomanda.setFont(new Font("Tahoma", Font.PLAIN, 16));
				popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);
				
				JButton vai=new JButton("Continua");
				vai.setBounds(64*2,(64*3)+32,64*3,64);
				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
				vai.addActionListener(new ActionListener() {
				     public void actionPerformed(ActionEvent ae) {
				    	sound.SoundButton();
				    	popupPane.removeAll();
				    	popupPane.hide();
					    popupPane.updateUI();
					    screenTurnoPlayer1();
					    } } );} } );
		
		risposte[2].addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//listener for set the wrong question
		    	sound.soundWrongAnswerSound();
		    	countdown.stop();
		    	risposte[1].hide();
		    	risposte[2].hide();
		    	risposte[3].hide();
		    	time.hide();
		    	popupPane.remove(textDomanda);
		    	popupPane.updateUI();

		    	setPosgioc2Back();
		    	pedGioc2.setLocation(idPuntiPlayer2.get(posgioc2-dado));
		    	billboard.updateUI();
		    	
		    	textDomanda.setText("<html><p align=center>Mi dispiace, "+name2+",non hai risposto correttamente, dovrai tornare a "+città[posgioc2-dado]+"</p></html>");
		    	textDomanda.setFont(new Font("Tahoma", Font.PLAIN, 16));
				popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);
				
				JButton vai=new JButton("Torna indietro");
				vai.setBounds(64*2,(64*3)+32,64*3,64);
				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
				
				vai.addActionListener(new ActionListener() {
				     public void actionPerformed(ActionEvent ae) {
				    	sound.SoundButton();
				    	popupPane.removeAll();
				    	popupPane.hide();
					    popupPane.updateUI();
					    screenTurnoPlayer1();} } );} } );
		
		risposte[3].addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//listener for set the wrong question
		    	sound.soundWrongAnswerSound();
		    	countdown.stop();
		    	risposte[1].hide();
		    	risposte[2].hide();
		    	risposte[3].hide();
		    	time.hide();
		    	popupPane.remove(textDomanda);
		    	popupPane.updateUI();
		    	
		    	setPosgioc2Back();
		    	pedGioc2.setLocation(idPuntiPlayer2.get(posgioc2-dado));
		    	billboard.updateUI();
		    	
		    	textDomanda.setText("<html><p align=center>Mi dispiace, "+name2+",non hai risposto correttamente, dovrai tornare a "+città[posgioc2-dado]+"</p></html>");
		    	textDomanda.setFont(new Font("Tahoma", Font.PLAIN, 16));
				popupPane.add(textDomanda,JLayeredPane.PALETTE_LAYER);
				
				JButton vai=new JButton("Torna indietro");
				vai.setBounds(64*2,(64*3)+32,64*3,64);
				popupPane.add(vai,JLayeredPane.PALETTE_LAYER);
				vai.addActionListener(new ActionListener() {
				     public void actionPerformed(ActionEvent ae) {
				    	sound.SoundButton();
				    	popupPane.removeAll();
				    	popupPane.hide();
					    popupPane.updateUI();
					    screenTurnoPlayer1();} } );} } );
	}
	
	@SuppressWarnings("deprecation")
	public void proclaimWinner(String winner)//pop up to show the winner
	{
		sound.stopSoundBackground();
		sound.soundWin();
		mainPane.add(popupPane,JLayeredPane.POPUP_LAYER);
		popupPane.show();
		popupPane.setBounds((64*4)+32,64*2,64*7,64*5);
		popupPane.setLayout(null);
		
		JLabel winnerText=new JLabel("<html><p align=center>Congratulazioni, "+winner+", <br>hai terminato questo fantastico viaggio nella regione Molise</p></html>",SwingConstants.CENTER);
		winnerText.setBounds(32,32,64*6,(64*2)+32);
		winnerText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		popupPane.add(winnerText,JLayeredPane.PALETTE_LAYER);
		
		JButton vaiCoda=new JButton("Guarda i titoli di coda");
		vaiCoda.setBounds(64*2,64*3,64*3,64);
		popupPane.add(vaiCoda,JLayeredPane.PALETTE_LAYER);
		
		try{
			JLabel dietro=new JLabel();
			dietro.setBounds(0,0,64*7,64*5);
			popupPane.add(dietro, JLayeredPane.DEFAULT_LAYER);
			
			sfondoPopup= ImageIO.read(this.getClass().getResource("/resources/layout/Immagine.png"));
			
			dietro.setIcon(new ImageIcon(sfondoPopup));
		}catch(IOException e){}
		
		vaiCoda.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {//listener for set the correct question
		    	sound.SoundButton();
		    	
		    	JFXPanel video=new JFXPanel();
				video.setBounds(0,0,1024,768);
				mainPane.add(video, JLayeredPane.DRAG_LAYER);
					 
				Timer timer=new Timer(87000,null); 
				timer.addActionListener(new ActionListener() {//add a listener to hide the jfxpanel when the video stops
					public void actionPerformed(ActionEvent ae){
						System.exit(0);}});
						    	
				timer.setRepeats(false);
				timer.start();
				        
				Platform.runLater(new Runnable() {//start video
				@Override
				public void run() 
				{
					Video.credits(video);
				}});} } );
	}
	
	public void setPortrait1(int portrait1)
	{
		this.portrait1=portrait1;
	}
	public void setPedina1(int pedina1)
	{
		this.pedina1=pedina1;
	}
	public void setName1(String name1)
	{
		this.name1=name1;
	}
	
	public void setPortrait2(int portrait2)
	{
		this.portrait2=portrait2;
	}
	public void setPedina2(int pedina2)
	{
		this.pedina2=pedina2;
	}
	public void setName2(String name2)
	{
		this.name2=name2;
	}
	
	public void setFirst()//for setting first player
	{
		this.first=core.randomStart();//goes in the Core class
	}
	
	public void setPosgioc1()
	{
		this.posgioc1=core.lanciaDadoPlayer1();
		this.dado=core.getDado();
		System.out.println(dado);
	}
	public void setPosgioc2()
	{
		this.posgioc2=core.lanciaDadoPlayer2();
		this.dado=core.getDado();
		System.out.println(dado);
	}
	
	public void setPosgioc1Back()
	{
		this.posgioc1=core.setPosgioc1(posgioc1);
		System.out.println(posgioc1);
		
	}
	public void setPosgioc2Back()
	{
		this.posgioc2=core.setPosgioc2(posgioc2);
		System.out.println(posgioc2);
	}
	
	public void setNomiCitta()
	{
		this.città[0]="al Liceo Scientifico A.Romità";
		this.città[1]="al Lago di Occhito";
		this.città[2]="a Pietrabbondante";
		this.città[3]="ad Agnone";
		this.città[4]="sulla casella Libeccio";
		this.città[5]="a Venafro";
		this.città[6]="a Ripalimosani";
		this.città[7]="sulla casella Tratturo";
		this.città[8]="alla Riserva MAB";
		this.città[9]="a Riccia";
		this.città[10]="sulla casella Maestrale";
		this.città[11]="a Casellino del Biferno";
		this.città[12]="a Sepino";
		this.città[13]="a Vinchiaturo";
		this.città[14]="sulla casella Tartufo";
		this.città[15]="a Campobasso";
		this.città[16]="a Termoli";
		this.città[17]="a Castelmauro";
		this.città[18]="sulla casella Bora";
		this.città[19]="ad Oratino";
		this.città[20]="a Isernia";
		this.città[21]="sulla casella della Tintilia";
		this.città[22]="a Baranello";
		this.città[23]="al Parco Nazionale d'Abruzzo, Lazio e Molise";
		this.città[24]="sulla casella Sirocco";
		this.città[25]="a Limosano";
		this.città[26]="a Torella del Sannio";
		this.città[27]="sulla casella d'arrivo!";
	}
}