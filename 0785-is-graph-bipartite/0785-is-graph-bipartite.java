class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 1;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighborNode : graph[node]) {
                
                    if (color[neighborNode] == 0) {
                        color[neighborNode] = color[node] + 1;
                        queue.add(neighborNode);
                    } else if (color[neighborNode] == color[node])
                        return false;

                }
            }
        }
        return true;
    }
}
