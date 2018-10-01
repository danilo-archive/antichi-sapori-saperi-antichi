package game;

import java.awt.EventQueue;

public class Main 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame fin=new MainFrame();
					fin.startScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
