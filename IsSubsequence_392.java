public class IsSubsequence_392 {
    // 1. iterate main string 't', then if t[i] == s[sIndex] move sIndex forward
    // 2. if sIndex == s.length() || i >=n loop will exit;
    // 3. at the end if sIndex == s.length() then s is subsequence of 't' else it's not.

    public boolean isSubsequence(String s, String t) {
        int n = t.length(), sIndex = 0;
        for(int i=0; i<n;i++) {
            if (sIndex == s.length())
                break;
            if (s.charAt(sIndex) == t.charAt(i))
                sIndex++;
        }

        return sIndex == s.length();
    }
}