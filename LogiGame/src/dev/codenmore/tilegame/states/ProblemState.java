package dev.codenmore.tilegame.states;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.display.AnswerBox;
import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.entities.EntityManager;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.statics.Activator;
import dev.codenmore.tilegame.entities.statics.Problem;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.ClickListener;
import dev.codenmore.tilegame.utils.Utils;

public class ProblemState extends State{

	EntityManager uiManager; 
	private int id;
	Display display;
	JFrame frame;
	boolean alreadyExecuted = false;
	AnswerBox answerBox;
	
	public ProblemState(Handler handler, int id) {
		super(handler);
		this.id = id;
		System.out.println("PROB ACTIVE");}
	
	public void tick() {}

	public void render(Graphics g) {
		g.drawImage(Assets.problem[id], 0, 0, 1500, 750, null);
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q))
			//handler.getKeyManager().interact = false;
			State.setState(handler.getGame().theGame);
		
		//This will create the answer box just once
		if(!alreadyExecuted) {
			answerBox = new AnswerBox();
		    alreadyExecuted = true;}
		
		if(answerBox.isConfirmed()) {
			answerBox.checkAnswer(id, handler); 
			alreadyExecuted = false;
			answerBox.getF().dispose();
			State.setState(handler.getGame().theGame);
			answerBox.setConfirmed(false);}		
	}
	
	


}
