package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class DPIN implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public DPIN() {
		this.headings = new ArrayList<String>(3);
		this.headings.add("DPIN_device_name");
		this.headings.add("DPIN_node_pin_list");
		this.headings.add("DPIN_thru_devnode_list");
		
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
