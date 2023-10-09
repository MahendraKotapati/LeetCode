import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs[] = new String[]{"bat", "tan", "nat"};
        groupAnagrams(strs);
        sc.close();
    };

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramList = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            
            if (map.get(key) == null) {
                map.put(key, new ArrayList<String>() {{ add(str); }});
            } else {
                map.get(key).add(str);
            }
        }

        for(String k: map.keySet()) {
            anagramList.add(map.get(k));
        }

        System.out.println(anagramList);
        return anagramList;
    }
}