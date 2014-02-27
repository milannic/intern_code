class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
	  val = x;
	  next = null;
  }
}
public class ReorderList{
    public void reorderList(ListNode head) {
		if(head==null)
			return;
		if(head.next==null||head.next.next==null)
			return;
		ListNode cur_1x=head;
		ListNode cur_2x=head;
		while(cur_2x!=null&&cur_2x.next!=null){
			cur_2x=cur_2x.next.next;
			cur_1x=cur_1x.next;
		}
		//it means the length of the linklist is odd
		// 1->2->3->4->5->6 2x
		//          1x
		if(cur_2x==null){
		}else{
		//it means the length of the linklist is even
		// 1->2->3->4->5->6->7
		//          1x		2x
		   cur_1x = cur_1x.next;
		}
		cur_2x=head;
		ListNode previous_node = cur_1x;
		cur_1x=cur_1x.next;
		ListNode temp_node = cur_1x;
		ListNode temp_node2 = cur_2x;
		previous_node.next = null;
		while(cur_1x!=null){
			temp_node = cur_1x.next;
			cur_1x.next = previous_node;
			previous_node=cur_1x;
			cur_1x=temp_node;
		}
		//if there are only three nodes;
		cur_1x=previous_node;
		while(cur_1x!=null){
			temp_node=cur_1x.next;
			temp_node2=cur_2x.next;
			cur_2x.next = cur_1x;
			cur_1x.next=temp_node2;
			cur_1x=temp_node;
			cur_2x=temp_node2;
		}
		if(cur_2x!=null){
			cur_2x.next=null;
		}
    }
	public static void main(String[] args){
		System.out.println("hahaha\n");
	
	
	}
}
