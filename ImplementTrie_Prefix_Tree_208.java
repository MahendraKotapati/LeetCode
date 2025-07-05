class Node {
    Node[] links;
    boolean isEnd;

    Node() {
        links = new Node[26]; // represents 26 alphabets
        isEnd = false;
    }

    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }

    public Node get(char ch) {
        return links[ch-'a'];
    }

    public void put(char ch, Node newNode) {
        links[ch-'a'] = newNode;
    }

}

    /*                   root
            |_|_|_|_|_|_|_|_|_|_|_|_|_|....
            a b c d e f g h ..............
            /              \
           /                \
(a links) |_|_|..            |_|_|..  (h-links)

        1. every node has 26 links. 
           if in h links, if Hnode[ch] != null means there is path from h to ch.
        2. word ends are marked with isEnd = true

    */

class Trie {
    Node root;

    public Trie() {
       root = new Node(); 
    }
    
    public void insert(String word) {
        Node currentNode = root;
        for(char ch: word.toCharArray()) {
            if (!currentNode.containsKey(ch)) { // if no existing link to ch
                currentNode.put(ch, new Node());
            }
            currentNode = currentNode.get(ch); 
        }

        currentNode.isEnd = true; // mark the word completion.
    }
    
    public boolean search(String word) {
        Node currentNode = root;

        for(char ch: word.toCharArray()) {
            currentNode = currentNode.get(ch);
            if (currentNode == null) { // if no path link to ch, word doesn't exist
                break;
            }
        }
        // currentNode.isEnd should be true, to avoid assuming (prefix of some other word) as search word.
        return currentNode != null && currentNode.isEnd;
    }
    
    // similar to search() except return condition.
    public boolean startsWith(String prefix) {
        Node currentNode = root;

        for(char ch: prefix.toCharArray()) {
            currentNode = currentNode.get(ch);
            if (currentNode == null) {
                break;
            }
        }
        
        return currentNode != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */