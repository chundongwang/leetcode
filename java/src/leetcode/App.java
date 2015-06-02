package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		{
			String start = "hit";
			String end = "cog";
			String[] dict_arr = { "hot", "dot", "dog", "lot", "log" };
			List<List<String>> result = null;
			result = testWordLadder2(start, end, dict_arr);
			for (List<String> entry : result) {
				System.out.println(String.join(",", entry));
			}
		}

		{
			String start = "qa";
			String end = "sq";
			String[] dict_arr = { "si", "go", "se", "cm", "so", "ph", "mt",
					"db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar",
					"ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow",
					"sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn",
					"au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb",
					"yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga",
					"li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os",
					"uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc",
					"ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta",
					"tb", "ni", "mr", "pa", "he", "lr", "sq", "ye" };
			List<List<String>> result = null;
			result = testWordLadder2(start, end, dict_arr);
			for (List<String> entry : result) {
				System.out.println(String.join(",", entry));
			}
		}
	}

	private static List<List<String>> testWordLadder2(String start, String end,
			String[] dict_arr) {
		WordLadder2 s = new WordLadder2();
		Set<String> dict = new HashSet<String>();
		for (String word : dict_arr) {
			dict.add(word);
		}
		//return s.findLadders_easiest(start, end, dict);
		return s.findLadders_cutting(start, end, dict);
	}

}
