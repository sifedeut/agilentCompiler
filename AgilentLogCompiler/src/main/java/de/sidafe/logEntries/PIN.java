package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class PIN implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public PIN() {
		this.headings = new ArrayList<String>(1);
		this.headings.add("PIN_pin_list");
		
		this.values = new ArrayList<String>(1);
		for (int i=0; i<1; i++) {
			this.values.add("");
		}
	}
	
	public void setLogEntryValues(ArrayList<String> logEntryValues) {
		for (int i=0; i<this.headings.size(); i++) {
			this.values.set(i, logEntryValues.get(i));
		}
	}

	public ArrayList<String> getHeadings() {
		return this.headings;
	}

	public ArrayList<String> getValues() {
		return this.values;
	}
}