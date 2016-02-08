import java.awt.Point;

/**
 * SegmentCmd.java
 * Command class to perform drawing a line command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class SegmentCmd extends UndoableCommand{
	private Segment newLine;
	private Drawing preDwg;
	
	/**
	 * When the mouse is pressed, a new line is added into the drawing
	 * 
	 * @param p the coordinates of the place which is pressed
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		 preDwg = dwg;
		 newLine = new Segment(dwg.getColor());
		 newLine.setX1(p.x);
		 newLine.setY1(p.y);
		 newLine.setX2(p.x);
		 newLine.setY2(p.y);
		 
		 dwg.addShape(newLine);
	}

	/**
	 * When the mouse is dragged, the shape of the Segment changes
	 * according to the location of the mouse
	 * 
	 * @param p the coordinates of the place where mouse last locate
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		newLine.setX2(p.x);
		newLine.setY2(p.y);
	}
	
	/**
	 * Undo the add segment operation
	 */
	public void undo() {
		preDwg.removeShape(newLine);
	}
}
