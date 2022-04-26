package dev.codenmore.tilegame.input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{ 
	// keylistener manages inputs

	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right, interact, leave;
	public boolean controlsWASD = true;
	
	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[256];
		cantPress = new boolean[256];
	}
	
	public void tick() {
		for(int i=0; i< keys.length; i++) {
			if(cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			}else if(justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;}
			
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;}
			}
		
		if(controlsWASD) {
			if(keyJustPressed(KeyEvent.VK_E))
				System.out.println("Interact Button Pressed");
			up = keys[KeyEvent.VK_W];
			down = keys[KeyEvent.VK_S];
			left = keys[KeyEvent.VK_A];
			right = keys[KeyEvent.VK_D];
			leave = keys[KeyEvent.VK_Q];}
		else {
			if(keyJustPressed(KeyEvent.VK_K))
				System.out.println("Interact Button Pressed");
			up = keys[KeyEvent.VK_UP];
			down = keys[KeyEvent.VK_DOWN];
			left = keys[KeyEvent.VK_LEFT];
			right = keys[KeyEvent.VK_RIGHT];
			leave = keys[KeyEvent.VK_L];}
		}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];}
	
	public boolean isControlsWASD() {
		return controlsWASD;}
	public void setControlsWASD(boolean controlsWASD) {
		this.controlsWASD = controlsWASD;}
}
