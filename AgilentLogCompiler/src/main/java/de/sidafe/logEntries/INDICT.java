package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class INDICT implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public INDICT() {
		this.headings = new ArrayList<String>(6);
		this.headings.add("INDICT_technique");
		this.headings.add("INDICT_device_list");
		this.headings.add("INDICT_est_resistance");
		this.headings.add("INDICT_est_capacitance");
		this.headings.add("INDICT_est_induct");
		this.headings.add("INDICT_est_model");
		
		this.values = new ArrayList<String>(6);
		for (int i=0; i<6; i++) {
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