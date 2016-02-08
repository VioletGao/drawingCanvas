import java.awt.Graphics;

/**
 * /**
 * Grid.java
 * Class for a grid.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class Grid {
	
	private int spacing; // the space between each line of the grid
	
	/**
	 * Create a new grid given a value of space between grid
	 * 
	 * @param s space between grid
	 */
	public Grid(int s) {
		spacing = s;
	}
	
	/**
	 * Draw the grid on canvas
	 * 
	 * @param width the width of the canvas
	 * @param height the height of the canvas
	 * @param page the Graphics object to be drew on
	 */
	public void draw(int width, int height, Graphics page) {
		for (int x = spacing; x < width; x += spacing) {
			page.drawLine(x, 0, x, height);
		}
		for (int y = spacing; y < height; y += spacing) {
			page.drawLine(0, y, width, y);
		}
	}
}
