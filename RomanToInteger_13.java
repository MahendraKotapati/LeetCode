import java.util.*;

public class RomanToInteger_13 {

    /*
        1. In general Roman numbers will be in non-decreasing order from right to left. (58 = LVIII)
            but in some cases like 4 - IV, 9 - IX , in decreasing order it means
        2. from right to left if ROMAN string is in non-decreasing order. we need to add numbers
            else we need to subract the small number
    */

    public int romanToInt(String s) {
        HashMap<Character, Integer> ROMAN_SYSTEM = new HashMap<>();
        int curr, prev, ans = 0, n = s.length();

        ROMAN_SYSTEM.put('I', 1);
        ROMAN_SYSTEM.put('V', 5);
        ROMAN_SYSTEM.put('X', 10);
        ROMAN_SYSTEM.put('L', 50);
        ROMAN_SYSTEM.put('C', 100);
        ROMAN_SYSTEM.put('D', 500);
        ROMAN_SYSTEM.put('M', 1000);
        
        ans = ROMAN_SYSTEM.get(s.charAt(n-1));
        for(int i=n-2;i>=0;i--) {
            prev = ROMAN_SYSTEM.get(s.charAt(i+1));
            curr = ROMAN_SYSTEM.get(s.charAt(i));

            if (prev > curr) // if in decreasing order subract the small number
                curr = -curr;
            ans = ans + curr;
       }
       return ans;    
    }
}