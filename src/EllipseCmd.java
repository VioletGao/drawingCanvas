import java.awt.Point;

/**
 * EllipseCmd.java
 * Command class to perform an adding Ellipse command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class EllipseCmd extends UndoableCommand{
	private Ellipse s;
	private Point pressedPoint;
	private Drawing preDwg;
	
	/**
	 * When the mouse is pressed, a new Ellipse is added into the drawing
	 * 
	 * @param p the coordinates of the place which is pressed
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		 preDwg = dwg;
		 s = new Ellipse(dwg.getColor());
		 pressedPoint = p;
		 dwg.addShape(s);	
		 s.setX(p.x);
		 s.setY(p.y);
		 s.setWidth(0);
		 s.setHeight(0);
	}
	
	/**
	 * When the mouse is dragged, the shape of the Ellipse changes
	 * according to the location of the mouse
	 * 
	 * @param p the coordinates of the place where mouse last locate
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		 s.setX(Math.min(p.x, pressedPoint.x));
		 s.setY(Math.min(p.y, pressedPoint.y));
		 s.setWidth(Math.abs(p.x - pressedPoint.x));
		 s.setHeight(Math.abs(p.y - pressedPoint.y));
	}
	
	/**
	 * Undo the add Ellipse operation
	 */
	public void undo() {
		preDwg.removeShape(s);
	}
}
