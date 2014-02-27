import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> my_stack = new Stack<TreeNode>();
		ArrayList<Integer> res_list = new ArrayList<Integer>();
		TreeNode cur=null;
		TreeNode previous=null;
		if(root!=null){
			my_stack.push(root);
			while(my_stack.empty()!=true){
				cur = my_stack.peek();
				//System.out.println(cur.val);
				// when to output a node? leaf node, all the children are null
				// when the left subtree has been traversed while it has no right subtree
				// when the right subtree has been traversed.
				if((cur.left==null && cur.right==null)||(previous==cur.right&&cur.right!=null)||(cur.left==previous&&cur.left!=null)){
					cur = my_stack.pop();
					//System.out.println(cur.val);
					res_list.add(new Integer(cur.val));
					previous = cur;
				}else{
				if(cur.right!=null){
					my_stack.push(cur.right);
				}
				if(cur.left!=null){
					my_stack.push(cur.left);
				}
				}
			}
		}
		return res_list;
    }
	public static void main(String[] args){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		a.left=b;
		ArrayList<Integer> test = new BinaryTreePostorderTraversal().postorderTraversal(a);
		for(Integer num : test){
			System.out.println(num);
		}
	}
}
