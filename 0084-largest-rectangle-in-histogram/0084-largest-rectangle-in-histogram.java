import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        int MaxArea = 0;

        Stack<Integer> s = new Stack<>();
        
        // Calculate right array
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                right[i] = n - 1;
            } else {
                right[i] = s.peek() - 1;
            }
            s.push(i);
        }
        
        // Reset stack
        s.clear();
        
        // Calculate left array
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = s.peek() + 1;
            }
            s.push(i);
        }
        
        // Calculate MaxArea
        for (int i = 0; i < n; i++) {
            int w = right[i] - left[i] + 1;
            int h = heights[i];
            MaxArea = Math.max(h * w, MaxArea);
        }
        
        return MaxArea;
    }
}
