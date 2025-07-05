import java.util.*;

public class LengthOfLongestValidSubstring {


    /*
     * The trick is based on forbidden[i].length <= 10
     * use sliding window approach, for every new char adding to window check all substrings produced because of this char is in forbidden strings or not.
     * we don't need to check for substrings length > 10
     */

    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length(), start, end, maxLength = 0;
        boolean canIncludeCurrentChar;
        HashSet<String> forbiddenSet = new HashSet<>(forbidden);

        start = 0; end = 0;

        while(start < n && end < n) {
            canIncludeCurrentChar = true;
            for(int i=0;i<10;i++) {
                if (end-i < 0 || end-i < start) break;
                if (forbiddenSet.contains(word.substring(end-i, end+1))) {
                    canIncludeCurrentChar = false;
                }  
            }

            if (canIncludeCurrentChar) {
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                start++;
                if (end < start) end = start;
            }
        }

        return maxLength;
    }
}