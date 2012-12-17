package de.sidafe.util.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import de.sidafe.logEntries.AJUM;
import de.sidafe.logEntries.AMEA;
import de.sidafe.logEntries.BATCH;
import de.sidafe.logEntries.BLOCK;
import de.sidafe.logEntries.BTEST;
import de.sidafe.logEntries.LIM2;
import de.sidafe.logEntries.PF;
import de.sidafe.util.ILogEntry;
import de.sidafe.util.ILogEntryNode;

public class LogEntryNodeTest {
	static LogEntryNode len;
	
	/*
	 * Setup for agilent log file
	 * {@BATCH|501-6338-02|50|12|1||btest|040107103921||solmb3t1|501-6338-02|RevA|||
	 * {@BTEST|5016338409302|00|040107105353|000350|0|all||n|n|040107105943||1
	 * {@BLOCK|polarity_check|00
	 * {@A-JUM|0|+3.478301E+00{@LIM2|+8.000000E+00|+0.000000E+00}}
	 * }
	 * {@PF|pins|0|0
	 * }
	 * {@BLOCK|swprobe1|00
	 * {@A-JUM|0|-7.630803E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
	 * }
	 * {@BLOCK|swprobe2|00
	 * {@A-JUM|0|+7.631804E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
	 * }
	 * {@BLOCK|swprobe3|00
	 * {@A-JUM|0|+7.630803E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
	 * }
	 * {@BLOCK|swprobe4|00
	 * {@A-JUM|0|+7.630803E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
	 * }
	 * {@BLOCK|swprobe5|00
	 * {@A-JUM|0|-7.630303E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
	 * }
	 * {@BLOCK|vr1|00
	 * {@A-MEA|0|+1.201013E+01|in{@LIM2|+1.320000E+01|+1.090910E+01}}
	 * {@A-MEA|0|+3.317988E+00|out{@LIM2|+3.630000E+00|+3.000000E+00}}
	 * }
	 * }}
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		len = new LogEntryNode();
		
		BATCH batch = new BATCH();
		//@BATCH|501-6338-02|50|12|1||btest|040107103921||solmb3t1|501-6338-02|RevA|||
		ArrayList<String> batchValues = new ArrayList<String>();
		batchValues.add("501-6338-02");
		batchValues.add("50");
		batchValues.add("12");
		batchValues.add("1");
		batchValues.add("");
		batchValues.add("btest");
		batchValues.add("040107103921");
		batchValues.add("");
		batchValues.add("solmb3t1");
		batchValues.add("501-6338-02");
		batchValues.add("RevA");
		batchValues.add("");
		batchValues.add("");
		batchValues.add("");		
		batch.setLogEntryValues(batchValues);
		
		len.setLogEntry(batch);
		
		BTEST btest = new BTEST();
		//@BTEST|5016338409302|00|040107105353|000350|0|all||n|n|040107105943||1
		ArrayList<String> btestValues = new ArrayList<String>();
		btestValues.add("5016338409302");
		btestValues.add("00");
		btestValues.add("040107105353");
		btestValues.add("000350");
		btestValues.add("0");
		btestValues.add("all");
		btestValues.add("");
		btestValues.add("n");
		btestValues.add("n");
		btestValues.add("040107105943");
		btestValues.add("");
		btestValues.add("1");
		btestValues.add("");
		btest.setLogEntryValues(btestValues);
		LogEntryNode btestNode = new LogEntryNode();
		btestNode.setLogEntry(btest);
		len.getSubNodes().add(btestNode);
		
		BLOCK block1 = new BLOCK();
		//@BLOCK|polarity_check|00
		ArrayList<String> block1Values = new ArrayList<String>();
		block1Values.add("polarity_check");
		block1Values.add("00");
		block1.setLogEntryValues(block1Values);
		LogEntryNode block1Node = new LogEntryNode();
		block1Node.setLogEntry(block1);
		btestNode.getSubNodes().add(block1Node);
		
		AJUM ajum1 = new AJUM();
		//@A-JUM|0|+3.478301E+00{@LIM2|+8.000000E+00|+0.000000E+00}}
		ArrayList<String> ajum1Values = new ArrayList<String>();
		ajum1Values.add("0");
		ajum1Values.add("+3.478301E+00");
		LIM2 lim2_1 = new LIM2();
		ArrayList<String> lim2_1Values = new ArrayList<String>();
		lim2_1Values.add("+8.000000E+00");
		lim2_1Values.add("+0.000000E+00");
		lim2_1.setLogEntryValues(lim2_1Values);
		ajum1.setLogEntryValues(ajum1Values);		
		LogEntryNode aj1Node = new LogEntryNode();
		LogEntryNode lim2_1Node = new LogEntryNode();
		lim2_1Node.setLogEntry(lim2_1);		
		aj1Node.setLogEntry(ajum1);
		aj1Node.getSubNodes().add(lim2_1Node);
		block1Node.getSubNodes().add(aj1Node);
		
		PF pf1 = new PF();
		//@PF|pins|0|0
		ArrayList<String> pf1Values = new ArrayList<String>();
		pf1Values.add("pins");
		pf1Values.add("0");
		pf1Values.add("0");
		pf1.setLogEntryValues(pf1Values);
		LogEntryNode pf1Node = new LogEntryNode();
		pf1Node.setLogEntry(pf1);
		block1Node.getSubNodes().add(pf1Node);
		
		
		BLOCK block2 = new BLOCK();
		//@BLOCK|swprobe1|00
		ArrayList<String> block2Values = new ArrayList<String>();
		block2Values.add("swprobe1");
		block2Values.add("00");
		block2.setLogEntryValues(block2Values);
		LogEntryNode block2Node = new LogEntryNode();
		block2Node.setLogEntry(block2);
		btestNode.getSubNodes().add(block2Node);
		
		AJUM ajum2 = new AJUM();
		//@A-JUM|0|-7.630803E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
		ArrayList<String> ajum2Values = new ArrayList<String>();
		ajum2Values.add("0");
		ajum2Values.add("-7.630803E+06");
		LIM2 lim2_2 = new LIM2();
		ArrayList<String> lim2_2Values = new ArrayList<String>();
		lim2_2Values.add("+9.999999E+99");
		lim2_2Values.add("+1.000000E+04");
		ajum2.setLogEntryValues(ajum2Values);
		lim2_2.setLogEntryValues(lim2_2Values);
		LogEntryNode aj2Node = new LogEntryNode();
		LogEntryNode lim2_2Node = new LogEntryNode();
		lim2_2Node.setLogEntry(lim2_2);		
		aj2Node.setLogEntry(ajum2);
		aj2Node.getSubNodes().add(lim2_2Node);
		block2Node.getSubNodes().add(aj2Node);
		
		BLOCK block3 = new BLOCK();
		//@BLOCK|swprobe2|00
		ArrayList<String> block3Values = new ArrayList<String>();
		block3Values.add("swprobe2");
		block3Values.add("00");
		block3.setLogEntryValues(block3Values);
		LogEntryNode block3Node = new LogEntryNode();
		block3Node.setLogEntry(block3);
		btestNode.getSubNodes().add(block3Node);
		
		AJUM ajum3 = new AJUM();
		//@A-JUM|0|+7.631804E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
		ArrayList<String> ajum3Values = new ArrayList<String>();
		ajum3Values.add("0");
		ajum3Values.add("+7.631804E+06");
		LIM2 lim2_3 = new LIM2();
		ArrayList<String> lim2_3Values = new ArrayList<String>();
		lim2_3Values.add("+9.999999E+99");
		lim2_3Values.add("+1.000000E+04");
		ajum3.setLogEntryValues(ajum3Values);
		lim2_3.setLogEntryValues(lim2_3Values);
		LogEntryNode aj3Node = new LogEntryNode();
		LogEntryNode lim2_3Node = new LogEntryNode();
		lim2_3Node.setLogEntry(lim2_3);		
		aj3Node.setLogEntry(ajum3);
		aj3Node.getSubNodes().add(lim2_3Node);
		block3Node.getSubNodes().add(aj3Node);
		
		BLOCK block4 = new BLOCK();
		//@BLOCK|swprobe3|00
		ArrayList<String> block4Values = new ArrayList<String>();
		block4Values.add("swprobe3");
		block4Values.add("00");
		block4.setLogEntryValues(block4Values);
		LogEntryNode block4Node = new LogEntryNode();
		block4Node.setLogEntry(block4);
		btestNode.getSubNodes().add(block4Node);
		
		AJUM ajum4 = new AJUM();
		//@A-JUM|0|+7.630803E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
		ArrayList<String> ajum4Values = new ArrayList<String>();
		ajum4Values.add("0");
		ajum4Values.add("+7.630803E+06");
		LIM2 lim2_4 = new LIM2();
		ArrayList<String> lim2_4Values = new ArrayList<String>();
		lim2_4Values.add("+9.999999E+99");
		lim2_4Values.add("+1.000000E+04");
		ajum4.setLogEntryValues(ajum4Values);
		lim2_4.setLogEntryValues(lim2_4Values);
		LogEntryNode aj4Node = new LogEntryNode();
		LogEntryNode lim2_4Node = new LogEntryNode();
		lim2_4Node.setLogEntry(lim2_4);		
		aj4Node.setLogEntry(ajum4);
		aj4Node.getSubNodes().add(lim2_4Node);
		block4Node.getSubNodes().add(aj4Node);
		
		BLOCK block5 = new BLOCK();
		//@BLOCK|swprobe4|00
		ArrayList<String> block5Values = new ArrayList<String>();
		block5Values.add("swprobe4");
		block5Values.add("00");
		block5.setLogEntryValues(block5Values);
		LogEntryNode block5Node = new LogEntryNode();
		block5Node.setLogEntry(block5);
		btestNode.getSubNodes().add(block5Node);
		
		AJUM ajum5 = new AJUM();
		//@A-JUM|0|+7.630803E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
		ArrayList<String> ajum5Values = new ArrayList<String>();
		ajum5Values.add("0");
		ajum5Values.add("+7.630803E+06");
		LIM2 lim2_5 = new LIM2();
		ArrayList<String> lim2_5Values = new ArrayList<String>();
		lim2_5Values.add("+9.999999E+99");
		lim2_5Values.add("+1.000000E+04");
		ajum5.setLogEntryValues(ajum5Values);
		lim2_5.setLogEntryValues(lim2_5Values);
		LogEntryNode aj5Node = new LogEntryNode();
		LogEntryNode lim2_5Node = new LogEntryNode();
		lim2_5Node.setLogEntry(lim2_5);		
		aj5Node.setLogEntry(ajum5);
		aj5Node.getSubNodes().add(lim2_5Node);
		block5Node.getSubNodes().add(aj5Node);
		
		BLOCK block6 = new BLOCK();
		//@BLOCK|swprobe5|00
		ArrayList<String> block6Values = new ArrayList<String>();
		block6Values.add("swprobe5");
		block6Values.add("00");
		block6.setLogEntryValues(block6Values);
		LogEntryNode block6Node = new LogEntryNode();
		block6Node.setLogEntry(block6);
		btestNode.getSubNodes().add(block6Node);
		
		AJUM ajum6 = new AJUM();
		//@A-JUM|0|-7.630303E+06{@LIM2|+9.999999E+99|+1.000000E+04}}
		ArrayList<String> ajum6Values = new ArrayList<String>();
		ajum6Values.add("0");
		ajum6Values.add("-7.630303E+06");
		LIM2 lim2_6= new LIM2();
		ArrayList<String> lim2_6Values = new ArrayList<String>();
		lim2_6Values.add("+9.999999E+99");
		lim2_6Values.add("+1.000000E+04");
		ajum6.setLogEntryValues(ajum6Values);
		lim2_6.setLogEntryValues(lim2_6Values);
		LogEntryNode aj6Node = new LogEntryNode();
		LogEntryNode lim2_6Node = new LogEntryNode();
		lim2_6Node.setLogEntry(lim2_6);		
		aj6Node.setLogEntry(ajum6);
		aj6Node.getSubNodes().add(lim2_6Node);
		block6Node.getSubNodes().add(aj6Node);
		
		BLOCK block7 = new BLOCK();
		//@BLOCK|vr1|00
		ArrayList<String> block7Values = new ArrayList<String>();
		block7Values.add("vr1");
		block7Values.add("00");
		block7.setLogEntryValues(block7Values);
		LogEntryNode block7Node = new LogEntryNode();
		block7Node.setLogEntry(block7);
		btestNode.getSubNodes().add(block7Node);
		
		AMEA amea1 = new AMEA();
		//@A-MEA|0|+1.201013E+01|in{@LIM2|+1.320000E+01|+1.090910E+01}}
		ArrayList<String> amea1Values = new ArrayList<String>();
		amea1Values.add("0");
		amea1Values.add("+1.201013E+01");
		amea1Values.add("in");
		LIM2 lim2_7= new LIM2();
		ArrayList<String> lim2_7Values = new ArrayList<String>();
		lim2_7Values.add("+1.320000E+01");
		lim2_7Values.add("+1.090910E+01");
		amea1.setLogEntryValues(amea1Values);		
		LogEntryNode am1Node = new LogEntryNode();
		LogEntryNode lim2_7Node = new LogEntryNode();
		lim2_7Node.setLogEntry(lim2_7);		
		am1Node.setLogEntry(amea1);
		am1Node.getSubNodes().add(lim2_7Node);
		block7Node.getSubNodes().add(am1Node);
		
		AMEA amea2 = new AMEA();
		//@A-MEA|0|+3.317988E+00|out{@LIM2|+3.630000E+00|+3.000000E+00}}
		ArrayList<String> amea2Values = new ArrayList<String>();
		amea2Values.add("0");
		amea2Values.add("+3.317988E+00");
		amea2Values.add("out");
		LIM2 lim2_8= new LIM2();
		ArrayList<String> lim2_8Values = new ArrayList<String>();
		lim2_8Values.add("+3.630000E+00");
		lim2_8Values.add("+3.000000E+00");
		amea2.setLogEntryValues(amea2Values);		
		LogEntryNode am2Node = new LogEntryNode();
		LogEntryNode lim2_8Node = new LogEntryNode();
		lim2_8Node.setLogEntry(lim2_8);		
		am2Node.setLogEntry(amea2);
		am2Node.getSubNodes().add(lim2_8Node);
		block7Node.getSubNodes().add(am2Node);
	}

	@Test
	public void testLogEntryNodeBatchClass() {
		assertEquals(BATCH.class, len.getLogEntry().getClass());
	}
	
	@Test
	public void testLogEntryNodeBTestClass() {
		ILogEntry le = ((LogEntryNode) len.getSubNodes().get(0)).getLogEntry();
		assertEquals(BTEST.class, le.getClass());
	}
	
	@Test
	public void testLogEntryNodeBlockClass() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		for (ILogEntryNode tempLEN : tempList) {
			assertEquals(BLOCK.class, tempLEN.getLogEntry().getClass());
		}
	}
	
	@Test
	public void testLogEntryNodeBlock1SubNodeClasses() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(0);
		
		assertEquals(BLOCK.class, block.getLogEntry().getClass());
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		
		assertEquals(AJUM.class, blockSubnodes.get(0).getLogEntry().getClass());
		assertEquals(LIM2.class, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getClass());
		assertEquals(PF.class, blockSubnodes.get(1).getLogEntry().getClass());		
	}
	
	@Test
	public void testLogEntryNodeBlock2SubNodeClasses() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(1);
		
		assertEquals(BLOCK.class, block.getLogEntry().getClass());
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		
		assertEquals(AJUM.class, blockSubnodes.get(0).getLogEntry().getClass());
		assertEquals(LIM2.class, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getClass());	
	}
	
	@Test
	public void testLogEntryNodeBlock3SubNodeClasses() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(2);
		
		assertEquals(BLOCK.class, block.getLogEntry().getClass());
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		
		assertEquals(AJUM.class, blockSubnodes.get(0).getLogEntry().getClass());
		assertEquals(LIM2.class, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getClass());
	}
	
	@Test
	public void testLogEntryNodeBlock4SubNodeClasses() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(3);
		
		assertEquals(BLOCK.class, block.getLogEntry().getClass());
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		
		assertEquals(AJUM.class, blockSubnodes.get(0).getLogEntry().getClass());
		assertEquals(LIM2.class, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getClass());
	}
	
	@Test
	public void testLogEntryNodeBlock5SubNodeClasses() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(4);
		
		assertEquals(BLOCK.class, block.getLogEntry().getClass());
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		
		assertEquals(AJUM.class, blockSubnodes.get(0).getLogEntry().getClass());
		assertEquals(LIM2.class, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getClass());
	}
	
	@Test
	public void testLogEntryNodeBlock6SubNodeClasses() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(5);
		
		assertEquals(BLOCK.class, block.getLogEntry().getClass());
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		
		assertEquals(AJUM.class, blockSubnodes.get(0).getLogEntry().getClass());
		assertEquals(LIM2.class, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getClass());
	}
	
	@Test
	public void testLogEntryNodeBlock7SubNodeClasses() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(6);
		
		assertEquals(BLOCK.class, block.getLogEntry().getClass());
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		
		assertEquals(AMEA.class, blockSubnodes.get(0).getLogEntry().getClass());
		assertEquals(LIM2.class, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getClass());
		assertEquals(AMEA.class, blockSubnodes.get(1).getLogEntry().getClass());
		assertEquals(LIM2.class, blockSubnodes.get(1).getSubNodes().get(0).getLogEntry().getClass());
	}
	
	@Test
	public void testBatchLogEntryValues() {
		ArrayList<String> expectedValues = new ArrayList<String>();
		expectedValues.add("501-6338-02");
		expectedValues.add("50");
		expectedValues.add("12");
		expectedValues.add("1");
		expectedValues.add("");
		expectedValues.add("btest");
		expectedValues.add("040107103921");
		expectedValues.add("");
		expectedValues.add("solmb3t1");
		expectedValues.add("501-6338-02");
		expectedValues.add("RevA");
		expectedValues.add("");
		expectedValues.add("");
		expectedValues.add("");
		
		ArrayList<String> givenValues = len.getLogEntry().getValues();

		assertEquals(expectedValues, givenValues);
	}
	
	@Test
	public void testBtestLogEntryValues() {
		ArrayList<String> expectedValues = new ArrayList<String>();
		expectedValues.add("5016338409302");
		expectedValues.add("00");
		expectedValues.add("040107105353");
		expectedValues.add("000350");
		expectedValues.add("0");
		expectedValues.add("all");
		expectedValues.add("");
		expectedValues.add("n");
		expectedValues.add("n");
		expectedValues.add("040107105943");
		expectedValues.add("");
		expectedValues.add("1");
		expectedValues.add("");
		
		ArrayList<String> givenValues = len.getSubNodes().get(0).getLogEntry().getValues();

		assertEquals(expectedValues, givenValues);
	}

	@Test
	public void testBtestAllBlockValues() {
		ArrayList<ILogEntryNode> blockList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();

		for (int i=0; i<blockList.size(); i++) {
			ArrayList<String> expectedValues = new ArrayList<String>();
			switch (i) {
			case 0:				
				expectedValues.add("polarity_check");
				expectedValues.add("00");				
				break;
			case 1:
				expectedValues.add("swprobe1");
				expectedValues.add("00");
				break;
			case 2:
				expectedValues.add("swprobe2");
				expectedValues.add("00");
				break;
			case 3:
				expectedValues.add("swprobe3");
				expectedValues.add("00");
				break;
			case 4:
				expectedValues.add("swprobe4");
				expectedValues.add("00");
				break;
			case 5:
				expectedValues.add("swprobe5");
				expectedValues.add("00");
				break;
			case 6:
				expectedValues.add("vr1");
				expectedValues.add("00");
				break;
			}
			assertEquals(expectedValues, blockList.get(i).getLogEntry().getValues());
		}
	}

	@Test
	public void testLogEntryNodeBlock1SubNodeValues() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(0);
		
		ArrayList<String> jumExpected = new ArrayList<String>();
		jumExpected.add("0");
		jumExpected.add("+3.478301E+00");
		
		ArrayList<String> lim2Expected = new ArrayList<String>();
		lim2Expected.add("+8.000000E+00");
		lim2Expected.add("+0.000000E+00");
		
		ArrayList<String> pfExpected = new ArrayList<String>();
		pfExpected.add("pins");
		pfExpected.add("0");
		pfExpected.add("0");
		
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		assertEquals(jumExpected, blockSubnodes.get(0).getLogEntry().getValues());
		assertEquals(lim2Expected, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getValues());
		assertEquals(pfExpected, blockSubnodes.get(1).getLogEntry().getValues());
	}
	
	@Test
	public void testLogEntryNodeBlock2SubNodeValues() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(1);
		
		ArrayList<String> jumExpected = new ArrayList<String>();
		jumExpected.add("0");
		jumExpected.add("-7.630803E+06");
		
		ArrayList<String> lim2Expected = new ArrayList<String>();
		lim2Expected.add("+9.999999E+99");
		lim2Expected.add("+1.000000E+04");
		
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		assertEquals(jumExpected, blockSubnodes.get(0).getLogEntry().getValues());
		assertEquals(lim2Expected, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getValues());
	}
	
	@Test
	public void testLogEntryNodeBlock3SubNodeValues() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(2);
		
		ArrayList<String> jumExpected = new ArrayList<String>();
		jumExpected.add("0");
		jumExpected.add("+7.631804E+06");
		
		ArrayList<String> lim2Expected = new ArrayList<String>();
		lim2Expected.add("+9.999999E+99");
		lim2Expected.add("+1.000000E+04");
		
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		assertEquals(jumExpected, blockSubnodes.get(0).getLogEntry().getValues());
		assertEquals(lim2Expected, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getValues());
	}
	
	@Test
	public void testLogEntryNodeBlock4SubNodeValues() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(3);
		
		ArrayList<String> jumExpected = new ArrayList<String>();
		jumExpected.add("0");
		jumExpected.add("+7.630803E+06");
		
		ArrayList<String> lim2Expected = new ArrayList<String>();
		lim2Expected.add("+9.999999E+99");
		lim2Expected.add("+1.000000E+04");
		
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		assertEquals(jumExpected, blockSubnodes.get(0).getLogEntry().getValues());
		assertEquals(lim2Expected, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getValues());
	}
	
	@Test
	public void testLogEntryNodeBlock5SubNodeValues() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(4);
		
		ArrayList<String> jumExpected = new ArrayList<String>();
		jumExpected.add("0");
		jumExpected.add("+7.630803E+06");
		
		ArrayList<String> lim2Expected = new ArrayList<String>();
		lim2Expected.add("+9.999999E+99");
		lim2Expected.add("+1.000000E+04");
		
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		assertEquals(jumExpected, blockSubnodes.get(0).getLogEntry().getValues());
		assertEquals(lim2Expected, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getValues());
	}
	
	@Test
	public void testLogEntryNodeBlock6SubNodeValues() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(5);
		
		ArrayList<String> jumExpected = new ArrayList<String>();
		jumExpected.add("0");
		jumExpected.add("-7.630303E+06");
		
		ArrayList<String> lim2Expected = new ArrayList<String>();
		lim2Expected.add("+9.999999E+99");
		lim2Expected.add("+1.000000E+04");
		
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		assertEquals(jumExpected, blockSubnodes.get(0).getLogEntry().getValues());
		assertEquals(lim2Expected, blockSubnodes.get(0).getSubNodes().get(0).getLogEntry().getValues());
	}
	
	@Test
	public void testLogEntryNodeBlock7SubNodeValues() {
		ArrayList<ILogEntryNode> tempList = ((LogEntryNode) len.getSubNodes().get(0)).getSubNodes();
		ILogEntryNode block = tempList.get(6);
		
		ArrayList<String> mea1Expected = new ArrayList<String>();
		mea1Expected.add("0");
		mea1Expected.add("+1.201013E+01");
		mea1Expected.add("in");
		
		ArrayList<String> mea2Expected = new ArrayList<String>();
		mea2Expected.add("0");
		mea2Expected.add("+3.317988E+00");
		mea2Expected.add("out");
		
		ArrayList<ILogEntryNode> blockSubnodes = block.getSubNodes();
		assertEquals(mea1Expected, blockSubnodes.get(0).getLogEntry().getValues());
		assertEquals(mea2Expected, blockSubnodes.get(1).getLogEntry().getValues());
	}
}
