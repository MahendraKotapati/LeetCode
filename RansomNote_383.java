class Solution {
    /*
    1. Use count array. 
    2. increase count[] based on characters in magazine then decrease count[] based on characters in ransomNote
    3. if for any of count[i] < 0 it means ransomNote needs extra characters than what exists in magazine.
       so, return false 
       else return true.
    */

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for(char c: magazine.toCharArray()) {
            count[c-'a']++;
        }

        for(char c: ransomNote.toCharArray()) {
            count[c-'a']--;
        }

        for(int i=0;i<26;i++) {
            if (count[i] < 0)
                return false;
        }

        return true;
    }
}