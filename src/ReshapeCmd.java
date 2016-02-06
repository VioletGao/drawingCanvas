import java.awt.Point;

/**
 * ReshapeCmd.java
 * Command class to perform a reshape command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class ReshapeCmd extends Command {

	Shape s;
	
	/**
	 * When the mouse is pressed, identify if a 
	 */
	public void executePress(Point p, Drawing dwg) {
		s = dwg.getFrontmostContainer(p);
	}
	
	public void executeDrag(Point p, Drawing dwg) { 
		if (s != null) {
			s.reshape(p);
		}
	}
}
