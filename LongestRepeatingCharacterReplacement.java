public class LongestRepeatingCharacterReplacement {

    public int getMaxFrequency(int[] count) {
        int max = 0;
        for(int i = 0; i<count.length; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        return max;
    }

    /*
     * -> Use sliding window approach
     * -> For current window maintain frequency in array - count[]
     * -> For each char check if it can be added to window
     * -> In a window, assume we are changing all characters to X (X is the one which has max fequency count in that window) this way it requires min operations
     * -> so, curr_substr_len - max_count gives no.of chars need to be changed in that window.
     * -> if we still have operations left increase the window size by adding new chars.
     */ 

    public int characterReplacement(String s, int k) { 

        int[] count = new int[26];
        int start = 0, i = 0, max_substr_len = 0;

        while(i < s.length()) {
           int curr_substr_len = i - start;
           int max_count = getMaxFrequency(count);
           
           // curr_substr_len - max_count gives no.of chars need to be changed
           if (k >= curr_substr_len - max_count) {
              max_substr_len = Math.max(max_substr_len, curr_substr_len); 
              count[(int)(s.charAt(i) - 'A')]++;
              i++;
           } else { // we run of operations so, move window start pointer to forward.
              count[(int)(s.charAt(start) - 'A')]--;
              start++;
           } 
        }

        
        int curr_substr_len = i - start;
        int max_count = getMaxFrequency(count);

        if (k >= curr_substr_len - max_count) {
            max_substr_len = Math.max(max_substr_len, curr_substr_len); 
        }


        return max_substr_len;

    }
}