package dev.codenmore.tilegame.states;
import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.statics.Tree;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.worlds.World;

public class GameState extends State{
	
	private World world1;

	public GameState(Handler handler) {
		super(handler);
		world1 = new World(handler, "resources/worlds/world1.txt");
		System.out.println("GAME ACTIVE");
	}
	
	@Override //every state needs a tick and render method
	public void tick() {
		world1.tick();}

	@Override
	public void render(Graphics g) {
		world1.render(g);
		
	}
}
