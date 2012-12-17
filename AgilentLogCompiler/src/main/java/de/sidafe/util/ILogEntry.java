package de.sidafe.util;

import java.util.ArrayList;

/**
 * This <code>Interface</code> represents a log entry of an agilent log file. It
 * can be used for creating the tree structure of a log file.<br/>
 * An <code>ILogEntry</code> is always part of an <code>ILogEntryNode</code>.
 * 
 * @author Felix
 * @author Daniel
 * @version 1.0
 * @see ILogEntryNode
 */
public interface ILogEntry {
	/**
	 * This <code>Method</code> sets the values of an <code>ILogEntry</code>.<br/>
	 * The value order inside of the given <code>ArrayList</code> has to be
	 * exactly the same to the heading <code>ArrayList</code>.
	 * 
	 * @param logEntryValues
	 *            the <code>ArrayList</code> of values to be set.
	 */
	public void setLogEntryValues(ArrayList<String> logEntryValues);

	/**
	 * Returns the headings of the <code>ILogEntry</code>.
	 * 
	 * @return the <code>ILogEntry</code> headings
	 */
	public ArrayList<String> getHeadings();

	/**
	 * Returns the values of the <code>ILogEntry</code> according to the order
	 * of the headings.
	 * 
	 * @return the <code>ILogEntry</code> values
	 */
	public ArrayList<String> getValues();
}
