import java.util.Stack;

/**
 * EditHistory.java
 * Handles edit history and undo function.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 */
public class EditHistory {

	private Stack<Command> historyList; // a stack of command
	private final int limit = 1; // the number of operations that can be undo
	private int current; // the number of times the undo operation is used
	
	/**
	 * Create a new edit history
	 */
	public EditHistory() {
		historyList = new Stack<Command>();
		current = 0;
	}
	
	/**
	 * Add a new command object to edit history
	 * 
	 * @param cmd the command to be added
	 */
	public void add(Command cmd) {
		historyList.push(cmd);
		current = 0;
	}
	
	/**
	 * Undo the last operation
	 */
	public void undo() {
		if (!historyList.empty() && current < limit) {
			Command cmd = historyList.pop();
			if (cmd instanceof UndoableCommand) {
				((UndoableCommand) cmd).undo();
				current ++;
			}
		}

	}

}
