class Solution {

    /*
        1. maximum possible hIndex is 'n' because let us assume hIndex as 'n+1' then we need to have atleast n+1 papers publised which is not possible
        2. use counting sort to count the citations, now count[i] stores no.of papers which are cited 'i' times
        3. then do suffix sum on count[], now count[i] stores no.of papers which are cited atleast 'i' times
        4. now find hIndex of the given array
    */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+2];  // suffix count array 

        for(int citation: citations) { // counting sort
            if (citation > n) // as maxHIndex is 'n', any citation > n should be added to count[n] 
                count[n]++;
            else
                count[citation]++; 
        }

        for(int hIndex=n;hIndex>=0;hIndex--) {
            count[hIndex] = count[hIndex] + count[hIndex+1]; // creating suffix count array
            if (count[hIndex] >= hIndex) // look for hIndex where atleast 'hIndex' papers published and each cited atleast 'hIndex' times
                return hIndex;
        }

        return 0;
    }

    /*
    Approach2: O(n*2)
    public int hIndex(int[] citations) {
        int paperCount = 0, maxHIndex = Integer.MIN_VALUE;

        for(int hIndex=0;hIndex<=1000;hIndex++) {
            paperCount = 0;
            for(int citation: citations) {
                if (citation >= hIndex)
                    paperCount++;
            }
            if (paperCount >= hIndex)
            {
                maxHIndex = Math.max(maxHIndex, hIndex);
            }
        }
        return maxHIndex;
    }
    */
}