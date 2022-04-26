package dev.codenmore.tilegame.tiles;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF:
	//these are single instances of each tile being stored in an array to be used many times
	public static Tile[] tiles = new Tile[256];
	public static Tile marbleTile = new MarbleTile(0);
	//public static Tile dirtTile = new DirtTile(1);
	public static Tile brickTile = new BrickTile(2);
	
	//CLASS:
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	protected BufferedImage texture;
	protected final int id; //final because each id should not be changed
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this; //id works as and index in this array
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_HEIGHT, TILE_WIDTH, null);
	}
	
	public boolean isSolid() {
		return false;} //returns false by default to all tiles
	
	public int getId() {
		return id;}
}
