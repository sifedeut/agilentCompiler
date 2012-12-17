package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class MCL implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public MCL() {
		this.headings = new ArrayList<String>(2);		
		this.headings.add("MCL_status");
		this.headings.add("MCL_cluster_name");
		
		this.values = new ArrayList<String>(2);
		for (int i=0; i<2; i++) {
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