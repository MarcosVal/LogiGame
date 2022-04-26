package dev.codenmore.tilegame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.codenmore.tilegame.ui.UImanager;

public class MouseManager implements MouseListener, MouseMotionListener {

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UImanager uiManager;
	
	public MouseManager() {}
	
	//Getters
	public boolean isLeftPressed() {
		return leftPressed;}
	public boolean isRightPressed() {
		return rightPressed;}
	public int getMouseX() {
		return mouseX;}
	public int getMouseY() {
		return mouseY;}
	public void setUImanager(UImanager uiManager) {
		this.uiManager = uiManager;}
	
	//Implemented methids
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		if(uiManager != null)
			uiManager.onMouseRelease(e);}

	public void mouseMoved(MouseEvent e) {
		mouseY = e.getY();
		mouseX = e.getX();
		//So the game does not always have a UI manager
		if(uiManager != null) 
			uiManager.onMouseMove(e);}
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
}
