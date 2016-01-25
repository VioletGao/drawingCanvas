import java.awt.Point;

/**
 * SegmentCmd.java
 * Command class to perform drawing a line command.
 * 
 * @author Yuan Gao
 * @see Command
 */
public class SegmentCmd extends Command{
	private Segment newLine;
	
	/**
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executePress(Point p, Drawing dwg) {
		 newLine = new Segment(dwg.getColor());
		 newLine.getStartPoint(p);
		 dwg.addShape(newLine);
	}

	/**
	 * When the mouse is dragged, the new position of mouse is recorded continuously
	 * @param p
	 * @param dwg
	 */
	public void executeDrag(Point p, Drawing dwg) {
		newLine.updatePos(p);
	}
}
