import java.awt.Point;

/**
 * ColorCmd.java
 * Command class to perform a color command.
 * 
 * @author Yuan Gao
 * @see Command
 */
public class ColorCmd extends Command {

	private Shape frontmostShape;
	
	/**
	 * When the mouse is clicked
	 * 
	 * @param
	 * @param
	 */
	public void executeClick(Point p, Drawing dwg) { 	
		frontmostShape = dwg.getFrontmostContainer(p);
		if (frontmostShape != null) {
			frontmostShape.setColor(dwg.getColor());
		}
	}
}
