import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Solution21 solution = new Solution21();
        ListNode a = creatListA();
        ListNode b = creatListB();
        ListNode c = solution.mergeTwoLists(a, b);
        System.out.println(a.val);
        a = a.next;
        while (a != null) {
            System.out.print("->");
            a = a.next;
            System.out.print(a.val);
        }
        System.out.println();
        input.close();
    }

    static ListNode creatListA() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2, a);
        ListNode c = new ListNode(4, b);
        return a;
    }

    static ListNode creatListB() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3, a);
        ListNode c = new ListNode(4, b);
        return a;
    }
}