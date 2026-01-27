import java.util.Scanner;

public class Strings {

    public static void palindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                System.out.println("Not Palindrome");
                return;
            }
        }
        System.out.println("Palindrome");
    }

    public static void shortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if (dir == 'W')
                x--;
            else if (dir == 'E')
                x++;
            else if (dir == 'S')
                y--;
            else if (dir == 'N')
                y++;
        }
        double shortestPath = Math.sqrt((x * x) + (y * y));
        System.out.println("PAth =" + shortestPath);
    }

    public static String subString(String str, int si, int ei) {
        String subString = "";
        for (int i = si; i < ei; i++) {
            subString += str.charAt(i);
        }
        return subString;
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));

            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        StringBuilder compressedString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            compressedString.append(str.charAt(i));
            if (count > 1) {
                compressedString.append(count);
            }
        }
        return compressedString.toString();
    }

    public static void main(String[] args) {

        // // Defining strings
        // char arr[] = { 'a', 'b', 'c', 'd' };
        // String str = "abcd";
        // String str1 = new String("xyz");

        // // In java strings are immutable

        // // Input the strings
        // Scanner sc = new Scanner(System.in);

        // String name = sc.nextLine();

        // // output the string
        // System.out.println(name);

        // // Length of string
        // String fullName = "Prashastha Poojary";
        // System.out.println(fullName.length());

        // // concatenation
        // String firstName = "Prashastha";
        // String lastName = "Poojary";

        // String fullName1 = firstName + " " + lastName;
        // System.out.println(fullName1);

        // // charAt method
        // System.out.println(fullName1.charAt(7));

        // String str = "racecar";

        // palindrome(str);

        // String path = "WWEESSEENN";
        // String path1 = "WNEENESENNN";
        // shortestPath(path);
        // shortestPath(path1);

        // // Substring
        // String str = "Hello World";

        // System.out.println(subString(str, 0, 5));

        // // built in substring
        // System.out.println(str.substring(0, 5));

        // // Print Largest String
        // String fruits[] = { "apple", "mango", "banana" };
        // String largest = fruits[0];
        // for (int i = 1; i < fruits.length; i++) {
        // if (largest.compareTo(fruits[i]) < 0) {
        // largest = fruits[i];
        // }
        // }
        // System.out.println(largest);

        // StringBuilder sb = new StringBuilder("");
        // for (char ch = 'a'; ch <= 'z'; ch++) {
        // sb.append(ch);

        // }
        // System.out.println(sb);

        // String str = "hii, i am prashastha!";
        // System.out.println(toUpperCase(str));

        String str = "aabbbbcccdddds";
        System.out.println(compress(str));
    }

}
