package dev.codenmore.tilegame.entities.statics;
import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;

public class Gate extends StaticEntity{
	
	private int colour;

	public Gate(Handler handler, float x, float y, int colour) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.x = 10;
		bounds.y = 20;
		bounds.width = width-20;
		bounds.height = height-40;
		this.colour = colour;
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gate[colour], (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);}

	@Override
	public void die() {}
	
}


