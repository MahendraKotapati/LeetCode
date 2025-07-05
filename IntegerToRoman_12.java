import java.util.*;
public class IntegerToRoman_12 {
    
    // TC: O(1) as limited Symbols in Roman System
    // SC: O(1)
    HashMap<Integer, String> ROMAN_SYSTEM;

    public String intToRoman(int num) {
        ROMAN_SYSTEM = new HashMap<Integer, String>();
        ROMAN_SYSTEM.put(1, "I");
        ROMAN_SYSTEM.put(5, "V");
        ROMAN_SYSTEM.put(10, "X");
        ROMAN_SYSTEM.put(50, "L");
        ROMAN_SYSTEM.put(100, "C");
        ROMAN_SYSTEM.put(500, "D");
        ROMAN_SYSTEM.put(1000, "M");

        ROMAN_SYSTEM.put(4, "IV");
        ROMAN_SYSTEM.put(9, "IX");

        ROMAN_SYSTEM.put(40, "XL");
        ROMAN_SYSTEM.put(90, "XC");

        ROMAN_SYSTEM.put(400, "CD");
        ROMAN_SYSTEM.put(900, "CM");

        return findRoman(num);
    }

    public String findRoman(int num) {
        if (num <= 0)
            return "";

        if (ROMAN_SYSTEM.get(num) != null) 
            return ROMAN_SYSTEM.get(num);

        String numString = String.valueOf(num);

        if (numString.startsWith("4") || numString.startsWith("9")) {
            int curr = (numString.charAt(0) - '0') * (int)Math.pow(10, (numString.length()-1));
            return ROMAN_SYSTEM.get(curr) + findRoman(num-curr);
        }

        if (num >= 1000)
            return ROMAN_SYSTEM.get(1000) + findRoman(num-1000);
        else if (num >= 500)
            return ROMAN_SYSTEM.get(500) + findRoman(num-500);
        else if (num >= 100)
            return ROMAN_SYSTEM.get(100) + findRoman(num-100);
        else if (num >= 50)
            return ROMAN_SYSTEM.get(50) + findRoman(num-50);
        else if (num >= 10)
            return ROMAN_SYSTEM.get(10) + findRoman(num-10);
        else if (num >= 5)
            return ROMAN_SYSTEM.get(5) + findRoman(num-5);
        else
            return ROMAN_SYSTEM.get(1) + findRoman(num-1);
    }
}