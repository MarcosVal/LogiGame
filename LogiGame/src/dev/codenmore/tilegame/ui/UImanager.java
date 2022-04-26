package dev.codenmore.tilegame.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.codenmore.tilegame.Handler;

public class UImanager {

	private Handler handler;
	private ArrayList<UIobject> objects;
	
	public UImanager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<UIobject>();}
	
	public void tick() {
		for(UIobject o : objects)
			o.tick();}
	
	public void render(Graphics g) {
		for(UIobject o : objects)
			o.render(g);}
	
	public void onMouseMove(MouseEvent e) {
		for(UIobject o : objects)
			o.onMouseMove(e);}
	public void onMouseRelease(MouseEvent e) {
		for(UIobject o : objects)
			o.onMouseRelease(e);}
	
	public Handler getHandler() {
		return handler;}
	public void setHandler(Handler handler) {
		this.handler = handler;}

	public ArrayList<UIobject> getObjects() {
		return objects;}
	public void setObjects(ArrayList<UIobject> objects) {
		this.objects = objects;}

	public void addObject(UIobject o) {
		objects.add(o);}
	public void removeObject(UIobject o) {
		objects.remove(o);}
	}
