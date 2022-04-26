package dev.codenmore.tilegame.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.items.Item;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;

	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();}
	
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE))
			active = !active; // this is to toggle the inventory
		if(!active)
			return;
		System.out.println("INVENTORY:");
		for(Item i : inventoryItems) {
			System.out.println(i.getName() + " " + i.getCount());}}
	
	public void render(Graphics g) {
		if(!active)
			return;}
	
	//Inventory methods
	public void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;}
			}//goes through inventory, if this one is new it will add it
		inventoryItems.add(item);
	}
	
	//getters + setters
	public Handler getHandler() {
		return handler;}
	public void setHandler(Handler handler) {
		this.handler = handler;}
}
