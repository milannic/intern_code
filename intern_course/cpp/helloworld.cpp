/*
 * =====================================================================================
 *
 *       Filename:  helloworld.cpp
 *
 *    Description:  Test
 *
 *        Version:  1.0
 *        Created:  03/10/2014 15:51:27
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */

#include <iostream>
#include <stdlib.h>
#include <vector>
#include <stack>
using namespace std;

/* 
 * ===  FUNCTION  ======================================================================
 *         Name:  main
 *  Description:  
 * =====================================================================================
 */

struct TreeNode {
  int val;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
	//leetcode merge sorted array.
    void merge(int A[], int m, int B[], int n) {
		int index1=m-1;
		int index2=n-1;
		if(NULL==A || NULL == B){
			return;
		}
		if (0==m) {
			for ( int i=0; i<n; i++ ) {
				A[i] = B[i];
			}
			return;
		}
		else {
			for(int i=m+n-1;i>=0;i--){
				if(index1<0 || index2<0){break;}
				if(A[index1]>B[index2]){
					A[i] = A[index1];
					index1--;
				}
				else{
					A[i] = B[index2];
					index2--;
				}
			}
			if(index1<0){
				for (; index2>=0; index2--) {
					A[index2] = B[index2];
				}
			}				
			return;
		}
    }
	// leetcode generate pascal triangle
    vector<vector<int> > pascalGenerate(int numRows) {
		vector<vector<int> > solution;
		if(numRows!=0){
			vector<int>* my_vector = new vector<int>();
			my_vector->push_back(1);
			solution.push_back(*(my_vector));
			for(int i=1;i<numRows;i++){
				my_vector = new vector<int>();
				for(int j=0;j<=i;j++){
					if(j==0){
						my_vector->push_back(1);
					}else if(j==i){
						my_vector->push_back(1);
					}else{
						my_vector->push_back(solution.at(i-1).at(j-1)+solution.at(i-1).at(j));
					}
				}
				solution.push_back(*(my_vector));
			}
		}
		return solution;
    }
	// pascal triangle 2
    vector<int> getRow(int rowIndex) {
		vector<int> solution;
			if(rowIndex==0){
				solution.push_back(1);
			}
			else if(rowIndex==1){
				solution.push_back(1);
				solution.push_back(1);
			}else{
				int row1[rowIndex];
				int row2[rowIndex];
				for(int i=0;i<=rowIndex;i++){
					if(i%2==0){
						for(int j=0;j<=i;j++){
							if(j==0){
								row2[j] = 1;
							}else if(j==i){
								row2[j] = 1;
							}else{
								row2[j] = row1[j-1]+row1[j];
							}
						}
					}else{
						for(int j=0;j<=i;j++){
							if(j==0){
								row1[j] = 1;
							}else if(j==i){
								row1[j] = 1;
							}else{
								row1[j] = row2[j-1]+row2[j];
							}
						}
					}
				}
				if(rowIndex%2==0){
					for(int i=0;i<=rowIndex;i++){
						solution.push_back(row2[i]);
					}
				}else{
					for(int i=0;i<=rowIndex;i++){
						solution.push_back(row1[i]);
					}

				}
			}
		return solution;
    }


    bool hasPathSum(TreeNode *root, int sum) {
		if(root==NULL){
			return false;
		}
		else{
			int temp_sum=root->val;
			TreeNode* previous=NULL;
			TreeNode* cur=NULL;
			stack<TreeNode*> my_stack;
			my_stack.push(root);
			while(!my_stack.empty()){
				cur = my_stack.top();
				if(temp_sum==sum && cur->left==NULL && cur->right==NULL){
					return true;
				}
				//leaf node
				if(cur->left!=NULL && previous!=cur->left && (!(previous == cur->right && cur->right != NULL))){
						my_stack.push(cur->left);
						temp_sum += cur->left->val;

				}else if(cur->right!=NULL && previous != cur->right){
					my_stack.push(cur->right);
					temp_sum += cur->right->val;
				}else{
					temp_sum -= cur->val;
					previous = my_stack.top();
					my_stack.pop();
				}
			}
			return false;
		}
    }
};

int
main ( int argc, char *argv[] )
{
	Solution* my_solution = new Solution();
	stack<TreeNode> my_stack;
	TreeNode* tree1 = new TreeNode(1);
	TreeNode* tree2 = new TreeNode(-2);
	TreeNode* tree3 = new TreeNode(3);
	tree1->left = tree2;
	tree1->right = tree3;
	std::cout<<my_solution->hasPathSum(tree1,2)<<endl;

	return EXIT_SUCCESS;
}				/* ----------  end of function main  ---------- */


