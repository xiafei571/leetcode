package ktng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SourceAndEnd {
	public static void main(String[] args) {
		/*
		 * 第二题是给个数组，数组里面存放着好多组有向边，比如[(A,B), (B,C),
		 * (A,D),(E,F)]（不会有环），然后让你输出所有的源点以及对应的终点，比如对于刚才的这个例子，你要输出{A:[C,D], E:F}
		 */
		String[][] input = { { "A", "B" }, { "B", "C" }, { "A", "D" }, { "E", "F" } };
		question2(input);
	}
	
	private static void question2(String[][] input) {
		Map<String, Integer> indegres = new HashMap<String, Integer>();
		Map<String, Set<String>> graph = new HashMap<>();
		
		for(String[] pair : input) {
			String from = pair[0];
			String to = pair[1];
			
			Set<String> childs =  graph.getOrDefault(from, new HashSet<>());
			childs.add(to);
			graph.put(from,  childs);
			
			Integer fromIndegree = indegres.getOrDefault(from, 0);
			Integer toIndegree = indegres.getOrDefault(to, 0);
			
			indegres.put(from, fromIndegree);
			indegres.put(to, toIndegree + 1);
		}
		
		for(String node : indegres.keySet()) {
			Integer indegree = indegres.get(node);
			if(indegree == 0) {//is root
				List<String> ends = new ArrayList<>();
				dfs(node, graph, ends);
				
				System.out.print(node+":");
				for(String str : ends) {
					System.out.print(" "+str+" ");
				}
				System.out.println();
			}
		}
	}
	
	private static void dfs(String node, Map<String, Set<String>> graph, List<String> ends) {
		Set<String> childs =  graph.get(node);
		if(childs == null || childs.size() == 0) {//end
			ends.add(node);
		}else {
			for(String child : childs) {
				dfs(child, graph, ends);
			}
		}
	}
}
