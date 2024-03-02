// https://leetcode.com/problems/plates-between-candles/description/


public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int n = s.length();
        int[] left = new int[n]; // holds neartest left candle index
        int[] right = new int[n]; // holds neartest right candle index
        int[] prefix = new int[n]; // holds no.of plates (plates should be between candles) in the range s[0:i] 
        int[] ans = new int[queries.length];

        right[n-1] = s.charAt(n-1) == '|' ? n-1 : -1;

        for(int i=n-2;i>=0;i--) {
            if (s.charAt(i) == '|') {
                right[i] = i;
            } else {
                right[i] = right[i+1];
            }
        }

        left[0] = s.charAt(0) == '|' ? 0 : -1;

        for(int i=1;i<n;i++) {
            if (s.charAt(i) == '|') {
                left[i] = i;
            } else {
                left[i] = left[i-1];
            }
        }

        
        prefix[0] = 0; 

        for(int i=1;i<n;i++) {
            if (s.charAt(i) == '|') {
                prefix[i] = prefix[i-1];
            } else if (left[i] != -1 && right[i] != -1 ) {
                prefix[i] = prefix[i-1] + 1;
            }
        }

        for(int i=0;i<queries.length;i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            // we can't directly take prefix[r] - prefix[l-1]; 
            // because prefix[r] may have plates which based on right candle at position i (i>r) 
            // because prefix[l] may have plates which based on left candle at position i (i<l) 
            int updatedL = right[l];  // find neartest candle to the right of given L;
            int updatedR = left[r];  // find neartest candle to the left of given R;

            if (updatedL >= updatedR || updatedL == -1 || updatedR == -1) // -1 indicates corresponding left or right candle not exists.
                ans[i] = 0;
            else 
                ans[i] = prefix[updatedR] - (updatedL-1 >=0 ? prefix[updatedL-1] : 0);
        } 

        return ans;

    }
}