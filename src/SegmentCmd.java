import java.awt.Point;

/**
 * SegmentCmd.java
 * Command class to perform drawing a line command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class SegmentCmd extends Command{
	private Segment newLine;
	
	/**
	 * When the mouse is pressed, a new line is added into the drawing
	 * 
	 * @param p the coordinates of the place which is pressed
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		 newLine = new Segment(dwg.getColor());
		 
		 newLine.setStartPoint(p);
		 dwg.addShape(newLine);
	}

	/**
	 * When the mouse is dragged, the new position of mouse is recorded continuously
	 * 
	 * @param p the coordinates of the place where mouse last locate
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		newLine.updatePos(p);
	}
}
