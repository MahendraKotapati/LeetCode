class Node {
    Node links[];
    boolean isEnd;

    Node() {
        links = new Node[26];
        isEnd = false;
    }

    public Node get(char ch) {
        return links[ch-'a'];
    }

    public void put(char ch, Node newNode) {
        links[ch-'a'] = newNode;
    }
}


class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node currentNode = root;
        for(char ch: word.toCharArray()) {
            if (currentNode.get(ch) == null) {   
                currentNode.put(ch, new Node());
            }
            currentNode = currentNode.get(ch);
        }
        currentNode.isEnd = true; 
    }
    
    public boolean search(String word) {
        return searchRec(word, 0, root);
    }

    public boolean searchRec(String word, int idx, Node currentNode) {
        if (idx == word.length()) {
            // currentNode.isEnd = false - it means it is prefix
            // currentNode.isEnd = true - it means it is a word
            return currentNode.isEnd;
        }

        if (word.charAt(idx) == '.') {
            for(int i=0;i<26;i++) { // '.' can be matched with any character
                if (currentNode.get((char)(i+'a')) != null) {
                    // if search word found with any one of matched char, return true
                    if (searchRec(word, idx+1, currentNode.get((char)(i+'a')))) 
                        return true;
                }
            }
        } else {
            if (currentNode.get(word.charAt(idx)) != null) {
                // if path link exist to word.charAt(idx) then proceed
                if (searchRec(word, idx+1, currentNode.get(word.charAt(idx)))) 
                    return true;
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */