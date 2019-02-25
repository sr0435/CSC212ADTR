package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
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
		assertEquals(remover.size(), 1);
	}
	
	// TODO finish
	@Test
	public void testGetKeys() {
		MapADT<String, Integer> keytizer = new JavaMap<>();
		keytizer.put("pisces", 3);
		keytizer.put("aries", 7);
		keytizer.put("taurus", 5);
		keytizer.getKeys();


		}
	}
