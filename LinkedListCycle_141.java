//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {

    /*
    TC: O(n) SC: O(1)
     Tortoise & Hare algorithm.
     1. move slow pointer one step a head and fast pointer by two steps a head.
     2. eventually they meet at some point if the linked list has loop.

    why this works ?
    - The slow pointer takes "non-cyclic length" steps to enter the cycle. At this point, the fast pointer has already reached the cycle. Number of iterations=non-cyclic length=N
    - Both pointers are now in the cycle. Consider two runners running in a cycle - the fast runner moves 2 steps while the slow runner moves 1 steps at a time. Since the speed difference is 1, 
    it takes (distance between the 2 runners) / (difference of speed)
    ​loops for the fast runner to catch up with the slow runner.As the distance is at most cyclic length K - 1 and the speed difference is 1, we conclude that
    Number of iterations=at most cyclic length K - 1.

    or 

    - In other words distance between slow, fast pointers decreases by one, in each loop
      so, after some loops they meet each other.
    */

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head, fast = head.next; 

        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast)
            return true;
        return false;
    }
}