import java.util.*;

class Solution {

    /*
        Approach: TC: O((4^n) * n)
        1. for each digit, in digits string try all possible characters for that digit
        2. append one of possible char to currentWord and move forward in recursion
           and after recursion is ended remove that possible char appended.
        3. each digit has max 4 possible chars, and we have 'n' such digits
           4 * 4 * 4 ..... n times
           so, time complexity is O((4^n) * n)
           4^n is multiplied by 'n' because to construct answer string it will take O(n)
           
           StringBuilder.toString() - O(n) time complexity
    */

    HashMap<Integer, ArrayList<String>> MAPPINGS;

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0)
            return ans;

        MAPPINGS = new HashMap<>();

        MAPPINGS.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        MAPPINGS.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        MAPPINGS.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
        MAPPINGS.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        MAPPINGS.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        MAPPINGS.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        MAPPINGS.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
        MAPPINGS.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        solve(0, new StringBuilder(""), digits, ans);
        return ans;  
    }

    public void solve(int i, StringBuilder currentWord, String digits, List<String> ans) {
        if (i>= digits.length()) {
            ans.add(currentWord.toString());
            return;
        }

        List<String> charList = MAPPINGS.get(digits.charAt(i)-'0');

        for(String ch: charList) {
            currentWord.append(ch);

            solve(i+1, currentWord, digits, ans);

            currentWord.deleteCharAt(currentWord.length()-1);
        }

    }
}