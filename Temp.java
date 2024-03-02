import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        Stack<String> animals= new Stack<>();
        // ArrayList<Node> a = new ArrayList<>();
        // Collections.sort(a, (n1, n2) -> n1.count - n2.count); // arrayList custom sort

        animals.push(null);

        List<Integer> arr_list = Arrays.asList(arr);
        ArrayList<Integer> arr_arrayList = new ArrayList<Integer>(Arrays.asList(arr));
        // System.out.println("Ans: " + fun(nums));

        // Arrays.sort(arr,  Comparator.reverseOrder());

        Collections.sort(arr_list);
        Collections.sort(arr_list, Comparator.reverseOrder());
        Collections.reverse(arr_list);
        
        for(int num: arr_list) {
            System.out.print(num + " ");
        }

        arr_list.add(12);
        arr_list.add(32);
        arr_list.add(22);

        System.out.println();

        for(int i =0; i< arr_arrayList.size(); i++) {
            System.out.print(arr_arrayList.get(i) + " ");
        }

        System.out.println();

        sc.close();
    }
}