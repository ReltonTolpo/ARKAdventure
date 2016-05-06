package ark.adventure;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class GamePanel extends Canvas implements Runnable{
private static final long serialVersionUID = 2009862575529087230L;
public static int WIDTH = 200;  // width of game windows
public static int HEIGHT = WIDTH /12 * 9;  // height of our  game windows
public static int SCALE = 3; // scaling window
private JFrame frame;
BufferStrategy bs; //create an strategy for multi-buffering.
Boolean NeedToExit; // set to true for game to quit

//Timing for screen updates
int ticks = 0;
int frames = 0;

ARKAdventure mainClass = new ARKAdventure();

String winName = ("Inventory");

public void GamePanel(){

    setMinimumSize(new Dimension (WIDTH * SCALE, HEIGHT*SCALE));

    setMaximumSize(new Dimension (WIDTH * SCALE, HEIGHT*SCALE));

    setPreferredSize(new Dimension (WIDTH * SCALE, HEIGHT*SCALE));	

    frame = new JFrame(winName);
    frame.setLayout(new BorderLayout());
    frame.add(this,BorderLayout.CENTER);
    frame.pack();
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    // screen graphics

	createBufferStrategy(2);//jframe extends windows so i can call this method 

    bs = this.getBufferStrategy();//returns the buffer strategy used by this component

    NeedToExit = false;

}



public static void main(String[] args) {

	new GamePanel().start();

}



public synchronized void start() {

	NeedToExit = false;

	new Thread(this).start();

}



public synchronized void stop(){

	NeedToExit = true;

}





@Override

public void run() {

	long lastTime = System.nanoTime();

	double nsPerTick = 1000000000D / 60D;

	




	long lastTimer = System.currentTimeMillis();

	double delta = 0;

	

	while (!NeedToExit) 

	{

		long now = System.nanoTime();

		delta+=(now-lastTime) / nsPerTick;

		lastTime = now;

		

		while (delta>=1) 

		{

			ticks++;

			// Leo :  call you function to update your game;

			UpdateGame();

			delta-=1;

		}

		frames++;

		// Leo: Call your function to draw your screen;

		RenderGame();

		

		if (System.currentTimeMillis() - lastTimer >= 1000) {

			lastTimer+=1000;

			//System.out.println("Frames per second ="+frames);

			ticks=0;

			frames=0;

		}

		

	}

	// exit game completely

	System.exit(0);

}



public void UpdateGame() {

	// Leo:  put your code here to run your game

};



public void RenderGame() {

	

	Graphics2D g2=null;//create a child object of Graphics

	

	try{

	    g2 = (Graphics2D) bs.getDrawGraphics();

	    // Leo:  Here are the commands to draw the screen




	    

	} finally {

	       g2.dispose();

	}

	bs.show();

	

}








}
