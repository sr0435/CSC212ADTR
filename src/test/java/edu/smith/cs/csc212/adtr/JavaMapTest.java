package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	void assertIntEquals(int x, int y) {
		assertEquals(x,y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testPut() {
		MapADT<String, Integer> putter = new JavaMap<>();
		putter.put("guava", 3);
		putter.put("custard apple", 2);
		assertEquals(putter.size(), 2);
	}
	
	@Test
	public void testGet() {
		MapADT<String, Integer> getter = new JavaMap<>();
		getter.put("dice", 3);
		getter.put("markers", 7);
		assertIntEquals(getter.get("dice"), 3);
	}
	
	@Test
	public void testSize() {
		MapADT<String, Integer> sizer = new JavaMap<>();
		sizer.put("mice", 3);
		sizer.put("cats", 7);
		assertEquals(sizer.size(), 2);
	}
	
	@Test
	public void testRemove() {
		MapADT<String, Integer> remover = new JavaMap<>();
		remover.put("dice", 3);
		remover.put("markers", 7);
		remover.remove("dice");
		// checks that dice was removed
		assertEquals(remover.getKeys().toJava().contains("dice"), false);

	}
	
	// 
	@Test
	public void testGetKeys() {
		MapADT<String, Integer> keytizer = new JavaMap<>();
		keytizer.put("pisces", 3);
		keytizer.put("aries", 7);
		keytizer.put("taurus", 5);
		List<String> testingKeys = keytizer.getKeys().toJava();
		assertEquals(testingKeys.contains("pisces"),true);
		assertEquals(testingKeys.contains("aries"), true);
		assertEquals(testingKeys.contains("taurus"), true);
		}
	
	@Test
	public void testGetEntries() {
		MapADT<String, Integer> entererer = new JavaMap<>();
		entererer.put("pisces", 3);
		entererer.put("aries", 7);
		entererer.put("taurus", 5);
		// first checks if getEntries makes a listADT
		assertEquals(entererer.getEntries() instanceof ListADT, true);
		// then adds toJava so the test can check if the keys and values
		// are being put in correctly
		List<Pair<String, Integer>> enterererList = entererer.getEntries().toJava();
		assertEquals(enterererList.get(0).getKey()=="taurus" && enterererList.get(0).getValue()==5, true);
		assertEquals(enterererList.get(1).getKey()=="aries" && enterererList.get(1).getValue()==7, true);
		assertEquals(enterererList.get(2).getKey()=="pisces" && enterererList.get(2).getValue()==3, true);
	}
	
	@Test
	public void testToJava() {
	MapADT<String, Integer> maptastic = new JavaMap<>();
	maptastic.put("vanilla", 8);
	maptastic.put("chocolate", 9);
	maptastic.put("strawberry", 10);
	// checks if maptastic was converted to a HashMap from a MapADT
	assertEquals(maptastic.toJava() instanceof HashMap && maptastic.toJava() instanceof MapADT==false, true);
	// makes sure everything was added and is paired correctly to its key/value
	assertEquals(maptastic.toJava().get("vanilla")==8,true);
	assertEquals(maptastic.toJava().get("chocolate")==9,true);
	assertEquals(maptastic.toJava().get("strawberry")==10,true);
	}
	
	
	}
