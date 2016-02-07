/**
 * Editor.java
 * An applet for an object-oriented graphical editor.
 * This class implements the GUI for the editor.
 * 
 * This is a provided file with parts to be filled in.
 *
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Editor extends JApplet {
  private static final long serialVersionUID = 1L;
  
  private final int APPLET_WIDTH = 900, APPLET_HEIGHT = 600;
  private final Color initialColor = Color.red; // default color starts as red

  private Command cmd; // the command being executed
  private Drawing dwg; // the drawing: shapes in order
  private ColorIndicator colorBox; // a GUI component to show the current default color
  private TextField spacing; // the grid spacing user wish to display
  private CanvasPanel canvasPanel;
  
  private EditHistory history;
  
  /**
   * Set up the buttons and canvas and register the listeners.
   */
  public void init() {
    cmd = new Command(); // all methods in Command are empty
    dwg = new Drawing(initialColor); // make an empty drawing

    // The drawing will appear in a white CanvasPanel.
    canvasPanel = new CanvasPanel();
    canvasPanel.setBackground(Color.white);

    // Make JButton objects for all the command buttons.
    JButton rectButton = new JButton("Rectangle");
    JButton ellipseButton = new JButton("Ellipse");
    JButton lineButton = new JButton("Line");
    JButton moveButton = new JButton("Move");
    JButton deleteButton = new JButton("Delete");
    JButton frontButton = new JButton("Front");
    JButton backButton = new JButton("Back");
    JButton exchangeButton = new JButton("Exchange");
    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");
    JButton yellowButton = new JButton("Yellow");
    JButton magentaButton = new JButton("Magenta");
    JButton copyButton = new JButton("Copy");
    JButton reshapeButton = new JButton("Reshape");
    JButton gridButton = new JButton("Grid");
    JButton snapButton = new JButton("Snap");
    JButton undoButton = new JButton("Undo");
    JButton redoButton = new JButton("Redo");
    JButton clearButton = new JButton("Clear");
    
    // Add listeners for all the command buttons.
    rectButton.addActionListener(new RectButtonListener());
    ellipseButton.addActionListener(new EllipseButtonListener());
    lineButton.addActionListener(new LineButtonListener());
    moveButton.addActionListener(new MoveButtonListener());
    deleteButton.addActionListener(new DeleteButtonListener());
    frontButton.addActionListener(new FrontButtonListener());
    backButton.addActionListener(new BackButtonListener());
    exchangeButton.addActionListener(new ExchangeButtonListener());
    redButton.addActionListener(new RedButtonListener());
    greenButton.addActionListener(new GreenButtonListener());
    blueButton.addActionListener(new BlueButtonListener());
    yellowButton.addActionListener(new YellowButtonListener());
    magentaButton.addActionListener(new MagentaButtonListener());
    copyButton.addActionListener(new CopyButtonListener());
    reshapeButton.addActionListener(new ReshapeButtonListener());
    gridButton.addActionListener(new GridButtonListener());
    snapButton.addActionListener(new SnapButtonListener());
    undoButton.addActionListener(new UndoButtonListener());
    redoButton.addActionListener(new RedoButtonListener());
    clearButton.addActionListener(new ClearButtonListener());

    // The command buttons will be arranged in 3 rows.  Each row will
    // appear in its own JPanel, and the 3 JPanels will be stacked
    // vertically.
    JPanel shapePanel = new JPanel(); // holds buttons for adding shapes
    JLabel shapeLabel = new JLabel("Add shape:");
    shapePanel.setLayout(new FlowLayout());
    shapePanel.add(shapeLabel);
    rectButton.setBackground(Color.yellow);
    ellipseButton.setBackground(Color.yellow);
    lineButton.setBackground(Color.yellow);
    shapePanel.add(rectButton);
    shapePanel.add(ellipseButton);
    shapePanel.add(lineButton);

    JPanel editPanel = new JPanel(); // holds buttons for editing operations
    JLabel editLabel = new JLabel("Edit:");
    editPanel.setLayout(new FlowLayout());
    editPanel.add(editLabel);
    moveButton.setBackground(Color.yellow);
    deleteButton.setBackground(Color.yellow);
    frontButton.setBackground(Color.yellow);
    backButton.setBackground(Color.yellow);
    exchangeButton.setBackground(Color.yellow);
    copyButton.setBackground(Color.yellow);
    reshapeButton.setBackground(Color.yellow);
    undoButton.setBackground(Color.yellow);
    redoButton.setBackground(Color.yellow);
    clearButton.setBackground(Color.yellow);
    editPanel.add(moveButton);
    editPanel.add(deleteButton);
    editPanel.add(frontButton);
    editPanel.add(backButton);
    editPanel.add(exchangeButton);
    editPanel.add(copyButton);
    editPanel.add(reshapeButton);
    editPanel.add(undoButton);
    editPanel.add(redoButton);
    editPanel.add(clearButton);

    // The color panel is slightly different from the other two. In
    // addition to a label and buttons for the color commands, this
    // panel holds a ColorIndicator that gives the current default
    // color.
    JPanel colorPanel = new JPanel();
    JLabel colorLabel = new JLabel("Colors:");
    colorPanel.setLayout(new FlowLayout());
    colorPanel.add(colorLabel);
    colorBox = new ColorIndicator();
    colorBox.show(initialColor);
    redButton.setBackground(Color.yellow);
    greenButton.setBackground(Color.yellow);
    blueButton.setBackground(Color.yellow);
    yellowButton.setBackground(Color.yellow);
    magentaButton.setBackground(Color.yellow);
    colorPanel.add(colorBox);
    colorPanel.add(redButton);
    colorPanel.add(greenButton);
    colorPanel.add(blueButton);
    colorPanel.add(yellowButton);
    colorPanel.add(magentaButton);

    // The grid pandel allows the user to toggle whether an evenly-
    // spaced grid is displayed
    JPanel gridPanel = new JPanel();
    JLabel gridLabel = new JLabel("Gridding & Snapping:");
    gridPanel.setLayout(new FlowLayout());
    gridPanel.add(gridLabel);
    gridButton.setBackground(Color.yellow);
    snapButton.setBackground(Color.yellow);
    gridPanel.add(gridButton);
    JLabel gridSpace = new JLabel("Spacing:");
    spacing = new TextField(3);
    gridPanel.add(gridSpace);
    gridPanel.add(spacing);
    spacing.disable();
    gridPanel.add(snapButton);
    
    // Use a grid layout to stack the button panels vertically.  Also,
    // give them a cyan background.
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4, 1));
    shapePanel.setBackground(Color.cyan);
    editPanel.setBackground(Color.cyan);
    colorPanel.setBackground(Color.cyan);
    gridPanel.setBackground(Color.cyan);
    buttonPanel.add(shapePanel);
    buttonPanel.add(editPanel);
    buttonPanel.add(colorPanel);
    buttonPanel.add(gridPanel);

    // Now we have two panels: buttonPanel and canvasPanel.  We want
    // buttonPanel to appear above canvasPanel, and canvasPanel should
    // grow with the applet.
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(buttonPanel, BorderLayout.NORTH);
    cp.add(canvasPanel, BorderLayout.CENTER);

    setSize(APPLET_WIDTH, APPLET_HEIGHT);
    
    //
    history = new EditHistory();
    history.add(dwg);
  }

  /**
   * What to do when rectButton is pressed.
   */
  private class RectButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      //history.clear();
      cmd = new RectCmd();
     // history.add(dwg);
      repaint();
    }
  }

  /**
   * What to do when ellipseButton is pressed.
   */
  private class EllipseButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new EllipseCmd();
      //history.add(dwg);
      repaint();
    }
  }

  /**
   * What to do when lineButton is pressed.
   */
  private class LineButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new SegmentCmd();
      repaint();
    }
  }

  /**
   * What to do when moveButton is pressed.
   */
  private class MoveButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new MoveCmd();
      repaint();
    }
  }

  /**
   * What to do when deleteButton is pressed.
   */
  private class DeleteButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new DeleteCmd();
      repaint();
    }
  }

  /**
   * What to do when frontButton is pressed.
   */
  private class FrontButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new FrontCmd();
      repaint();
    }
  }

  /**
   * What to do when backButton is pressed.
   */
  private class BackButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new BackCmd();
      repaint();
    }
  }

  /**
   * What to do when exchangeButton is pressed.
   */
  private class ExchangeButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new ExchangeCmd();
      repaint();
    }
  }

  /**
   * What to do when redButton is pressed.
   */
  private class RedButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new ColorCmd();
      colorBox.show(Color.red);
      dwg.setColor(Color.red);
      repaint();
    }
  }

  /**
   * What to do when greenButton is pressed.
   */
  private class GreenButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new ColorCmd();
      colorBox.show(Color.green);
      dwg.setColor(Color.green);
      repaint();
    }
  }

  /**
   * What to do when blueButton is pressed.
   */
  private class BlueButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new ColorCmd();
      colorBox.show(Color.blue);
      dwg.setColor(Color.blue);
      repaint();
    }
  }

  /**
   * What to do when yellowButton is pressed.
   */
  private class YellowButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new ColorCmd();
      colorBox.show(Color.yellow);
      dwg.setColor(Color.yellow);
      repaint();
    }
  }
  
  /**
   * What to do when magentaButton is pressed.
   */
  private class MagentaButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new ColorCmd();
      colorBox.show(Color.magenta);
      dwg.setColor(Color.magenta);
      repaint();
    }
  }
  
  /**
   * What to do when copyButton is pressed.
   */
  private class CopyButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new CopyCmd();	
      repaint();
    }
  }
  
  /**
   * What to do when reshapeButton is pressed.
   */
  private class ReshapeButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      cmd = new ReshapeCmd();
      repaint();
    }
  }
  
  /**
   * What to do when gridButton is pressed.
   */
  private class GridButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	spacing.enable();
      /*String gridSpacing; 
      gridSpacing = spacing.getText();
      int space = Integer.parseInt(gridSpacing);
      if (space >= 0) {
    	  canvasPanel.paint(getGraphics());;
      }*/
      repaint();
    }
    

  }
   
  /**
   * What to do when snapButton is pressed.
   */
  private class SnapButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
 
      repaint();
    }
  }
  
  /**
   * What to do when undoButton is pressed.
   */
  private class UndoButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      dwg = history.undo();
      repaint();
    }
  }
  
  /**
   * What to do when redoButton is pressed.
   */
  private class RedoButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      dwg = history.redo();
      repaint();
    }
  }
  
  /**
   * What to do when clearButton is pressed.
   */
  private class ClearButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	  dwg = new Drawing(initialColor);
	  colorBox.show(initialColor);
	  repaint();
	} 
  }
  
  /**
   * A ColorIndicator shows what the current color is.
   */
  private class ColorIndicator extends JPanel {
    private static final long serialVersionUID = 0;
    
    private final int COLORBOX_WIDTH = 20, COLORBOX_HEIGHT = 20;

    /**
     * Constructor sets the size and border.
     */
    public ColorIndicator() {
      setBorder(BorderFactory.createEtchedBorder());
      setPreferredSize(new Dimension(COLORBOX_WIDTH, COLORBOX_HEIGHT));
    }

    /**
     * Show a new color.
     * @param color the color to show
     */
    public void show(Color color) {
      setBackground(color);
    }
  }

  /** 
   * CanvasPanel is the class upon which we actually draw.  It listens
   * for mouse events and calls the appropriate method of the current
   * command.
   */ 
  private class CanvasPanel extends JPanel implements MouseListener,
      MouseMotionListener {
    private static final long serialVersionUID = 0;
    
    /**
     * Constructor just needs to set up the CanvasPanel as a listener.
     */
    public CanvasPanel() {
      addMouseListener(this);
      addMouseMotionListener(this);
    }

    /**
     * Paint the whole drawing
     * @page the Graphics object to draw on
     */
    public void paintComponent(Graphics page) {
      super.paintComponent(page); // execute the paint method of JPanel
      dwg.draw(page); // have the drawing draw itself
      page.drawLine(0, 50, APPLET_WIDTH, 50);
    }
    
    /**
     * When the mouse is clicked, call the executeClick method of the
     * current command.
     */
    public void mouseClicked(MouseEvent event) {
      cmd.executeClick(event.getPoint(), dwg);
      repaint();
    }

    /**
     * When the mouse is pressed, call the executePress method of the
     * current command.
     */
    public void mousePressed(MouseEvent event) {
      cmd.executePress(event.getPoint(), dwg);
      repaint();
    }

    /** 
     * When the mouse is dragged, call the executeDrag method of the
     * current command.
     */
    public void mouseDragged(MouseEvent event) {
      cmd.executeDrag(event.getPoint(), dwg);
      repaint();
    }

    // We don't care about the other mouse events.
    public void mouseReleased(MouseEvent event) { }  
    public void mouseEntered(MouseEvent event) { }
    public void mouseExited(MouseEvent event) { }
    public void mouseMoved(MouseEvent event) { }
  }
}
