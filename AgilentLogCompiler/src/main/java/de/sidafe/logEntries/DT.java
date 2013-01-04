package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class DT implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public DT() {
		this.headings = new ArrayList<String>(5);
		this.headings.add("DT_test_status");
		this.headings.add("DT_test_substatus");
		this.headings.add("DT_failing_vector_number");
		this.headings.add("DT_pin_count");
		this.headings.add("DT_test_designator");
		
		this.values = new ArrayList<String>(5);
		for (int i=0; i<5; i++) {
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
