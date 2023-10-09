import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

class Temp {
    public static void main(String[] args) {
        Set<List<Integer>> res  = new HashSet<List<Integer>>();
        res.add(Arrays.asList(1, 2, 3));
        res.add(Arrays.asList(1, 2, 3));
        System.out.print(res.size());
    }
}
