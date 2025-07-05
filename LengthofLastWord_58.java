class Solution {

    // staright forwarded using string built in functions
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" "); // split based on space.
        return words[words.length-1].length();
    }

    // solution2 start from back of string and count characters and 
    // stop when space encountered or string ends.
}