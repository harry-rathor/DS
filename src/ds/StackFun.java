package ds;

import java.util.Stack;

public class StackFun {
    public static void main(String[] args) {

        String expr = "(({[]}))";
        expr = "{(})";
        Boolean isValid = validateBracketString(expr);
        System.out.println("expr: " + isValid);

    }

    private static Boolean validateBracketString(String expr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {

            char ch = expr.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                char stackPop = stack.pop();
                if (ch == '}' && stackPop != '{') {
                    return false;
                } else if (ch == ']' && stackPop != '[') {
                    return false;
                } else if (ch == ')' && stackPop != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
