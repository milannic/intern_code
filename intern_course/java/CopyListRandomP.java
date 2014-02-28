import java.util.*;
class RandomListNode {
  int label;
  RandomListNode next, random;
  RandomListNode(int x) { this.label = x; }
};
public class CopyListRandomP{
/* this method exceeds the time limit  which is O(n^2) with no extra space use
    public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null){return null;}
		RandomListNode head_new = null;
		RandomListNode cur_new = null;
		RandomListNode cur = head;
		RandomListNode head_loop=null;
		RandomListNode head_new_loop=null;
		RandomListNode temp_node = null;
		//at first we initialize all the fields other then the random fields.
		while(cur!=null){
			if(cur_new==null){
				head_new = new RandomListNode(cur.label);
				cur_new = head_new;
			}else
			{
				cur_new.next = new RandomListNode(cur.label);
				cur_new = cur_new.next;
			}
			cur=cur.next;
		}
		//now copy the random fields.
		cur_new = head_new;
		cur = head;
		//use the traverse from the head of the loop
		head_loop = head;
		head_new_loop = cur_new;
		while(cur_new!=null){
			temp_node = cur.random;
			if(temp_node==null){cur_new.random=null;}
			else{
				while(head_loop!=temp_node&&head_loop!=null){
					head_loop=head_loop.next;
					head_new_loop=head_new_loop.next;
				}
				if(head_loop!=null){
					cur_new.random = head_new_loop;
				}
				else{
					cur_new.random = null;
				}
			}
			cur_new=cur_new.next;
			cur=cur.next;
			head_loop = head;
			head_new_loop = head_new;
		}
		return head_new;
    }
*/
/*
    public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null){return null;}
		Hashtable<RandomListNode,RandomListNode> hash_table = new Hashtable<RandomListNode,RandomListNode>();
		RandomListNode cur=null;
		RandomListNode cur_new=null;
		RandomListNode head_new=null;
		cur = head;
		while(cur!=null){
			if(cur_new == null){
				head_new = new RandomListNode(cur.label);
				cur_new = head_new;
			}else{
				cur_new.next = new RandomListNode(cur.label);
				cur_new = cur_new.next;
			
			
			}
			hash_table.put(cur,cur_new);
			cur=cur.next;
		}
		cur = head;
		cur_new = head_new;
		while(cur!=null){
			if(cur.random==null){
				cur_new.random = null;
			}else{
				cur_new.random = hash_table.get(cur.random);
			}
			cur = cur.next;
			cur_new = cur_new.next;
		}
		return head_new;
    }
*/
// we can still use no extra space method
    public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null){return null;}
		RandomListNode cur=null;
		RandomListNode cur_new=null;
		RandomListNode head_new=null;
		cur = head;
		// in this loop we insert each copy node following the original node;
		while(cur!=null){
			cur_new = new RandomListNode(cur.label);
			cur_new.next = cur.next;
			cur.next = cur_new;
			cur = cur_new.next;
		}
		cur = head;
		head_new = head.next;
		
		while(cur!=null){
			if(cur.random==null){
				cur.next.random = null;
			}else
			{
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		//then we restore it
		cur = head;
		cur_new = head_new;	
		while(cur!=null){
			cur.next = cur.next.next;
			cur = cur.next;
			if(cur_new.next!=null){
				cur_new.next = cur_new.next.next;
				cur_new = cur_new.next;
			}
		}
		
		return head_new;
    }
	public static void main(String[] args){
			RandomListNode head = new RandomListNode(-1);
			RandomListNode node_2 = new RandomListNode(8);
			RandomListNode node_3= new RandomListNode(7);
			RandomListNode node_4 = new RandomListNode(-3);
			RandomListNode node_5 = new RandomListNode(4);

		System.out.println("hahaha");
	
	}
}
