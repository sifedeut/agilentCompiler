package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class BTEST implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public BTEST() {
		this.headings = new ArrayList<String>(13);
		this.headings.add("BTEST_board_id");
		this.headings.add("BTEST_test_status");
		this.headings.add("BTEST_start_datetime");
		this.headings.add("BTEST_duration");
		this.headings.add("BTEST_multiple_test");
		this.headings.add("BTEST_log_level");
		this.headings.add("BTEST_log_set");
		this.headings.add("BTEST_learning");
		this.headings.add("BTEST_known_good");
		this.headings.add("BTEST_end_datetime");
		this.headings.add("BTEST_status_qualifier");
		this.headings.add("BTEST_board_number");
		this.headings.add("BTEST_parent_panel_id");
		
		this.values = new ArrayList<String>(13);
		for (int i=0; i<13; i++) {
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