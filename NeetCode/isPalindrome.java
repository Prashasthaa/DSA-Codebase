package NeetCode;

public class isPalindrome {
    public boolean isPalindrome(String s) {
        int lp = 0;
        int rp = s.length() - 1;

        while (lp < rp) {
            while (lp < rp && !Character.isLetterOrDigit(s.charAt(lp))) {
                lp++;
            }
            while (lp < rp && !Character.isLetterOrDigit(s.charAt(rp))) {
                rp--;
            }
            if (Character.toLowerCase(s.charAt(lp)) != Character.toLowerCase(s.charAt(rp))) {
                return false;

            }
            rp--;
            lp++;
        }
        return true;
    }
}
