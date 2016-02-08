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
	}
	
	/**
	 * Add a copy of a specified shape to the drawing
	 * The copy is put immediately after the original
	 * 
	 * @param copy the copy of the original
	 * @param original the original shape
	 */
	public void addCopy(Shape copy, Shape original) {
		int index = allShape.indexOf(original);
		allShape.add(index + 1, copy);
	}
	
	/**
	 * Remove a certain shape from the drawing
	 * 
	 * @param removedShape the shape being removed
	 */
	public void removeShape(Shape removedShape) {
		allShape.remove(removedShape);
	}
	
	/**
	 * Move a shape to the front of the linear ordering of objects in the drawing
	 * 
	 * @param aShape the shape being moved to the front
	 */
	public void moveFront(Shape s) {
		allShape.remove(s);
		allShape.add(0, s);
	}
	
	/**
	 * Move a shape to the back of the linear ordering of objects in the drawing
	 * 
	 * @param aShape the shape being moved to the back
	 */
	public void moveBack(Shape s) {
		allShape.remove(s);
		allShape.add(allShape.size(), s);
	}
	
	/**
	 * Get the index of a certain shape
	 */
	public int getIndex(Shape s) {
		return allShape.indexOf(s);
	}
	
	/**
	 * Move a shape to a certain index
	 * @param i given index
	 * @param s given shape
	 */
	public void moveToIndex(int i, Shape s) {
		allShape.remove(s);
		allShape.add(i, s);
	}
	
	/**
	 * Get the current default color of the drawing
	 * 
	 * @return current default color
	 */
	public Color getColor() {
		return defaultColor;
	}
	
	/**
	 * Set the default color of the drawing
	 * 
	 * @return new default color
	 */
	public void setColor(Color newColor) {
		defaultColor = newColor;
	}
}
