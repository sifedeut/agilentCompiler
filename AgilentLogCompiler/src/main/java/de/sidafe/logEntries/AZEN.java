package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class AZEN implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public AZEN() {
		this.headings = new ArrayList<String>(2);
		
		this.headings.add("AZEN_test_status");
		this.headings.add("AZEN_measured_value");
		
		this.values = new ArrayList<String>(2);
		this.values.add("");
		this.values.add("");
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