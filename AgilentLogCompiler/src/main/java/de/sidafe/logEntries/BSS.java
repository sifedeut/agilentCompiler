package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;
//TODO theoretisch mehrere BS-S Records als Subrecord möglich - bei Ausgabe einfach alle BS-S Records hintereinander in eine Spalte?
//{BS-S|c}{BS-S|....}{...}
public class BSS implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public BSS() {
		this.headings = new ArrayList<String>(1);
		this.headings.add("BSS_cause");
		
		this.values = new ArrayList<String>(1);
		for (int i=0; i<1; i++) {
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