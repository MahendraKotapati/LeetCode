import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class ReorganizeString {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("\nANS: " + reorganizeString(str));
        sc.close();
    };

    public static String reorganizeString2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        StringBuffer res = new StringBuffer();
        int first = 1, last = s.length() - 1;
        
        for(char ch: s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        Character[] charArr = new Character[s.length()];

        for(int i=0;i<s.length();i++) {
            charArr[i] = s.charAt(i);
        }


        Arrays.sort(charArr, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                if (freqMap.get(a) != freqMap.get(b)) {
                    return freqMap.get(b) - freqMap.get(a);
                }
                return a - b;
            }
        });

        for(Character c: charArr) {
            System.out.print(c);
        }

        
        res.append(charArr[0]);

        while (first <= last) {
            if (res.charAt(res.length() - 1) == charArr[first]) {
                if (res.charAt(res.length() - 1) == charArr[last]) {
                    return "";
                }
                res.append(charArr[last]);
                last--;
            } else {
                res.append(charArr[first]);
                first++;
            }
        }


        return res.toString();
    }
    
    public static String reorganizeString(String s) {
        if (s.length() <= 1) {
            return s;
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        StringBuffer res = new StringBuffer();
        int first, last;
        
        for(char ch: s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        Character[] charArr = new Character[s.length()];

        for(int i=0;i<s.length();i++) {
            charArr[i] = s.charAt(i);
        }


        Arrays.sort(charArr, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                if (freqMap.get(a) != freqMap.get(b)) {
                    return freqMap.get(b) - freqMap.get(a);
                }
                return a - b;
            }
        });

        for(Character c: charArr) {
            System.out.print(c);
        }

        first = 0; last = 1;

        while(last < charArr.length && charArr[last - 1] == charArr[last]) {
            last++;
        }

        int secondCharStartIdx = last;

        while (first < secondCharStartIdx) {
            if (first < charArr.length) {
                res.append(charArr[first]); first++;
            }

            if (last < charArr.length) {
                res.append(charArr[last]); last++;
            }
        }

        for(int i = 1;i < res.length(); i++) {
            if (res.charAt(i-1) == res.charAt(i)) {
                return "";
            }
        }


        return res.toString();
    }
      

}



 // while(res.length() < s.length()) {
        //     for(char ch: freqMap.keySet()) {
        //         if (freqMap.get(ch) > 0) {
        //             if (res.length() > 0 && res.charAt(res.length() - 1) == ch) {
        //                 return "";
        //             }
        //             res.append(ch);
        //             freqMap.put(ch, freqMap.get(ch) - 1);
        //         }
        //     }
        // }

