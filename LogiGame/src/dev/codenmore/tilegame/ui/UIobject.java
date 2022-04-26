package dev.codenmore.tilegame.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIobject {
	
	protected float x, y;
	protected int width, height;
	protected boolean hovering = false;
	protected Rectangle bounds;
	
	public UIobject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick();
	//every UI component will have access to whether they were clicked
	
	public void onMouseMove(MouseEvent e) {
		if(bounds.contains(e.getX(), e.getY()))
			hovering = true;
		else
			hovering = false;}
	
	public void onMouseRelease(MouseEvent e) {
		if(hovering)
			onClick();}
	
	//getters + setters
	public float getX() {
		return x;}
	public void setX(float x) {
		this.x = x;}
	public float getY() {
		return y;}
	public void setY(float y) {
		this.y = y;}

	public int getWidth() {
		return width;}
	public void setWidth(int width) {
		this.width = width;}
	public int getHeight() {
		return height;}
	public void setHeight(int height) {
		this.height = height;}

	public boolean isHovering() {
		return hovering;}
	public void setHovering(boolean hovering) {
		this.hovering = hovering;}
}
