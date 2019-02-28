package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaChallengeTest {

	public SetADT<Integer> makeLeftSet() {
		SetADT<Integer> left = new JavaSet<Integer>();
		left.insert(1);
		left.insert(2);
		left.insert(3);
		left.insert(4);
		left.insert(5);
		return left;
	}
	
	public SetADT<Integer> makeRightSet() {
		SetADT<Integer> right = new JavaSet<Integer>();
		right.insert(4);
		right.insert(5);
		right.insert(6);
		right.insert(7);
		right.insert(8);
		return right;
	}
	
	public ListADT<String> makeSentence() {
		ListADT<String> sentence = new JavaList<String>();
		sentence.addBack("a");
		sentence.addBack("g");
		sentence.addBack("b");
		sentence.addBack("c");
		sentence.addBack("a");
		sentence.addBack("b");
		sentence.addBack("b");
		return sentence;
	}
	
	
	@Test
	public void testUnion() {
		SetADT<Integer> leftSide = makeLeftSet();
		SetADT<Integer> rightSide = makeRightSet();
		SetADT<Integer> unionized = Challenges.union(leftSide,rightSide);
		// the union should be less than the sum of the two sets bc some
		// elements are repeated
		assertEquals(unionized.size(), 8);
	}
	
	@Test
	public void testIntersect() {
		SetADT<Integer> leftSide = makeLeftSet();
		SetADT<Integer> rightSide = makeRightSet();
		SetADT<Integer> intersected = Challenges.intersection(leftSide,rightSide);
		assertEquals(intersected.size(), 2);
	}
	
	@Test
	public void testWordCount() {
		ListADT<String> sentence = makeSentence();
		MapADT<String,Integer> wordCounts = Challenges.wordCount(sentence);
		assertEquals(wordCounts.toJava().get("a")==2
				&& wordCounts.toJava().get("b")==3
				&& wordCounts.toJava().get("c")==1
				&& wordCounts.toJava().get("g")==1, true);
	}
}
