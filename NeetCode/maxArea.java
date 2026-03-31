package NeetCode;

public class maxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int lp = 0;
        int rp = height.length - 1;

        while (lp < rp) {
            int currHeight = Math.min(height[lp], height[rp]);
            int width = rp - lp;
            int currArea = currHeight * width;

            maxArea = Math.max(currArea, maxArea);

            if (height[lp] < height[rp]) {
                lp++;

            } else {
                rp--;
            }
        }
        return maxArea;
    }

}
