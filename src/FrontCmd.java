import java.awt.Point;

/**
 * FrontCmd.java
 * Command class to perform a front command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class FrontCmd extends UndoableCommand {
	private Shape s; // the shape to be moved
	private Drawing thisDwg;
	private int index; // index of the shape before it is moved
	
	/**
	 * When the mouse is clicked, find the frontmost object that is 
	 * under the mouse position at the time of the click, move it to 
	 * the front of the linear ordering of objects in the drawing
	 */
	public void executeClick(Point p, Drawing dwg) {
		thisDwg = dwg;
		s = dwg.getFrontmostContainer(p);
		index = dwg.getIndex(s);
		
		if (s != null) {
			dwg.moveFront(s);
		}
	}
	
	/**
	 * Undo the move front operation
	 */
	public void undo() {
		if (s != null) {
			thisDwg.moveToIndex(index, s);
		}
	}
}
 