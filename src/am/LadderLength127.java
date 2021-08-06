package am;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LadderLength127 {
	
	public static void main(String[] args) {
		
		String[] words = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = new ArrayList<String>();
		for(String word : words) {
			wordList.add(word);
		}
		String beginWord = "hit";
		String endWord = "cog";
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, Set<String>> relations = new HashMap<String, Set<String>>();
		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
		
		Set<String> wordSet = new HashSet<String>(wordList);
		if(!wordSet.contains(endWord)){
            return 0;
        }
		wordSet.add(beginWord);
		wordSet.add(endWord);
		
		for(String word : wordSet) {
			List<String> words = allWord(word);
			for(String s : words) {
				Set<String> relation = relations.getOrDefault(s, new HashSet<String>());
				if(relation.size() > 0) {
					for(String node : relation) {
						Set<String> set1 = graph.getOrDefault(node, new HashSet<String>());
						set1.add(word);
						graph.put(node, set1);
						Set<String> set2 = graph.getOrDefault(word, new HashSet<String>());
						set2.add(node);
						graph.put(word, set2);
					}
				}
				relation.add(word);
				relations.put(s, relation);
			}
		}
		int cnt = bfs(beginWord, endWord, graph);
		
		return cnt;
    }
	
	private static int bfs(String beginWord,String endWord, Map<String, Set<String>> graph) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		queue.add(beginWord);
		visited.add(beginWord);
		int cnt = 1;
		while(queue.size() > 0) {
			int size = queue.size();
			cnt++;
			for(int i = 0; i < size; i++) {// layer
				String parent = queue.poll();
				Set<String> neighbours = graph.getOrDefault(parent, new HashSet<String>());
				for(String neighbour : neighbours) {
					if(neighbour.equals(endWord)) {
						return cnt;
					}
					
					if(visited.contains(neighbour)) {
						continue;
					}else {
						visited.add(neighbour);
						queue.add(neighbour);
					}
				}
			}
		}
		return 0;
	}
	
	private static List<String> allWord(String word){
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < word.length(); i++) {
			String str = "";
			for(int j = 0; j < word.length(); j++) {
				if(i == j) {
					str += "*";
				}else {
					str += word.charAt(j);
				}
			}
			result.add(str);
		}
		return result;
	}
}
