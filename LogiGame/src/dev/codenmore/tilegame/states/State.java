package dev.codenmore.tilegame.states;
import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;

public abstract class State {
	//this is just a state manager, does not have to be here
	private static State currentState = null;
	
	public static void setState(State state) {
			currentState = state; }
	//when the setState method is called and a state is given then a new state is rendered

	public static State getState(){
		return currentState;}
	
	//CLASS
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;}
	
	public abstract void tick();
	public abstract void render(Graphics g);

}
