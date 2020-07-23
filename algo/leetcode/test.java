import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Solution21 solution = new Solution21();
        ListNode a = creatListA();
        ListNode b = creatListB();
        ListNode head = solution.mergeTwoLists(a, b);
        System.out.println("return head");

        while (head != null) {
            System.out.print(head.val);
            if(head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
        input.close();
    }

    static ListNode creatListA() {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2, a);
        ListNode c = new ListNode(1, b);
        return c;
    }

    static ListNode creatListB() {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3, a);
        ListNode c = new ListNode(1, b);
        return c;
    }
}