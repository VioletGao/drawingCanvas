import java.awt.Point;

/**
 * DeleteCmd.java
 * Command class to perform a delete command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class DeleteCmd extends UndoableCommand{	
	private Shape s; // the shape to be deleted
	private Drawing thisDwg;
	private int index; // index of the shape before it is deleted
	
	/**
	 * When the mouse is clicked, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then the
	 * shape is removed from the drawing
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) { 
		thisDwg = dwg;
		s = dwg.getFrontmostContainer(p);
		index = dwg.getIndex(s);
		dwg.removeShape(s);
	}
	
	/**
	 * Undo the delete operation
	 */
	public void undo() {
		if (s != null) {
			thisDwg.moveToIndex(index, s);
		}
	}
}
