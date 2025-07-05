public class KthSymbolInGrammar {
    
    // everything is 1 based indexing
    public int kthGrammar(int n, int k) {
        if (n==1 || k==1)
            return 0;

        // every k'th bit in n'th row is dependent on Math.ceil(k/2.0) bit in (n-1)th row
        int parentBit = kthGrammar(n-1, (int)Math.ceil((k) / 2.0));

        // if parentBit = 0 then there dependent bits in children row are 01
        // if parentBit = 1 then there dependent bits in children row are 10
        if ((parentBit == 0 && k%2 == 1) || (parentBit == 1 && k%2 == 0))
            return 0;
        return 1;
    }
}

