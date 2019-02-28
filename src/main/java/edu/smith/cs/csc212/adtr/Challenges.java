package edu.smith.cs.csc212.adtr;

import java.util.List;
import java.util.Map;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class Challenges {

	// The union of two sets is the set of elements that either contains.
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		//adds everything in the left (now list) to the final set
		for (int i=0; i<left.toList().size();i++) {
			output.insert(left.toList().getIndex(i));
		}
		// adds everything in the right list
		for (int i=0; i<right.toList().size();i++) {
			output.insert(right.toList().getIndex(i));
		}
		// since it's a set, the repeated elements won't be added twice
		return output;
	}
	
	
	// The intersection of two sets is the set of elements that both contain.
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		for (int i=0; i<left.toList().size();i++) {
			// if the right list has the things in the left list
			//then it gets added
			if (right.contains(left.toList().getIndex(i))) {
				output.insert(left.toList().getIndex(i));
			}
		}
		return output;
	}
	
	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		// creates a mapadt version
		MapADT<String, Integer> output = new JavaMap<>();
		// creates a regular map
		Map<String,Integer> output1 = output.toJava();
		// changes the listadt into a list
		List<String> listWords = words.toJava();
		// for each string in the list, this assigns that string a number
		// that matches how many times it has come up and adds it to the map
		for (int i=0; i<listWords.size();i++) {
			int prev = output1.getOrDefault(listWords.get(i), 0);
			output1.put(listWords.get(i), prev+1);
		}
		// adds the items in the regular map to the mapadt
		for (String key : output1.keySet()) {
			output.put(key, output1.get(key));
		}
		
		return output;
	}
}
