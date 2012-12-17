package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class BSO implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public BSO() {
		this.headings = new ArrayList<String>(4);
		this.headings.add("BSO_first_device_name");
		this.headings.add("BSO_first_device_pin");
		this.headings.add("BSO_second_device_name");
		this.headings.add("BSO_second_device_pin");
		
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