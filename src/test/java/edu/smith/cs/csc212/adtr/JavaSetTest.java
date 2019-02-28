package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
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
		// makes sure that toList made a new ListADT
		assertEquals(newLister instanceof ListADT, true);
		// makes sure the original set is still a setADT
		assertEquals(lister instanceof SetADT, true);
		// checks if everything is in the list
		assertEquals(newLister.toJava().contains("mango")
				&& newLister.toJava().contains("pomegranate")
				&& newLister.toJava().contains("lychee"), true);
	}
	
	@Test
	public void testToJava() {
		SetADT<String> javernator = new JavaSet<>();
		javernator.insert("mango");
		javernator.insert("pomegranate");
		javernator.insert("lychee");
		// checks if toJava actually converted to the new HashSet
		assertEquals(javernator.toJava() instanceof HashSet 
			&& javernator.toJava() instanceof SetADT==false, true);
		// checks if the hash set has all the items
		assertEquals(javernator.toJava().contains("mango")
				&& javernator.toJava().contains("pomegranate")
				&& javernator.toJava().contains("lychee"), true);
	}
}
