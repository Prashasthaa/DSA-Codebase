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

        String str = "racecar";

        palindrome(str);

    }

}
