/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort"));// true
		System.out.println(isAnagram("Tom Marvolo Ridle","I am Lord Voldemort")); // false
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // false
		
		System.out.println(isAnagram("ababa","aabb")); // false
		

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		System.out.println(preProcess("Tom Marvolo Riddle"));
		System.out.println(preProcess("Bar Nahary ? Richman"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String sTr1 = preProcess(str1);
		String sTr2 = preProcess(str2);
		// if the Strings are not equal - definetly not an anagram.
		  // first loop : 
			for (int i = 0; i < sTr1.length(); i++) {
				char c = sTr1.charAt(i);
				// another loop ! 
				boolean sec = false;
				for (int j = 0; j < sTr2.length(); j++) {
					if (sTr2.charAt(j) == c) {
						sec = true;
						break;
					}
				}
				if (!sec) {
					return false;

			}
			}
			return true; 
		}

	
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// first loop - for the Upper-lower cases : 
		String outcome = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
		if (Character.isUpperCase(c)) {
				outcome += Character.toLowerCase(c);
			// second condition
			}
			if (c >= 'a' && c <= 'z') {
				outcome += c;
			}  else if (c == ' ') {
				outcome += ' ';
			}
		}
			return outcome;
			}
			

	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String sTr = preProcess(str);
		String outcome = "";
		// a while loop : 
		while (sTr.length() > 0) {
			int randomeChar = (int) (Math.random() * sTr.length());
			outcome += sTr.charAt(randomeChar);
			sTr = sTr.substring(0, randomeChar) + sTr.substring(randomeChar + 1);
		}

		return outcome;
	}
}
