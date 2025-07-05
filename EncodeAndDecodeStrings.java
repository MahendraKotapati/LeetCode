/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
 */


import java.util.*;

public class EncodeAndDecodeStrings {

    String delimter = "/-";

    /*
        let us take delimter = "/-";
        1) Use Delimter and combine given list of strings
        2) it might be possible that delimter may also present in given strings. 
        3) so escape it using escape sequence character (used / here)
        4) In Encoding replace all '/' with '//'
        4) In Decoding if we get '/' check the next character
            if next character == '/' then 
                include curr '/' and ignore next '/'  
            else if next character == '-'
                current char and next char is part of delimiter. so, process accordingly.
    */

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer("");

        for(int i = 0;i<strs.size();i++) {
            String s = strs.get(i);
            sb.append(s.replace("/", "//"));

            if(i != strs.size() - 1) {
                sb.append(delimter);
            } 
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<String>();
        StringBuffer currString = new StringBuffer("");

        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) != '/' || (i == s.length() - 1)) 
                currString.append(s.charAt(i));  
            else {
                if (s.charAt(i+1) == '/') {
                    currString.append(s.charAt(i));
                    i++;
                } else if (s.charAt(i+1) == '-') {
                    ans.add(currString.toString());
                    currString = new StringBuffer("");
                    i++;
                }
            }
        }

        ans.add(currString.toString());

        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));