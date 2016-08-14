package leetcode;

/* Sort a linked list using insertion sort.
 */
public class _InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode helper = new ListNode(0);
		ListNode pre = helper;
		ListNode cur = head;
		while (cur != null) {
			pre = helper;
			while (pre.next != null && pre.next.val <= cur.val) {
				pre = pre.next;
			}
			
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return helper.next;
	}


    /**************************************************************/

    public ListNode sort(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode beforeHeadNode = new ListNode(-1);
        ListNode tempNode = beforeHeadNode;
        ListNode curNode = head;
        while (curNode != null) {
            tempNode = beforeHeadNode;
            //找到插入的前一个节点
            while (tempNode.next != null && tempNode.next.val < curNode.val) {
                tempNode = tempNode.next;
            }
            //插入新节点
            ListNode next = curNode.next;//保存查找的下一个节点
            curNode.next = tempNode.next;//插入的节点的后面变成已经排序的结Ian的后面
            tempNode.next = curNode;//将插入位置节点的后面变成找到的节点
            curNode = next;//指向下一个节点
        }
        return beforeHeadNode.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        ListNode tempNode = head.next;
        tempNode.next = new ListNode(8);
        tempNode = tempNode.next;
        tempNode.next = new ListNode(2);
        tempNode = tempNode.next;
        tempNode.next = new ListNode(9);
        //创建测试对象
        _InsertionSortList test = new _InsertionSortList();
        ListNode newHead = test.sort(head);
        while (newHead != null) {
            System.out.print(newHead.val+"   ");
            newHead = newHead.next;
        }
    }
}
