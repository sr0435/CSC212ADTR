package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testInsert() {
		SetADT<String> inserter = new JavaSet<>();
		inserter.insert("test1");
		assertEquals(inserter.size(), 1);
	}
	
	@Test
	public void testRepeatInsert() {
		SetADT<String> inserter = new JavaSet<>();
		inserter.insert("test1");
		inserter.insert("test1");
		assertEquals(inserter.size(), 1);
	}
	
	@Test
	public void testSize() {
		SetADT<String> sizer = new JavaSet<>();
		Random rand = new Random();
		int testSizer = rand.nextInt(10);
		for (int i=0; i<testSizer; i++) {
			sizer.insert("test" + i);
		}
		assertEquals(sizer.size(), testSizer);
	}
	
	@Test
	public void testContains() {
		SetADT<String> container = new JavaSet<>();
		container.insert("test value");
		assertEquals(container.contains("test value"), true);
		assertEquals(container.contains("wrong value"), false);
	}
	
	@Test
	public void testRemove() {
		SetADT<String> remover = new JavaSet<>();
		remover.insert("yeehaw");
		remover.insert("hawyee");
		remover.remove("hawyee");
		assertEquals(remover.contains("hawyee"), false);
	}
	
	@Test
	public void testToList() {
		SetADT<String> lister = new JavaSet<>();
		lister.insert("mango");
		lister.insert("pomegranate");
		lister.insert("lychee");
		ListADT<String> newLister = lister.toList();
		assertEquals(newLister instanceof ListADT, true);
		assertEquals(lister instanceof SetADT, true);
	}
	
	// TODO finish toJava test
	@Test
	public void testToJava() {
		SetADT<String> javernator = new JavaSet<>();
		javernator.insert("mango");
		javernator.insert("pomegranate");
		javernator.insert("lychee");
	}
}
