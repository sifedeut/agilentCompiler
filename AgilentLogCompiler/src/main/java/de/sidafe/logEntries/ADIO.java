package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class ADIO implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public ADIO() {
		this.headings = new ArrayList<String>(2);
		
		this.headings.add("ADIO_test_status");
		this.headings.add("ADIO_measured_value");
		
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