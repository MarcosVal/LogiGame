package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.display.AnswerBox;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.inventory.Inventory;
import dev.codenmore.tilegame.states.State;
import dev.codenmore.tilegame.utils.Utils;

public class Player extends Creature {

	// animations
	public Animation aniDown, aniUp, aniLeft, aniRight, aniStill;
	// inventory
	private Inventory inventory;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_HEIGHT, Creature.DEFAULT_CREATURE_WIDTH);

		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;

		// Animations
		aniDown = new Animation(500, Assets.player_down);
		aniUp = new Animation(500, Assets.player_up);
		aniLeft = new Animation(500, Assets.player_left);
		aniRight = new Animation(500, Assets.player_right);
		aniStill = new Animation(500, Assets.player_still);

		inventory = new Inventory(handler);
	}

	public void tick() {
		// Animations:
		aniDown.tick();
		aniUp.tick();
		aniLeft.tick();
		aniRight.tick();
		aniStill.tick();
		// Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		// Interact
		checkInteract();
		// Inventory
		inventory.tick();
	}
	
	Rectangle ir = new Rectangle();
	public void checkInteract() {
		Rectangle cb = getCollisionBounds(0, 0);
		//Rectangle ir = new Rectangle();
		int irSize = 20;
		ir.width = irSize;
		ir.height = irSize;
		// ir is an invisible interaction rectangle that will be around the player at
		// all times. I will use it to check if the player is close to a certain entity

		//if (handler.getKeyManager().interact) {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			
			if (handler.getKeyManager().up) {
				ir.x = cb.x + cb.width / 2 - irSize / 2;
				ir.y = cb.y - irSize;
			} else if (handler.getKeyManager().down) {
				ir.x = cb.x + cb.width / 2 - irSize / 2;
				ir.y = cb.y + cb.height;
			} else if (handler.getKeyManager().left) {
				ir.x = cb.x - irSize;
				ir.y = cb.y + cb.height / 2 - irSize / 2;
			} else if (handler.getKeyManager().right) {
				ir.x = cb.x + cb.width;
				ir.y = cb.y + cb.height / 2 - irSize / 2;
			} else {
				return;}

			for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
				if (e.equals(this))
					continue;
				if (e.getCollisionBounds(0, 0).intersects(ir)) {
					// handler.getKeyManager().interact = false;
					//handler.getWorld().getEntityManager().getEntities().get(index)
					int location = (int) e.getY();
					if(location==80) {
						State.setState(handler.getGame().prob0);
						return;}
					else if(location==600){
						State.setState(handler.getGame().prob1);
						return;}
					else if(location==128){
						State.setState(handler.getGame().prob2);
						return;}
					else if(location==500){
						State.setState(handler.getGame().prob3);
						return;}}}
			}
		}

	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		if (handler.getKeyManager().up)
			yMove = -speed; //y-axis is flipped
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;}

	public void die() {
		//could later implement player death
		}

		

	public void render(Graphics g) {
		// since x/y are floats we must turn them into usable coordinates
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		inventory.render(g);}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return aniLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return aniRight.getCurrentFrame();
		} else if (yMove > 0) {
			return aniDown.getCurrentFrame();
		} else if (yMove < 0) {
			return aniUp.getCurrentFrame();
		} else {
			return aniStill.getCurrentFrame();
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Rectangle getIr() {
		return ir;
	}

	public void setIr(Rectangle ir) {
		this.ir = ir;
	}
}

// g.setColor(Color.red);
// g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
// (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
// bounds.width, bounds.height);
