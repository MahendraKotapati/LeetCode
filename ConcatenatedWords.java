import java.util.*;

public class ConcatenatedWords {
    HashSet<String> hashSet;
    int[][] dp;

    /*
     * TC: O(words.length * max_length_word^2) = O(n*m^2)
     * SC: O(words.length * max_length_word) = O(n*m)
     * 
     * Approach:
     * 1. Store all words in hashSet
     * 2. Now, for each and every word find if it can be formed by concatenating any of the words(except the current word) from words list
     * 3. step2 is nothing but a word break problem (given a list of words and target word , we need to find whether target can be formed by using given words)
     */

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        hashSet = new HashSet<String>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();

        for(String s: words) {

            dp = new int[s.length()][2];
            for(int i=0;i<s.length();i++) {
                Arrays.fill(dp[i], -1);
            }
            
            if (wordBreak(s, 0, 0)) {
                ans.add(s);
            }       
        }

        return ans;
    }

    // hasSplit = 0 - no split yet
    // hasSplit = 1 - has atleast one split happened
    // in order to say a current_word can be formed by concatenating any of the given list of words hasSplit should be 1
    public boolean wordBreak(String s, int startIndex, int hasSplit) {
        if (startIndex == s.length() && hasSplit == 1) {
            return true;
        }

        if (startIndex >= s.length()) {
            return false;
        }

        if (dp[startIndex][hasSplit] != -1) {
            return dp[startIndex][hasSplit] == 1;
        }

        StringBuffer currString = new StringBuffer("");
        boolean currAns = false;
        for(int i=startIndex;i<s.length();i++) {
            currString.append(s.charAt(i));
            if (hashSet.contains(currString.toString())) {
                int updatedSplit = ((startIndex !=0) || ((i+1) != s.length())) ? 1 : 0; // if startIndex == 0 && (i+1) == s.length() it means we found entire word match with itself from list of words we should ignore it
                currAns = currAns || wordBreak(s, i+1, updatedSplit);
            }
        } 

        dp[startIndex][hasSplit] = (currAns == true) ? 1 : 0;
        
        return currAns;
    }
}