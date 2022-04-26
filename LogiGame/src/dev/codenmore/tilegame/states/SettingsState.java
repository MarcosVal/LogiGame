
//SO FAR THIS IS JUST A LAYOUT FOR THE MENU

package dev.codenmore.tilegame.states;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.ClickListener;
import dev.codenmore.tilegame.ui.UIimageButton;
import dev.codenmore.tilegame.ui.UImanager;


public class SettingsState extends State{
	
	private UImanager uiManager;
	
	public SettingsState(Handler handler) {
		super(handler);
		uiManager = new UImanager(handler);
		System.out.println("SETTINGS ACTIVE");
		
		//SWITCH 
		uiManager.addObject(new UIimageButton(handler.getGame().getWidth()/2 - 360/2, 300,
				360, 120, Assets.controls_button, new ClickListener() {
			public void onClick() {
				handler.getKeyManager().setControlsWASD(!handler.getKeyManager().isControlsWASD());}}));
		
		//BACK
		uiManager.addObject(new UIimageButton(handler.getGame().getWidth()/2 - 360/2, 450,
				360, 120, Assets.back_button, new ClickListener() {
			public void onClick() {
				State.setState(handler.getGame().theMenu);}}));}
		
		//FRAMES (to be added)
	
	public void tick() {
		uiManager.tick();}

	public void render(Graphics g) {
		handler.getMouseManager().setUImanager(uiManager);
		uiManager.render(g);
		g.setColor(Color.magenta);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);
		//TITLE
		Graphics2D g2d = (Graphics2D) g;
		//Initialising the font
		Font fnt0 = new Font("Eras Bold ITC", Font.PLAIN, 120);
		//Getting the fonts' metrics to get their widths
		FontMetrics fTitle = g.getFontMetrics(fnt0);
		g.setFont(fnt0);
		g.setColor(Color.CYAN);
		int titleWid = fTitle.stringWidth("settings"); 
		g.drawString("settings", ((handler.getWidth() /2) - (titleWid/2)), 200);	
		
	}

}
