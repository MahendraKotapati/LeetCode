import java.util.Arrays;

public class PermutationinString {

    public boolean isSameFrequency(int[] a, int[] b) {

        for(int i=0;i<26;i++) {
            if (a[i] != b[i]) 
                return false;
        }
        return true;
    }

    // Optimized approach with Sliding window O(n) is available
    /*
     * Approach:    TC: O(n^2)
     * 1. Generate all substrings of s2 and check if any one of substring char freq is equal to s1 char freq
     * 2. Since s1's any permutation can be considered and we can just consider s1's char freq
     */

    public boolean checkInclusion(String s1, String s2) {
        
        int[] freqS1 = new int[26];
        int[] substrFreq = new int[26];

        for(int i=0;i<s1.length();i++) 
            freqS1[s1.charAt(i)-'a']++;

        for(int i=0;i<s2.length();i++) {
            for(int j=i;j<s2.length();j++) {
                substrFreq[s2.charAt(j)-'a']++;

                if (isSameFrequency(freqS1, substrFreq)) {
                    return true;
                }
            }
            // clear substrFreq for new substring starting with i+1
            Arrays.fill(substrFreq, 0); 
        }

        return false;

    }
}