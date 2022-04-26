package dev.codenmore.tilegame.tiles;
import dev.codenmore.tilegame.gfx.Assets;

public class BrickTile extends Tile {

	public BrickTile(int id) {
		super(Assets.brick, id);}
	
	@Override 
	//this method is overriding one from the Tile
	//class which by default returns false
	public boolean isSolid() {
		return true;}
}

