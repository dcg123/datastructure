package AStackProblemInLeetcode;


import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));
    }

    private boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                char topChar=stack.pop();
                if (c=='('&&topChar!=')'){
                    return false;
                }
                if (c=='{'&&topChar!='}'){
                    return false;
                }
                if (c=='['&&topChar!=']'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
