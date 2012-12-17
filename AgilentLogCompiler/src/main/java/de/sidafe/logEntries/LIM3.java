package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class LIM3 implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public LIM3() {
		this.headings = new ArrayList<String>(3);		
		this.headings.add("LIM3_nominal_value");
		this.headings.add("LIM3_high_limit");
		this.headings.add("LIM3_low_limit");
		
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