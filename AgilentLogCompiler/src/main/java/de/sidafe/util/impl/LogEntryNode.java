package de.sidafe.util.impl;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;
import de.sidafe.util.ILogEntryNode;

public class LogEntryNode implements ILogEntryNode {
	private ILogEntry logEntry;
	private ArrayList<ILogEntryNode> subNodes = new ArrayList<ILogEntryNode>();

	public boolean setLogEntry(ILogEntry logEntry) {
		this.logEntry = logEntry;
		return (this.logEntry.equals(logEntry));
	}
	
	/**
	 * this method can be used for unit testing
	 * @return the logEntry to get 
	 */
	public ILogEntry getLogEntry() {
		return this.logEntry;
	}

	public boolean addChildEntries(String logEntrySubString) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<String> getHeadings() {
		ArrayList<String> tempHeadings = new ArrayList<String>();
		if (!this.subNodes.isEmpty()) {
			for (ILogEntryNode len : this.subNodes) {
				tempHeadings.addAll(len.getHeadings());
			}
		} else {
			tempHeadings.addAll(this.logEntry.getHeadings());
		}
		
		return tempHeadings;
	}

	public ArrayList<String> getValues() {
		ArrayList<String> tempValues = new ArrayList<String>();
		if (!this.subNodes.isEmpty()) {
			for (ILogEntryNode len : this.subNodes) {
				tempValues.addAll(len.getHeadings());
			}
		} else {
			tempValues.addAll(this.logEntry.getHeadings());
		}
		
		return tempValues;
	}

	/**
	 * This method can be used for unit testing
	 * @return the subNodes
	 */
	public ArrayList<ILogEntryNode> getSubNodes() {
		return subNodes;
	}

	/**
	 * this method can be used for unit testing
	 * @param subNodes the subNodes to set
	 */
	public void setSubNodes(ArrayList<ILogEntryNode> subNodes) {
		this.subNodes = subNodes;
	}
}