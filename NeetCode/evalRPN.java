package NeetCode;

import java.util.Stack;

public class evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (String token : tokens) {
            if ((token.equals("+")) || (token.equals("+")) || (token.equals("-")) || (token.equals("*"))
                    || (token.equals("/"))) {
                int b = s.pop();
                int a = s.pop();
                int result = applyOperator(token, a, b);
                s.push(result);
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }

    private int applyOperator(String operator, int a, int b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return a / b;

        }
    }
}
