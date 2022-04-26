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

public class MenuState extends State {

	// private MenuScreen menu;
	private UImanager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UImanager(handler);
		System.out.println("MENU ACTIVE");

		// PLAY BUTTON
		uiManager.addObject(new UIimageButton(handler.getGame().getWidth() / 2 - 360 / 2, 300, 360, 120,
				Assets.play_button, new ClickListener() {
					public void onClick() {
						handler.getMouseManager().setUImanager(null);
						// so buttons get no input once the game starts
						State.setState(handler.getGame().theGame);}}));

		// QUIT
		uiManager.addObject(new UIimageButton(handler.getGame().getWidth() / 2 - 360 / 2, 600, 360, 120,
				Assets.quit_button, new ClickListener() {
					public void onClick() {
						System.exit(1);}}));

		// SETTINGS BUTTON
		uiManager.addObject(new UIimageButton(handler.getGame().getWidth() / 2 - 360 / 2, 450, 360, 120,
				Assets.settings_button, new ClickListener() {
					public void onClick() {
						State.setState(handler.getGame().theSettings);}}));
		}

	public void tick() {
		uiManager.tick();}

	public void render(Graphics g) {
		handler.getMouseManager().setUImanager(uiManager);
		uiManager.render(g);
		g.setColor(Color.magenta);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);

		// TITLE
		Graphics2D g2d = (Graphics2D) g;

		// Initialising the font
		Font fnt0 = new Font("Eras Bold ITC", Font.BOLD, 150);

		// Getting the fonts' metrics to get their widths
		FontMetrics fTitle = g.getFontMetrics(fnt0);

		g.setFont(fnt0);
		g.setColor(Color.CYAN);
		int titleWid = fTitle.stringWidth("LogiGame");
		g.drawString("LogiGame", ((handler.getWidth() / 2) - (titleWid / 2)), 200);}

}
