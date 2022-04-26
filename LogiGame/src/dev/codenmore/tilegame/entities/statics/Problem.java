package dev.codenmore.tilegame.entities.statics;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;

public class Problem extends StaticEntity{
	
	public Problem(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		
		
	}

	
	public void tick() {
		
	}

	
	public void render(Graphics g) {
		g.drawImage(Assets.problem[0], (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), 1500, 750, null);
		
	}

	
	public void die() {
		
		
	}

}
