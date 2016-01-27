import java.awt.*;
import java.util.ArrayList;
/**
 * Drawing.java
 * Contains shapes in order.
 * 
 * @author Yuan Gao
 */
public class Drawing {
	private Color defaultColor;
	private ArrayList<Shape> allShape;
	
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
		for (Shape theShape: allShape) {
			theShape.draw(page);
		}
	}
	
	/**
	 * Find the frontmost Shape in the drawing that contains a certain point
	 * 
	 * @param p a reference to a point
	 * @return the frontmost shape that contains the Point, 
	 * or null if no Shape contains the Point
	 */
	public Shape getFrontmostContainer(Point p) {
		Shape frontShape = null;
		
		for (Shape aShape: allShape) {
			if (aShape.containsPoint(p)) {
				frontShape = aShape;
			}
		}
		return frontShape;
	}
	
	/**
	 * Add a new shape to the drawing
	 * @param newShape the added shape
	 */
	public void addShape(Shape newShape) {
		allShape.add(newShape);
	}
	
	/**
	 * Remove a certain shape from the drawing
	 * @param removedShape the shape being removed
	 */
	public void removeShape(Shape removedShape) {
		allShape.remove(removedShape);
	}
	
	/**
	 * Move a shape to the front of the linear ordering of objects in the drawing
	 * @param movedShape the shape being moved to the front
	 */
	public void moveFront(Shape movedShape) {
		int oldIndex = allShape.indexOf(movedShape);
		swap(oldIndex, oldIndex + 1);
	}
	
	/**
	 * 
	 * @param movedShape
	 */
	public void moveBack(Shape movedShape) {
		int oldIndex = allShape.indexOf(movedShape);
		if (oldIndex > 0) {
			swap(oldIndex, oldIndex -1);
		}
	}
	
	/**
	 * Get the current default color of the drawing
	 * @return current default color
	 */
	public Color getColor() {
		return defaultColor;
	}


	// helper method
	private void swap(int index1, int index2) {
		Shape moveShape = allShape.get(index1);
		allShape.set(index1, allShape.get(index2));
		allShape.set(index2, moveShape);
	}
}
