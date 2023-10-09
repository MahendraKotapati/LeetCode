import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Deque;

public class ValidParentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("\nANS: " + isValid(str));
        sc.close();
    };

    public static boolean isValid(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();

        for(char c: s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else {
                if (!stack.isEmpty() && stack.pop() == c) {
                    continue;
                }
                else { // either stack empty or don't have corresponsing opening bracket for c (current char)
                    return false;
                }
            }
        }

        return stack.isEmpty(); // all opening brackets has corresponding closing brackets
    }
}
