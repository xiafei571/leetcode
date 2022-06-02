package bytedance;

import java.util.HashMap;
import java.util.Map;

public class FindCheapestPrice787 {
int cheapest = Integer.MAX_VALUE;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {//Time Limit Exceeded
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        buildGraph(g, flights);
        boolean[] visited = new boolean[n];
        
        dfs(src, dst, k+1, 0, g, visited);
        
        return cheapest == Integer.MAX_VALUE? -1 : cheapest;
    }
    
    private void buildGraph(Map<Integer, Map<Integer, Integer>> g, int[][] flights){
        for(int[] flight : flights){
            int src = flight[0];
            int dst = flight[1];
            int cost = flight[2];
            
            Map<Integer, Integer> map = g.getOrDefault(src, new HashMap<>());
            map.put(dst, cost);
            g.put(src, map);
        }
    }
    
    private void dfs(int src, int dst, int k, int currCost, Map<Integer, Map<Integer, Integer>> g, boolean[] visited){
        
        if(src == dst){
            cheapest = Math.min(cheapest, currCost);
            return;
        }
        
        if(k == 0){
            return;
        }
        
        Map<Integer, Integer> map = g.get(src);
        if(map == null || map.size() == 0){
            return;
        }
        
        for(Integer next : map.keySet()){
            if(visited[next]){
                continue;
            }
            int cost = map.get(next);
            if(cost + currCost >= cheapest){
                continue;
            }
            visited[next] = true;
            dfs(next, dst, k-1, currCost+cost, g, visited);
            visited[next] = false;
        }
        
    }
}
