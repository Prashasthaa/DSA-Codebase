package classRoom;

public class trappedRainWater {

    // time complexity => O(n)
    public static void trappedRainWater(int heigth[]) {
        int n = heigth.length;
        // leftMaximum
        int leftMaximum[] = new int[n];
        leftMaximum[0] = heigth[0];
        for (int i = 1; i < n; i++) {
            leftMaximum[i] = Math.max(heigth[i], leftMaximum[i - 1]);
        }

        // rightMaximum
        int rightMaximum[] = new int[n];
        rightMaximum[n - 1] = heigth[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaximum[i] = Math.max(heigth[i], rightMaximum[i + 1]);
        }

        int trappedWater = 0;

        // water level = min(leftMaximum,rightMaximum)
        // trapped water= waterlevel- height

        for (int i = 0; i < n; i++) {
            int waterlevel = Math.min(leftMaximum[i], rightMaximum[i]);
            trappedWater += waterlevel - heigth[i];
        }
        System.out.println("Trapped Water = " + trappedWater);
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        trappedRainWater(height);
    }

}
