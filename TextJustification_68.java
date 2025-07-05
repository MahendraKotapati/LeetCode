import java.util.*;

class Solution {

    /*
    Approach: TC: O(n*maxWidth) SC: O(maxWidth)

    1. greedily select no.of words in a line as maximum as possible
    2. one space should be fixed between words. then extraSpaces added based on availability of maxWidth
    2. now, find no.of extra spaces, spacesCount = maxWidth - lineWordsTotalLength;
    3. find spacesPerWord = spacesCount / (lineWords.size()-1);
    4. remainderSpacesCount are added starting from left side in line, in addition to spacesPerWord, 
       remainderSpacesCount = spacesCount % (lineWords.size()-1);
    5. handle last line separately - left justified

    */
    public String getExtraSpacesString(int spacesPerWord, int remainderSpacesCount, int wordIndex) {
        StringBuilder s = new StringBuilder("");

        for(int i=0;i<spacesPerWord;i++) {
            s.append(" ");
        }
        
        // based on wordIndex we add the remainderSpaces because we need to add remainderSpaces starting from left.
        // ex: if remainderSpacesCount = 3, then first three spaces in a line gets a extra space.
        if (wordIndex <= remainderSpacesCount) {
             s.append(" ");
        }

        return s.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> ans = new ArrayList<>();
        List<String> lineWords = new ArrayList<>();
        StringBuilder justifiedLine = new StringBuilder("");
        int remainderSpacesCount, spacesPerWord, lineWordsTotalLength =0; 

        for(String word: words) {
            int spaceBeforeWord = (lineWords.size() == 0) ? 0 : 1; // spaceBeforeWord is not required if it is a first word.

            if ((lineWordsTotalLength + word.length()+ spaceBeforeWord) <= maxWidth) {
                lineWords.add(word); 
                lineWordsTotalLength = lineWordsTotalLength + word.length() + spaceBeforeWord;
            } else {
                int spacesCount = maxWidth - lineWordsTotalLength;
                justifiedLine = new StringBuilder(lineWords.get(0));

                if (lineWords.size() > 1) { 
                    remainderSpacesCount = spacesCount % (lineWords.size()-1);
                    spacesPerWord = spacesCount / (lineWords.size()-1);

                    for(int i=1; i<lineWords.size(); i++) {
                        String extraSpaces = getExtraSpacesString(spacesPerWord, remainderSpacesCount, i);
                        justifiedLine.append(" " + extraSpaces + lineWords.get(i));
                        // adding one space separately in above line because it is the default space between each word.
                    }
                } else {
                    String extraSpaces = getExtraSpacesString(spacesCount, 0, 1);
                    justifiedLine.append(extraSpaces);
                }

                ans.add(justifiedLine.toString());

                // add currentWord to newLine
                lineWords = new ArrayList<>();
                lineWords.add(word);
                lineWordsTotalLength = word.length();
            }
        }

        // handling last line - left justified
        justifiedLine = new StringBuilder("");
        justifiedLine.append(lineWords.get(0));
        
        for(int i=1; i<lineWords.size(); i++) {
            justifiedLine.append(" " + lineWords.get(i));
        }

        justifiedLine.append( getExtraSpacesString(maxWidth - justifiedLine.length(), 0, 1) );
        ans.add(justifiedLine.toString());

        return ans;

    }
}