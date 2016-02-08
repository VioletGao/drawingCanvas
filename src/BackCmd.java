import java.awt.Point;

/**
 * BackCmd.java
 * Command class to perform a back command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class BackCmd extends UndoableCommand{
	private Shape movedShape; // the shape to be moved back
	private int index; // index of the shape before it is moved
	private Drawing thisDwg; 
	
	/**
	 * When the mouse is clicked, find the frontmost Shape that is under 
	 * the mouse position at the time of the click, move it to the back 
	 * of the linear ordering of objects in the drawing
	 */
	public void executeClick(Point p, Drawing dwg) {
		thisDwg = dwg;
		movedShape = dwg.getFrontmostContainer(p);
		index = dwg.getIndex(movedShape);
		
		if (movedShape != null) { 
			dwg.moveBack(movedShape);
		}
	}

	/**
	 * Undo the last move to back operation
	 */
	public void undo() {
		if (movedShape != null) {
			thisDwg.moveToIndex(index,movedShape);
		}
	}
	
}
