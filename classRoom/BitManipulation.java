package classRoom;

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

    public static void clearLastIBits(int n, int i) {
        int bitMask = (~0) << i; // -1 == ~0
        System.out.println(n & bitMask);
    }

    public static void clearRangeOfBits(int n, int i, int j) {
        int a = (~0) << (j + 1);
        int b = (1 << i) - 1;
        int bitMask = a | b;
        System.out.println(n & bitMask);
    }

    public static void powerOf2(int n) {
        int bitMask = n - 1;
        int res = n & bitMask;
        if (res == 0)
            System.out.println("Power of 2");
        else
            System.out.println("not power of 2");
    }

    public static void countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;

        }
        System.out.println(count);
    }

    public static void fastExponentiation(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                // check the LSB
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        System.out.println(ans);
    }

    public static void swapNums(int a, int b) {
        System.out.println("a = " + a + ", b= " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + ", b= " + b);

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

        // clearLastIBits(15, 1);

        // clearRangeOfBits(10, 2, 4);

        // powerOf2(2);/////////

        // countSetBits(10);

        // fastExponentiation(3, 05);

        swapNums(2, 3);

    }
}
