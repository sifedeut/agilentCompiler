package de.sidafe.logEntries;

import java.util.ArrayList;
import de.sidafe.util.ILogEntry;

public class BATCH implements ILogEntry {
	private ArrayList<String> headings;
	private ArrayList<String> values;
	
	public BATCH() {
		this.headings = new ArrayList<String>(14);
		this.headings.add("BATCH_UUT_type");
		this.headings.add("BATCH_UUT_type_rev");
		this.headings.add("BATCH_fixture_id");
		this.headings.add("BATCH_testhead_number");
		this.headings.add("BATCH_testhead_type");
		this.headings.add("BATCH_process_step");
		this.headings.add("BATCH_batch_id");
		this.headings.add("BATCH_operator_id");
		this.headings.add("BATCH_controller");
		this.headings.add("BATCH_testplan_id");
		this.headings.add("BATCH_testplan_rev");
		this.headings.add("BATCH_parent_panel_type");
		this.headings.add("BATCH_parent_panel_type_rev");
		this.headings.add("BATCH_version_label");
		
		this.values = new ArrayList<String>(14);
		for (int i=0; i<14; i++) {
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