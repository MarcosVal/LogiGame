package dev.codenmore.tilegame.worlds;
import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.EntityManager;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.statics.Activator;
import dev.codenmore.tilegame.entities.statics.Gate;
import dev.codenmore.tilegame.entities.statics.Tree;
import dev.codenmore.tilegame.items.ItemManager;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;

public class World {
	
	private Handler handler; 
	private int width, height;
	private int spawnX, spawnY;
	private int[][] TILES;
	
	//Entities
	private EntityManager entityManager;
	//Item
	private ItemManager itemManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		
		//TEMPORARY EXAMPLE OF ENTITY PLACEMENT:
		entityManager.addEntity(new Activator(handler, 120, 80, 0, 0));
		entityManager.addEntity(new Activator(handler, 864, 600, 1, 0));
		entityManager.addEntity(new Activator(handler, 1100, 128, 2, 0));
		//entityManager.addEntity(new Activator(handler, 1000, 1000, 2, 0));
		//entityManager.addEntity(new Gate(handler, 832, 200, 0));
		//entityManager.addEntity(new Gate(handler, 864, 200, 0));
		//entityManager.addEntity(new Gate(handler, 896, 200, 0));
		entityManager.addEntity(new Gate(handler, 1000, 64, 1));
		entityManager.addEntity(new Gate(handler, 1000, 96, 1));
		entityManager.addEntity(new Gate(handler, 1000, 128, 1));
		entityManager.addEntity(new Gate(handler, 1000, 160, 1));
		entityManager.addEntity(new Gate(handler, 400, 576, 2));
		entityManager.addEntity(new Gate(handler, 400, 608, 2));
		entityManager.addEntity(new Gate(handler, 400, 640, 2));
		
		loadWorld(path);
		handler.setWorld(this);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
		
	}
	
	public void render(Graphics g) {
		//these Start and End coordinates will help render the tiles only in our screen
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset()) / Tile.TILE_WIDTH+1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(0, (handler.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT+1);
		
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				getTile(x, y).render(g, (int)(x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int)(y*Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
				//to position the tiles on the pixels OUT of the previous rendered tile 
			}
		}
		//Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x<0 || y<0 || x>=width || y>=height)
			return Tile.marbleTile; 
		// this is to prevent errors if the player leaves bounds
		
		Tile t = Tile.tiles[TILES[x][y]];
		if(t == null)
			return Tile.marbleTile;
		return t;
	}
	
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); //this splits up each number in the file into the array "tokens"
		//from the array:
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		TILES = new int[width][height];
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				TILES[x][y] = Utils.parseInt(tokens[(x + y*width)+4]); //sets the IDs for the tiles array
			}
		}
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;}
	
	public int getWidth() {
		return width;}
	public int getHeight() {
		return height;}

	public Handler getHandler() {
		return handler;}
	public void setHandler(Handler handler) {
		this.handler = handler;}

	public ItemManager getItemManager() {
		return itemManager;}
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;}
	
	
}
