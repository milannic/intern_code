import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> my_stack = new Stack<TreeNode>();
		ArrayList<Integer> res_list = new ArrayList<Integer>();
		TreeNode cur=null;
		if(root!=null){
			my_stack.push(root);
			while(my_stack.empty()!=true){
				cur = my_stack.pop();
				res_list.add(new Integer(cur.val));
				if(cur.right!=null){
					my_stack.push(cur.right);
				}
				if(cur.left!=null){
					my_stack.push(cur.left);
				}
			}
		}
		return res_list;
    }
	public static void main(String[] args){
		System.out.println("hahah\n");
	}
}
