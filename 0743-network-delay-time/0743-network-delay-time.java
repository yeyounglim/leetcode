import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) 
            graph.put(i, new ArrayList<>());

        for (int[] time : times)
            graph.get(time[0]).add(new int[]{time[1], time[2]});

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.add(new int[]{k, 0});


        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            if (time > distance[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int nextTime = time + neighbor[1];

                if (nextTime < distance[nextNode]) {
                    distance[nextNode] = nextTime;
                    pq.add(new int[]{nextNode, nextTime});
                }
            }
        }
        int result = Arrays.stream(distance).skip(1).max().getAsInt();
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}