class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        int trappedWater = 0;

        // 현재 높이가 스택의 가장 위에 있는 높이보다 큰 경우, 스택에서 이전 높이를 꺼내어 고일 수 있는 물의 양을 계산
        while (current < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int top = stack.pop();

                if (stack.isEmpty()) break;

                int peek = stack.peek();
                // 현재 인덱스와 스택의 top인덱스 사이 가로 개수
                int width = current - peek - 1;
                // 현재 높이와 스택의 top높이 중 작은 값에서 top높이를 뺀 값
                int heightRange = Math.min(height[current], height[peek]) - height[top];
                trappedWater += width * heightRange;
            }
            stack.push(current);
            current++;
        }
        return trappedWater;
    }
}