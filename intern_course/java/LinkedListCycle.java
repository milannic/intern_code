class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
	  val = x;
	  next = null;
  }
}
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null)
		{return false;}
		ListNode cur_2x = head;
		cur_2x=cur_2x.next.next;
		head=head.next;
		while(cur_2x!=null&&cur_2x.next!=null){
			if(cur_2x==head){return true;}
			cur_2x=cur_2x.next.next;
			head=head.next;
		}
		return false;
        
    }
    public ListNode hasCycle2(ListNode head) {
		ListNode cur_1x;
		cur_1x=head;
		if(cur_1x==null||cur_1x.next==null)
		{return null;}
		ListNode cur_2x = cur_1x;
		cur_2x=cur_2x.next.next;
		cur_1x=cur_1x.next;
		while(cur_2x!=null&&cur_2x.next!=null){
			if(cur_2x==cur_1x){break;}
			cur_2x=cur_2x.next.next;
			cur_1x=cur_1x.next;
		}
		if(cur_2x==null||cur_2x.next==null){return null;}
		while(head!=cur_2x){
			head=head.next;
			cur_2x=cur_2x.next;
		}
		return head;
    }
	public static void main(String[] args){
		System.out.println("hahaha");
	}
}
