import java.util.*;

class Solution {

    /*
    Approach:
       1. we use stack to solve this problem.
       2. if current token is Integer, push that to stack
       3. if current token is either of +, -, *, / do corresponding operation on top two elements of stack. 
          and push the result to stack.
       4. finally only one element will be in stack, that is our answer.
    */

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int a, b;
        
        for(int i=0;i<tokens.length;i++) {
            if (tokens[i].equals("+")) {
                b = s.pop(); 
                a = s.pop();
                s.push(a+b);
            } else if (tokens[i].equals("-")) {
                b = s.pop(); 
                a = s.pop();
                s.push(a-b);
            } else if (tokens[i].equals("*")) {
                b = s.pop(); 
                a = s.pop();
                s.push(a*b);
            } else if (tokens[i].equals("/")) {
                b = s.pop(); 
                a = s.pop();
                s.push(a/b);
            } else
                s.push(Integer.parseInt(tokens[i]));
        }
        return s.pop();
    }
}