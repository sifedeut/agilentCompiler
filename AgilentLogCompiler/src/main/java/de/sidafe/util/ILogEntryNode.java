package de.sidafe.util;

import java.util.ArrayList;

/**
 * The implementation of this <code>Interface</code> can be used to build up an
 * in memory tree of the agilent log file.<br/>
 * An <code>ILogEntryNode</code> consists of an <code>ILogEntry</code>
 * implementation and a possible sublist of <code>ILogEntryNode</code>s.
 * 
 * @author Felix
 * @author Daniel
 * @version 1.0
 * @see ILogEntry
 */
public interface ILogEntryNode {
	/**
	 * A setter <code>method</code> for the <code>ILogEntry</code>
	 * 
	 * @param logEntry
	 *            the <code>ILogEntry</code> to be set
	 * @return true if the <code>ILogEntry</code> was set successfully
	 */
	public boolean setLogEntry(ILogEntry logEntry);

	/**
	 * This <code>method</code> is supposed to be used as follows:<br/>
	 * <p>
	 * 
	 * <pre>
	 * {@code
	 * ILogEntryNode len new LogEntryNodeImpl();
	 * len.setLogEntry(aLogEntry);
	 * len.addChildEntries("{@A-JUM|0|-7.630803E+06{@LIM2|+9.999999E+99|+1.000000E+04}}");
	 * }
	 * </pre>
	 * 
	 * </p>
	 * This should add a child node with the <code>ILogEntry</code> set to
	 * <code>AJum<code> with a further child <code>LIM2</code>.
	 * 
	 * @param logEntrySubString
	 * @return true, if successfully added the child nodes
	 */
	public boolean addChildEntries(String logEntrySubString);
	/**
	 * This <code>method</code> should return all headings of the child nodes
	 * beginning with the <code>ILogEntry</code> of the
	 * <code>ILogEntryNode</code> where this <code>method</code> is initially
	 * called.
	 * 
	 * @return the node headings with all child headings
	 */
	public ArrayList<String> getHeadings();
	/**
	 * This <code>method</code> should return all values in the same order of the headings.
	 * @return the values of the <code>ILogEntryNode</code> an all its children
	 * @see ILogEntryNode#getHeadings()
	 */
	public ArrayList<String> getValues();
	/**
	 * Returns the <code>ILogEntry</code> of the <code>ILogEntryNode</code>.
	 * @return the <code>ILogEntry</code>
	 */
	public ILogEntry getLogEntry();
	/**
	 * Setter for the sub nodes of an <code>ILogEntryNode</code>.
	 * @param subNodes the sub nodes to be set
	 */
	public void setSubNodes(ArrayList<ILogEntryNode> subNodes);
	/**
	 * Getter for the sub nodes of an <code>ILogEntryNode</code>.
	 * @return the sub nodes
	 */
	public ArrayList<ILogEntryNode> getSubNodes();
}