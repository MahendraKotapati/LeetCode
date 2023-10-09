import java.util.Scanner;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class AddTwoNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head1 = new ListNode(2, null);
        ListNode b = new ListNode(4, null);
        head1.next = b;
        ListNode c = new ListNode(3, null);
        b.next = c;


        
        ListNode head2 = new ListNode(5, null);
        ListNode q = new ListNode(6, null);
        head2.next = q;
        ListNode r = new ListNode(4, null);
        q.next = r;


        ListNode head = addTwoNumbers(head1, head2);

        // print the result
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        
        sc.close();
    };

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null);
        ListNode tail = head;
        int carry = 0;

        while(l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;

            ListNode temp = new ListNode(0, null);
            temp.val = (a + b + carry) % 10;
            carry = (a + b + carry) >= 10 ? 1 : 0;

            tail.next = temp;
            tail = temp;
            l1 = l1.next; l2 = l2.next;
        }


        // for l1.length > l2. length
        while(l1 != null) {
            ListNode temp = new ListNode(0, null);
            temp.val = (l1.val + carry) % 10;
            carry = (l1.val + carry) >= 10 ? 1 : 0;

            tail.next = temp;
            tail = temp;

            l1 = l1.next;
        }

        // for l2.length > l1. length
        while(l2 != null) {
            ListNode temp = new ListNode(0, null);
            temp.val = (l2.val + carry) % 10;
            carry = (l2.val + carry) >= 10 ? 1 : 0;

            tail.next = temp;
            tail = temp;

            l2 = l2.next;
        }

        // if carry is present at last add a new node.
        if (carry == 1) {
           ListNode temp = new ListNode(1, null); 
           tail.next = temp;
           tail = temp;
        } 

        head = head.next; // as first node is empty;
        return head;
    } 
    
}


/*
 *     L1: [2, 4, 3]
 *     L2: [5, 6, 4]
 *         [7, 0, 8]   
 * 
 * 
 * 
 */