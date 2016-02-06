import java.awt.*;
import java.util.ArrayList;
/**
 * Drawing.java
 * Handles a list of shapes.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 */
public class Drawing {
	private Color defaultColor; // drawing's current color
	private ArrayList<Shape> allShape; // all shapes currently exist on canvas
	private Shape recentShape; // the shape that changes most recently
	
	/**
	 * Create an empty drawing with an initial default color
	 * 
	 * @param dColor the current default color
	 */
	public Drawing(Color dColor) {
		defaultColor = dColor;
		allShape = new ArrayList<Shape>();
	}
	
	/**
	 * Have each shape in the drawing draw itself
	 * 
	 * @param page the Graphics object to draw on
	 */
	public void draw(Graphics page) {
		
		for (int i = allShape.size() - 1; i >= 0; i--) {
			allShape.get(i).draw(page);
		}
	}
	
	/**
	 * Find the frontmost Shape in the drawing that contains a certain point
	 * 
	 * @param p a reference to a point
	 * @return the frontmost shape that contains the Point, or null if no 
	 * Shape contains the Point
	 */
	public Shape getFrontmostContainer(Point p) {
		Shape frontShape = null;
		int i = 0;
		while (frontShape == null && i < allShape.size()) {
			if (allShape.get(i).containsPoint(p)) {
				frontShape = allShape.get(i); 
			}
			i++;
		}
		
		return frontShape;
	}
	
	/**
	 * Add a new shape to the drawing
	 * 
	 * @param newShape the added shape
	 */
	public void addShape(Shape newShape) {
		allShape.add(0, newShape);
		recentShape = allShape.get(0);
	}
	
	/**
	 * Add a copy of a specified shape to the drawing
	 * The copy is immediately to the front of the original
	 * 
	 * @param copiedShape the shape to be copied
	 */
	public void addCopy(Shape copiedShape) {
		int index = allShape.lastIndexOf(copiedShape);
		allShape.add(index, copiedShape);
		recentShape = allShape.get(index);
	}
	
	/**
	 * Remove a certain shape from the drawing
	 * 
	 * @param removedShape the shape being removed
	 */
	public void removeShape(Shape removedShape) {
		allShape.remove(removedShape);
		recentShape = removedShape;
	}
	
	/**
	 * Move a shape to the front of the linear ordering of objects in the drawing
	 * 
	 * @param movedShape the shape being moved to the front
	 */
	public void moveFront(Shape aShape) {
		Shape movedShape = aShape;
		allShape.remove(aShape);
		allShape.add(0, movedShape);
		recentShape = aShape;
	}
	
	/**
	 * Move a shape to the back of the linear ordering of objects in the drawing
	 * 
	 * @param movedShape
	 */
	public void moveBack(Shape aShape) {
		Shape movedShape = aShape;
		allShape.remove(aShape);
		allShape.add(allShape.size(), movedShape);
		recentShape = aShape;
	}
	
	/**
	 * Get the current default color of the drawing
	 * @return current default color
	 */
	public Color getColor() {
		return defaultColor;
	}
	
	/**
	 * Set the default color of the drawing
	 * @return new default color
	 */
	public void setColor(Color newColor) {
		defaultColor = newColor;
	}

	/**
	 * Get the last modified shape
	 * @return the shape that changed most recently
	 */
	public Shape getRecentShape() {
		return recentShape;
	}
	
	public void drawGrid(int spacing, int width, int height) {
  	  for (int i = 0; i <= height; i += spacing) {
		  
  	  }
	}
}
