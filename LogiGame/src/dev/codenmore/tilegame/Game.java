package dev.codenmore.tilegame;

import java.awt.Graphics;

import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JTextField;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.ProblemState;
import dev.codenmore.tilegame.states.SettingsState;
import dev.codenmore.tilegame.states.State;


public class Game implements Runnable{

	private Display display;
	private int width, height;
	public String title;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State theGame;
	public State theMenu;
	public State theSettings;
	public State prob0, prob1, prob2, prob3;
	//Input
	private KeyManager theKeys;
	private MouseManager mouseManager; 
	
	//Camera:
	private GameCamera gameCamera;
	
	//Handler:
	private Handler handler;
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		theKeys = new KeyManager();
		
		mouseManager = new MouseManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(theKeys);
		//display.getFrame().addMouseListener(new MouseInput(handler));
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		
		
		Assets.init(); //assets loaded right after display
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		//initialising the states
		theGame = new GameState(handler);
		theMenu = new MenuState(handler);
		theSettings = new SettingsState(handler);
		prob0 = new ProblemState(handler, 0);
		prob1 = new ProblemState(handler, 1);
		prob2 = new ProblemState(handler, 2);
		prob3 = new ProblemState(handler, 3);
		
		
		State.setState(theMenu);
		//State.setState(prob0);
		//State.setState(theGame);
	}
	
	
	private void tick(){
		theKeys.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;}
		g = bs.getDrawGraphics();
		//Clear screen
		g.clearRect(0, 0, width, height);
		//Draw:
		
		
		if(State.getState() != null)
			State.getState().render(g);
		
		
		//End
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		final int fps = 60;
		//max amount of time we run the tick and render methods 
		double timePerTick = 1000000000 / fps; 
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime(); 
			//sets "now" as the computer's time in nanoseconds
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;}
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: "+ ticks);
				ticks = 0;
				timer = 0;}
			}
		stop();
	}
	
	//this is a getter it returns "theKeys" so other classes can access it
	public KeyManager getKeyManager() {
		return theKeys;}
	//same applies for gameCamera: 
	public GameCamera getGameCamera() {
		return gameCamera;}  
	
	public int getWidth() {
		return width;}
	public int getHeight() {
		return height;}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	public Display getDisplay() {
		return display;
	}
	
	
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
