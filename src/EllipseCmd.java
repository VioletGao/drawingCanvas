import java.awt.Point;

public class EllipseCmd extends Command{
	
	private Ellipse newEllipse;
	
	/**
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executePress(Point p, Drawing dwg) {
		 newEllipse = new Ellipse(dwg.getColor());
		 newEllipse.getStartPoint(p);
		 dwg.addShape(newEllipse);
	}

	/**
	 * When the mouse is dragged, the new position of mouse is recorded continuously
	 * @param p
	 * @param dwg
	 */
	public void executeDrag(Point p, Drawing dwg) {
		newEllipse.updatePos(p);
	}
}
