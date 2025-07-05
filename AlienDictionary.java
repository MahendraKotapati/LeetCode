/*
Question:

    There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.

    You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are 
    sorted lexicographically by the rules of this new language.

    If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".

    Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there are multiple solutions, return any of them.

EX1:   
    Input: words = ["wrt","wrf","er","ett","rftt"]
    Output: "wertf"

EX2:
    Input: words = ["z","x","z"]
    Output: ""
    Explanation: The order is invalid, so return ""
 */




import java.util.*;

public class AlienDictionary {
    /* Time & Space complexity
        let n = words.length, U = no_of_Uniq_chars 
        TC: O(n*|max_word_len|) 
        SC: O(V+E) (toposort complexity) = O(U + min(U^2, n-1))
        -- since we are creating edges between only adjacent words max edges possible are n-1
        -- creating edges between only adjacent words should be suffient
        ex: W1, W2, W3 
            let us say there exists edges W1 --> W2, W2 --> W3 it means indirectly there exists an edge between W1 --> W3 so, we don't need to create one
    */

    /* Approach:  
        1. for every consecutive word, find first differing character as based on that words are sorted
        2. if one word is prefix of other then prefix word should come first in order
           ex:     rs ,rsc is valid order
               but rsc, rs is invalid order because as per dictionary order prefixes should come first
        3. from point 1, make an edge between differing chars
        4. Now, the graph constructed find the topological ordering of graph using khan's algorithm
    */

    @SuppressWarnings("unchecked")
    public String alienOrder(String[] words) {
        ArrayList<Integer>[] graph = new ArrayList[26];
        HashMap<Character, Integer> indegree = new HashMap<>();
        StringBuffer res = new StringBuffer("");

        for(int i=0;i<26;i++)
            graph[i] = new ArrayList<>();

        for(int i=0;i<words.length;i++) {
            for(char ch: words[i].toCharArray()) 
                indegree.put(ch, 0);  // initialize indegree with all unique chars
        }

        for(int i=0;i<words.length-1;i++) {
            int p = 0, q = 0, len = Math.min(words[i].length(), words[i+1].length());
            while(p<len && q<len) {
                if (words[i].charAt(p) != words[i+1].charAt(q))
                    break;
                p++;q++;
            }

            if (words[i].length() > words[i+1].length() && q==len) // word[i+1] is prefix of word[i], but as per rules prefix should come first
                return "";

            if (p == len && q == len) // if both are same words 
                continue;
            
            char firstChar = words[i].charAt(p); 
            char secondChar = words[i+1].charAt(q);
            graph[firstChar-'a'].add(secondChar-'a');  // create an edge between differing chars
            indegree.put(secondChar, indegree.get(secondChar)+1);
        }

        // find topological ordering using khan's algorithm

        Queue<Integer> queue = new LinkedList<>();

        for(char ch: indegree.keySet()) {
            if (indegree.get(ch)==0)
                queue.add(ch-'a');
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            res.append((char)(node+'a'));

            for(int child:graph[node]) {
                char childChar = (char)(child+'a');
                indegree.put(childChar, indegree.get(childChar)-1);
                if (indegree.get(childChar)==0) 
                    queue.add(child);
            }
        }

        // topological order is not possible, indegree.size() is no.of nodes in the graph.
        if (res.length() != indegree.size())
            return ""; 

        return res.toString();
    }
}