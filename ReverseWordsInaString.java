public class ReverseWordsInaString {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuffer currentWord = new StringBuffer("");
        StringBuffer ans = new StringBuffer("");

        for(int i=n-1;i>=0;i--) {
            if (s.charAt(i) == ' ') {
                if (currentWord.length() > 0) {
                    ans.append(currentWord.reverse() + " ");
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(s.charAt(i));
            }
        }
        // if input contains only one word
        if (currentWord.length() > 0) {
            ans.append(currentWord.reverse() + " ");
        }
        ans.toString();

        // remove last extra space added
        ans = new StringBuffer(ans.substring(0, ans.length()-1));
        return ans.toString();
    }
}