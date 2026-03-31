import java.util.ArrayList;

public class mostWaterContainer {

    public static void maxAreaBrute(ArrayList<Integer> heigth) {

        int maxArea = 0;
        for (int i = 0; i < heigth.size() - 1; i++) {
            for (int j = i + 1; j < heigth.size(); j++) {
                int minHeigth = Math.min(heigth.get(i), heigth.get(j));
                int width = j - i;
                int currArea = width * minHeigth;
                maxArea = Math.max(maxArea, currArea);
            }

        }
        System.out.println("Maximum Area=" + maxArea);
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();

        // 1,8,6,2,5,4,8,3,7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        maxAreaBrute(height);
    }
}
