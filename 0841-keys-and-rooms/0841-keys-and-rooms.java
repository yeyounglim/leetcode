class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        visited.add(0);
        queue.offer(0);

        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();

            for (int key : rooms.get(currentRoom)) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}