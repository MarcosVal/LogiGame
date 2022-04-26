package dev.codenmore.tilegame.entities;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;

public class EntityManager {

	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities; 
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		//compares two entities to see which one is above the other to render in order
		public int compare(Entity a, Entity b) {
			if(a.getY()+a.getHeight() < b.getY()+b.getHeight()){
				return -1;}
			return 1;}};
	
	//So that I can add and remove as many entities as I want 
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive())
				it.remove();
			}
		entities.sort(renderSorter);}
	
	public void render(Graphics g) {
		//this line creates an entity e for every entity in the arraylist
		for(Entity e : entities) { 
			e.render(g);}
		}
	
	//Getters+Setters
	public Player getPlayer() {
		return player;}
	public void setPlayer(Player player) {
		this.player = player;}

	public ArrayList<Entity> getEntities() {
		return entities;}
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;}
	public void addEntity(Entity e) {
			entities.add(e);}

	public void setHandler(Handler handler) {
		this.handler = handler;}
	public Handler getHandler() {
		return handler;}
	}

	

	
	
	
