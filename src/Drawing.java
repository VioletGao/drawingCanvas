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
	 * create an empty drawing with an initial default color
	 * 
	 * @param dColor the current default color
	 */
	public Drawing(Color dColor) {
		defaultColor = dColor;
		allShape = new ArrayList<Shape>();
	}
	
	/**
	 * have each shape in the drawing draw itself
	 * 
	 * @param page the Graphics object to draw on
	 */
	public void draw(Graphics page) {
		for (Shape theShape: allShape) {
			theShape.drawShape(page);
		}
	}
	
	/**
	 * find the frontmost Shape in the drawing that contains a certain point
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
	 * add a new shape to the drawing
	 * @param newShape the added shape
	 */
	public void addShape(Shape newShape) {
		allShape.add(newShape);
	}
	
	/**
	 * 
	 * @return
	 */
	public Color getColor() {
		return defaultColor;
	}
	

}
