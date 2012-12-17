package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class AMEA implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public AMEA() {
		this.headings = new ArrayList<String>(3);
		
		this.headings.add("AMEA_test_status");
		this.headings.add("AMEA_measured_value");
		this.headings.add("AMEA_subtest_designator");
		
		this.values = new ArrayList<String>(3);
		this.values.add("");
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