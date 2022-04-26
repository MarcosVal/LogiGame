package dev.codenmore.tilegame.gfx;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 64, height = 64, temp = 32; 
	//setting each square's size to width and height to make cropping easier
	
	public static BufferedImage brick, marble, tree;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_still;
	public static BufferedImage[] play_button, settings_button, quit_button, back_button, controls_button;
	public static BufferedImage[] activator, gate, key, problem;
	
	public static void init() {
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/grid1.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/grid2.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/grid3.png"));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/grid4.png"));
		
		//tiles
		brick = sheet1.crop(0, 0, width, height);
		marble = sheet1.crop(width, 0, width, height);
		
		//animations
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_still = new BufferedImage[2];
		
		player_down[0] = sheet2.crop(0, 0, temp, temp);
		player_down[1] = sheet2.crop(32, 0, temp, temp);
		player_up[0] = sheet2.crop(64, 0, temp, temp);
		player_up[1] = sheet2.crop(96, 0, temp, temp);
		player_left[0] = sheet2.crop(64, 32, temp, temp);
		player_left[1] = sheet2.crop(96, 32, temp, temp);
		player_right[0] = sheet2.crop(0, 32, temp, temp);
		player_right[1] = sheet2.crop(32, 32, temp, temp);
		player_still[0] = sheet2.crop(0, 64, temp, temp);
		player_still[1] = sheet2.crop(32, 64, temp, temp);
		
		//games
		activator = new BufferedImage[3];
		key = new BufferedImage[3];
		gate = new BufferedImage[3];
		
		activator[0] = sheet3.crop(0, 0, width, height);
		gate[0] = sheet3.crop(64, 0, width, height);
		key[0] = sheet3.crop(128, 0, width, height);
		activator[1] = sheet3.crop(0, 64, width, height);
		gate[1] = sheet3.crop(64, 64, width, height);
		key[1] = sheet3.crop(128, 64, width, height);
		activator[2] = sheet3.crop(0, 128, width, height);
		gate[2] = sheet3.crop(64, 128, width, height);
		key[2] = sheet3.crop(128, 128, width, height);
		
		//menus
		play_button = new BufferedImage[2];
		settings_button = new BufferedImage[2];
		quit_button = new BufferedImage[2];
		back_button = new BufferedImage[2];
		controls_button = new BufferedImage[2];
		
		play_button[0] = sheet4.crop(0, 0, 120, 40);
		play_button[1] = sheet4.crop(0, 40, 120, 40);
		settings_button[0] = sheet4.crop(0, 80, 120, 40);
		settings_button[1] = sheet4.crop(0, 120, 120, 40);
		quit_button[0] = sheet4.crop(0, 160, 120, 40);
		quit_button[1] = sheet4.crop(0, 200, 120, 40);
		back_button[0] = sheet4.crop(0, 240, 120, 40);
		back_button[1] = sheet4.crop(0, 280, 120, 40);
		controls_button[0] = sheet4.crop(0, 320, 120, 40);
		controls_button[1] = sheet4.crop(0, 360, 120, 40);
		
		//problems
		problem = new BufferedImage[30];
		problem[0] = ImageLoader.loadImage("/textures/problem0.png");
		problem[1] = ImageLoader.loadImage("/textures/problem1.png");
		problem[2] = ImageLoader.loadImage("/textures/problem2.png");
		
	}
}
