import java.awt.Color;
import java.awt.Point;

/**
 * CopyCmd.java
 * Command class to perform a copy command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class CopyCmd extends Command {
	private Point lastPoint; // the point where the mouse last located
	private Shape s; // the shape to be copied
	//private Shape newShape; // the new shape
	
	/**
	 * When the mouse is pressed, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then 
	 * that shape is copied when the mouse drags.
	 * 
	 * @param p the coordinates of the press
     * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		s = dwg.getFrontmostContainer(p);
		lastPoint = p;
		if (s instanceof Rect) {
			Rect newShape = new Rect(s.getColor());
			newShape.setX(((Rect) s).getX());
			newShape.setY(((Rect) s).getY());
			newShape.setWidth(((Rect) s).getWidth());
			newShape.setHeight(((Rect) s).getHeight());
			dwg.addCopy(newShape,s);
		} else if (s instanceof Ellipse) {
			Ellipse newShape = new Ellipse(s.getColor());
			newShape.setX(((Ellipse) s).getX());
			newShape.setY(((Ellipse) s).getY());
			newShape.setWidth(((Ellipse) s).getWidth());
			newShape.setHeight(((Ellipse) s).getHeight());
			dwg.addCopy(newShape,s);
		} else if (s instanceof Segment) {
			Segment newShape = new Segment(s.getColor());
			newShape.setX1(((Segment) s).getX1());
			newShape.setY1(((Segment) s).getY1());
			newShape.setX2(((Segment) s).getX2());
			newShape.setY2(((Segment) s).getY2());
			dwg.addCopy(newShape,s);
		}
	}
	
	/**
	 * When the mouse is dragged, the new position of mouse is recorded continuously
	 * The copied shape is moving with the mouse. The original shape doesn't change. 
	 * 
	 * @param p the coordinates of the place where mouse last locate
     * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {

		int deltaX = p.x - lastPoint.x;
		int deltaY = p.y - lastPoint.y;
		
		s.move(deltaX, deltaY);

		lastPoint = p;
	}
}
