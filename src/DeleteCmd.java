import java.awt.Point;

/**
 * DeleteCmd.java
 * Command class to perform a delete command.
 * 
 * @author Yuan Gao
 * @see Command
 */
public class DeleteCmd extends Command{
	
	private Shape deletedShape; // the shape being deleted
	
	/**
	 * When the mouse is clicked, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then that
	 * shape is removed from the drawing
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) { 
		deletedShape = dwg.getFrontmostContainer(p);
		dwg.removeShape(deletedShape);
	}
}