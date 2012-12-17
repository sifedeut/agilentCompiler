package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class TJET implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public TJET() {
		this.headings = new ArrayList<String>(3);
		this.headings.add("TJET_test_status");
		this.headings.add("TJET_pin_count");
		this.headings.add("TJET_test_designator");
		
		this.values = new ArrayList<String>(3);
		for (int i=0; i<3; i++) {
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