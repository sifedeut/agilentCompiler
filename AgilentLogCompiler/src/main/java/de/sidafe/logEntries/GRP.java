package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class GRP implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public GRP() {
		this.headings = new ArrayList<String>(1);
		this.headings.add("GRP_relationship");
		
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