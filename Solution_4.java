/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.BigInteger;

class Solution_4 {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = "";
        String num2 = "";
        
        ListNode temp = l1;
        int node_no = 0;

        while(temp != null && isNum(temp)){
            num1 = temp.val + num1;
            temp = temp.next;
            node_no++;
            if(node_no > 100){
                return null;
            }
        }
        
        temp = l2;
        node_no = 0;
        while(temp != null && isNum(temp)){
            num2 = temp.val + num2;
            temp = temp.next;
            node_no++;
            if(node_no > 100){
                return null;
            }
        }
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        
        String result = (n1.add(n2)).toString();
        if(result.length() > 0){
            ListNode l3 = new ListNode(Integer.parseInt(result.charAt(0)+""));
            for(int i=1; i<result.length(); i++){
                ListNode t = new ListNode(Integer.parseInt(result.charAt(i)+""));
                t.next = l3;
                l3 = t;
            } 
            return l3;
        }
        return null;
    }
    private boolean isNum(ListNode node){
        return (0 <= node.val && node.val <= 9);
    }
}