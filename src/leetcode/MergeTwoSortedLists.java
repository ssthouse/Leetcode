package leetcode;

/* Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
/* 1 The key to solve the problem is defining a fake head. Then compare the first elements from each list. 
 * 2 Add the smaller one to the merged list. 
 * 3 Finally, when one of them is empty, simply append it to the merged list, since it is already sorted.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode newhead = new ListNode(0);
		ListNode p = newhead;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				p.next = l2;
				l2 = l2.next;
			} else {
				p.next = l1;
				l1 = l1.next;
			}
			p = p.next;
		}
		if (l1 == null)
			p.next = l2;
		else
			p.next = l1;
		return newhead.next;
	}

    /***********************************************************************************/

    public ListNode getMergedList(ListNode fistHead, ListNode secNode) {
        //最后返回  head的下一个节点
        ListNode head = new ListNode(-1);
        //
        ListNode tempNode = head;
        while (fistHead != null && secNode != null) {
            if (fistHead.val < secNode.val) {
                tempNode.next = fistHead;
                fistHead =fistHead.next;
                tempNode = tempNode.next;
            }else{
                tempNode.next = secNode;
                secNode = secNode.next;
                tempNode = tempNode.next;
            }
        }
        if(fistHead != null){
            tempNode.next = fistHead;
        }
        if (secNode != null) {
            tempNode.next = secNode;
        }
        return head.next;
    }

    public static void main(String[] args) {
        //初始话两个测试用数据
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(0);
        ListNode tempNode = head1;
        for (int i = 1; i < 5; i++) {
            tempNode.next = new ListNode(i*2+1);
            tempNode = tempNode.next;
        }
        tempNode = head2;
        for (int i = 1; i < 5; i++) {
            tempNode.next = new ListNode(i*2);
            tempNode = tempNode.next;
        }
        //初始话测试类
        MergeTwoSortedLists test = new MergeTwoSortedLists();
        ListNode newHead = test.getMergedList(head1, head2);
        //输出查看结果
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}