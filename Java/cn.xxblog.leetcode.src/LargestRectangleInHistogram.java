import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int cutH = heights[i];
            if (cutH == 0) {
                continue;
            }
            int width = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < cutH) {
                    break;
                }
                width += 1;
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] == cutH && i + 1 == j)
                    i = j;
                if (heights[j] < cutH) {
                    break;
                }
                width += 1;
            }
            if (width * cutH > max)
                max = width * cutH;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] h = new int[]{2, 1, 4, 5, 1, 3, 3};
        new LargestRectangleInHistogram().largestRectangleArea(h);
    }
}
