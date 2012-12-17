package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class TS implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public TS() {
		this.headings = new ArrayList<String>(4);
		this.headings.add("TS_test_status");
		this.headings.add("TS_shorts_count");
		this.headings.add("TS_opens_count");
		this.headings.add("TS_phantoms_count");
		
		this.values = new ArrayList<String>(4);
		for (int i=0; i<4; i++) {
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