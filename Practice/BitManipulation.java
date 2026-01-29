public class BitManipulation {

    public static void oddOrEven(int num) {
        int bitMask = 1;
        if ((num & bitMask) == 1) {
            System.out.println("Odd Number");
        } else {
            System.out.println("Even Number");
        }
    }

    public static void getIthBit(int num, int i) {
        int bitMask = 1 << i;
        if ((num & bitMask) == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    public static void setIthBit(int num, int i) {
        int bitMask = 1 << i;
        System.out.println(num | bitMask);
    }

    public static void clearIthBit(int num, int i) {
        int bitMask = ~(1 << i);
        System.out.println(num & bitMask);
    }

    public static int clearIthBits(int num, int i) {
        int bitMask = ~(1 << i);
        return num & bitMask;
    }

    public static void updateIthBit(int n, int i, int newBit) {
        // if(newBit==0){
        // clearIthBit(n, i);
        // }else{
        // setIthBit(n, i);
        // }

        n = clearIthBits(n, i);
        int bitMask = newBit << i;
        System.out.println(n | bitMask);

    }

    public static void main(String[] args) {

        // // binary operators

        // // Binary And operator
        // System.out.println(5 & 6);

        // // Binary OR operator
        // System.out.println(5 | 6);

        // // Binary XOR OPERATOR
        // System.out.println(5 ^ 6);

        // // Binary one's complement
        // System.out.println(~5);

        // // Binary left shift
        // System.out.println(5 << 2);

        // // Binary Right shift
        // System.out.println(7 >> 2);

        // Questions
        // oddOrEven(0);

        // getIthBit(4, 2);

        // setIthBit(2, 0);

        // clearIthBit(10, 1);

        // updateIthBit(10, 0, 1);

    }
}
