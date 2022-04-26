package dev.codenmore.tilegame;

import javax.swing.JFrame;

import dev.codenmore.tilegame.display.AnswerBox;
import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;
import dev.codenmore.tilegame.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	private AnswerBox f;
	
	public Handler(Game game) {
		this.game = game;
		
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();}
	
	public int getWidth() {
		return game.getWidth();}
	
	public int getHeight() {
		return game.getHeight();}
	
	public Game getGame() {
		return game;}
	public void setGame(Game game) {
		this.game = game;}

	public World getWorld() {
		return world;}
	public void setWorld(World world) {
		this.world = world;}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public Display getDisplay() {
		return game.getDisplay();}
	

}

	


