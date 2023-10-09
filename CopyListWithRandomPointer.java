import java.util.Scanner;


/*
* 1. Create copy node in the same list for every node. like 1 -> 1 -> 2 -> 2 -> 3 -> 3 (for list 1 -> 2 -> 3)
* 2. For every original node, original->next->random = original->random->next 
* 3. Restore the original and copy linked lists 
     original->next = original->next->next;
     copy->next = copy->next->next;
*/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

 
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(1);
        Node b = new Node(2);
        head.next = b;
        Node c = new Node(3);
        b.next = c;
        Node d = new Node(4);
        c.next = d;

        head.random = d;
        b.random = c;
        d.random = c;
        c.random = head;
        

        // print the result
        Node temp = copyRandomList(head);
        while(temp != null) {
            System.out.println("val: " + temp.val + (temp.random != null ?  "random: " + temp.random.val : "") );
            temp = temp.next;
        }
        
        sc.close();
    };

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;

        // creating copy nodes side by side
        while (curr != null) {
            Node temp = new Node(curr.val);
            Node next = curr.next;
            curr.next = temp;
            temp.next = next;
            curr = next;
        }


        // copying random pointers, since copy nodes present next to original node 
        curr = head;
        while (curr != null && curr.next != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node copyHead = head.next;

        // restoring the original and copy lists.
        curr = head;
        while (curr != null && curr.next != null) {
            Node temp = curr.next.next;
            if (curr.next.next != null) {
                curr.next.next = curr.next.next.next;
            }
            curr.next = temp;
            curr = curr.next;
        }

        return copyHead;
    }
}
