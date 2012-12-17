package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;
// TODO theoretisch mehrere BS-O Records als Subrecord möglich - bei Ausgabe einfach alle BS-O Records hintereinander in eine Spalte?
// {BS-O|1|2|3|4}{BS-O|....}{...}
public class BSCON implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public BSCON() {
		this.headings = new ArrayList<String>(4);
		this.headings.add("BSCON_test_designator");
		this.headings.add("BSCON_status");
		this.headings.add("BSCON_shorts_count");
		this.headings.add("BSCON_opens_count");
		
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