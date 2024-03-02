import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "aaa";

        // System.out.println("Ans: " + minCut(s));
        RandomizedSet r = new RandomizedSet();
        r.insert();
        sc.close();
    }
}

class RandomizedSet {

    Set<Integer> s;
    public RandomizedSet() {
        s = new HashSet<>();
    }
    
    public boolean insert(int val) {
        return s.add(val);
    }
    
    public boolean remove(int val) {
        return !!s.remove(val);
    }
    
    public int getRandom() {
        Random r = new Random();
        s.
    }
}

