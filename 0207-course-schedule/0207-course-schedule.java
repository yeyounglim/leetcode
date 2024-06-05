import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) 
            graph.add(new ArrayList<>());
        
        for (int[] prerequisite : prerequisites) 
            graph.get(prerequisite[1]).add(prerequisite[0]);

        int[] status = new int[numCourses];

        for (int i = 0; i < numCourses; i++) 
            if (checkCycle(graph, status, i)) return false;
        
        return true;
    }

    private boolean checkCycle(List<List<Integer>> graph, int[] status, int node) {
        if (status[node] == 1) return true;

        if (status[node] == 2) return false;

        status[node] = 1;
        
        for (int neighbor : graph.get(node)) 
            if (checkCycle(graph, status, neighbor)) return true;
        
        status[node] = 2;
        
        return false;
    }
}