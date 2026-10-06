package practice.striever.recurssion;

import java.util.*;

public class Prac2 {

//	Task 2: Core Java - First Non-Repeating Character (Interview Favorite)
//	Data Structures r string manipulation theke eta QA Automation interview te khub common.
//
//	Question: Ekta String dewa ache. Toke oi string theke first non-repeating character (jeta ekbar i ache r sabcheye prothome ache) tar index ba character ta return korte hobe. Na thakle -1 return korbi.
//
//	Example:
//
//	Input: "automation" -> Output: 'u' (Karon 'a', 't', 'o' repeat hoyeche, 'u' holo first jeta repeat hoyni).
//
//	Input: "aabb" -> Output: -1
//
//	Tor Task: Eta Core Java te solve kor. Tui chaile HashMap use korte paris ba array frequency method use korte paris. Complexity jate O(N) hoy se dike kheyal rakhis.
	public static void main(String[] args) {
		System.out.println(nonRepeatChar("aabbcdefg"));
	}
	
	public static int nonRepeatChar(String string) {
		int index = -1;
		
		Map<Character , Integer> frequency = new LinkedHashMap<>();
		
		for(int i = 0 ; i < string.length() ; i++) {
			char c = string.charAt(i);
			frequency.put(c , frequency.getOrDefault(c,0)+1);
		}
		
		for(char c : frequency.keySet()) {
			if(frequency.get(c) == 1) {
				index = string.indexOf(c);
				break;
			}
		}
		
		return index;
	}

}
