import java.awt.Point;

/**
 * RectangleCmd.java
 * Command class to perform an adding rectangle command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class RectCmd extends UndoableCommand {	
	private Rect s; // new rectangle to be added in drawing
	private Point pressedPoint;	// where the mouse was pressed
	private Drawing thisdwg;
	
	/**
	 * When the mouse is pressed, a new rectangle is added to the drawing
	 * on the location of the mouse
	 * 
	 * @param p the coordinates of the place which is pressed
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		 thisdwg = dwg;
		 s = new Rect(dwg.getColor());
		 pressedPoint = p;
		 dwg.addShape(s);	
		 s.setX(p.x);
		 s.setY(p.y);
		 s.setWidth(0);
		 s.setHeight(0);
	}

	/**
	 * When the mouse is dragged, the shape of the Rectangle changes
	 * according to the location of the mouse
	 * 
	 * @param p the current position of the mouse
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		 s.setX(Math.min(p.x, pressedPoint.x));
		 s.setY(Math.min(p.y, pressedPoint.y));
		 s.setWidth(Math.abs(p.x - pressedPoint.x));
		 s.setHeight(Math.abs(p.y - pressedPoint.y));
	}

	/**
	 * Undo the add rectangle operation
	 */
	public void undo() {
		thisdwg.removeShape(s);
	}
}
