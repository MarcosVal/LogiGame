package dev.codenmore.tilegame.entities.statics;
import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.items.Item;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;

public class Activator extends StaticEntity{
	
	int id, colour;
	
	public Activator(Handler handler, float x, float y, int colour, int id) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.x = 10;
		bounds.y = 10;
		bounds.width = width-20;
		bounds.height = height-0;
		this.id = id;
		this.colour = colour;}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.activator[colour], (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);}

	@Override
	public void die() {
		if(colour==0) {
			handler.getWorld().getItemManager().addItem(Item.cyanKey.createNew((int) x +180, (int) y));}
		else if(colour==1){
			handler.getWorld().getItemManager().addItem(Item.redKey.createNew((int) x -50, (int) y -50));}
		else if(colour==2){
			handler.getWorld().getItemManager().addItem(Item.goldKey.createNew((int) x +240, (int) y -200));}
		}
}
