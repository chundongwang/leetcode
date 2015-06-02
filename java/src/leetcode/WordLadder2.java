package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		return findLadders_easiest(start, end, dict, new HashSet<String>());
    }
    private boolean isLadder(String a, String b) {
    	int diff = 0;
    	for (int i = 0; i<a.length(); i++) {
    		if (a.charAt(i) == b.charAt(i)) {
    			continue;
    		} else {
    			diff++;
    		}
    		if (diff > 1) {
    			break;
    		}
    	}
    	return diff == 1;
    }

    public List<List<String>> findLadders_cutting(String start, String end, Set<String> dict) {
    	int best_score = findLadders_cutting(start, end, dict, 0, Integer.MAX_VALUE);
    	return null;
    }
    
    public int findLadders_cutting(String start, String end, Set<String> dict, int level, int best_score) {
		List<List<String>> result = new ArrayList<List<String>>();
		
		if (best_score < level+1) return Integer.MAX_VALUE;
		
		Queue<String> next_level = new ArrayDeque<String>();
		Map<String, Integer> word_levels = new HashMap<String, Integer>();
		
		for (String key : dict) {
			if (isLadder(key, end)) {
				best_score = level+1;
				word_levels.put(key, best_score);
			} else if (isLadder(key, start)) {
				next_level.add(key);
			}
		} 
		if (best_score > level+1) {
			while (!next_level.isEmpty()) {
				String word = next_level.remove();
				
				dict.remove(word);
				int score = findLadders_cutting(word, end, dict, level+1, best_score);
				dict.add(word);
				
				if (score < best_score) {
					best_score = score;
				}
				word_levels.put(word, score);
			}
		}
        return best_score;
    }
    
    public List<List<String>> findLadders_easiest(String start, String end, Set<String> dict) {
		return findLadders_easiest(start, end, dict, new HashSet<String>());
    }
    
    public List<List<String>> findLadders_easiest(String start, String end, Set<String> dict, Set<String> exclude_dict) {
		List<List<String>> result = new ArrayList<List<String>>();

        for (String key : dict) {
        	if (!exclude_dict.contains(key) && isLadder(start, key)) {
        		if (end.equals(key)) {
            		result.add(new ArrayList<String>());
            		result.get(result.size()-1).add(start);
            		result.get(result.size()-1).add(end);
            		return result;
        		} else if (isLadder(key, end)) {
            		result.add(new ArrayList<String>());
            		result.get(result.size()-1).add(start);
            		result.get(result.size()-1).add(key);
            		result.get(result.size()-1).add(end);
            		return result;
        		} else {        		
        			exclude_dict.add(key);
        			List<List<String>> subs = findLadders_easiest(key, end, dict, exclude_dict);
        			int shortest_len = Integer.MAX_VALUE;
        			for (List<String> sub : subs) {
        				if (shortest_len > sub.size()) {
        					shortest_len = sub.size();
        				}
        			}
        			for (List<String> sub : subs) {
        				if (sub.size() <= shortest_len) {
	        				sub.add(0, start);
	        				result.add(sub);
        				}
        			}
        			exclude_dict.remove(key);
        		}
        	}
        }
        return result;
    }
}
