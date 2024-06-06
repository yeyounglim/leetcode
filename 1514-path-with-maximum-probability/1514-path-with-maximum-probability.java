import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[]{edges[i][1], i});
            graph.get(edges[i][1]).add(new int[]{edges[i][0], i});
        }

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        Queue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.add(new double[]{start_node, 1.0});

        while (!pq.isEmpty()) {
            double[] current = pq.poll();
            int node = (int) current[0];
            double prob = current[1];

            if (node == end_node)
                return prob;

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                double nextProb = prob * succProb[neighbor[1]];

                if (nextProb > maxProb[next]) {
                    maxProb[next] = nextProb;
                    pq.add(new double[]{next, nextProb});
                }
            }
        }
        return 0.0;
    }
}