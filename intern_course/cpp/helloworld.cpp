/*
 * =====================================================================================
 *
 *       Filename:  helloworld.cpp
 *
 *    Description:  Test
 *
 *        Version:  1.0
 *        Created:  03/10/2014 15:51:27 *       Revision:  none *       Compiler:  gcc *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */

#include <iostream>
#include <stdlib.h>
#include <cstdlib>
#include <vector>
#include <stack>
#include <unordered_set>
#include <unordered_map>
#include <queue>
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
    int ladderLength(string start, string end, unordered_set<string> &dict) {
		if(start.length()!=end.length()){
			return 0;
		}else{
			int depth = 0;
			string cur;
			string temp_string;
			queue<string> BFS_queue;
			unordered_map<string,int> visit;
			BFS_queue.push(start);
			visit.insert(std::make_pair(start,depth));
			//BFS Traverse
			while(!BFS_queue.empty()){
//				cout<<BFS_queue.size()<<endl;
//				cout<<visit.size()<<endl;
				cur = BFS_queue.front();
				BFS_queue.pop();
				depth = visit.find(cur)->second;
//				cout<<cur<<endl;
//				getchar();
				for(unsigned i=0;i<cur.length();i++){
					for(int j=0;j<26;j++){
						temp_string = cur;
						char temp_char = 'a' + j;
						temp_string[i]=temp_char;
						// this node has not been visited and it exists in the dict
						if(temp_string.compare(end)==0){return depth+2;}
						if(visit.find(temp_string)==visit.end() && dict.find(temp_string)!=dict.end()){
							//cout<<"I am here"<<endl;
							//cout<<temp_string<<endl;
							//getchar();
							visit.insert(std::make_pair(temp_string,depth+1));
							BFS_queue.push(temp_string);
						}
					}
				}
			}
			return 0;
		}
    };
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

    vector<vector<int> > pathSum(TreeNode *root, int sum){
		vector<vector <int> > solutions;
		if(root==NULL){
			;
		}
		else{
			vector<int>* temp_solution = new vector<int>();
			vector<int>* temp_solution2=NULL;
			int temp_sum=root->val;
			TreeNode* previous=NULL;
			TreeNode* cur=NULL;
			stack<TreeNode*> my_stack;
			my_stack.push(root);
			temp_solution->push_back(root->val);
			while(!my_stack.empty()){
				cur = my_stack.top();
				if(temp_sum==sum && cur->left==NULL && cur->right==NULL){
					temp_solution2 = new vector<int>();
					*temp_solution2 = *temp_solution;
					solutions.push_back(*temp_solution2);
				}
				//leaf node
				if(cur->left!=NULL && previous!=cur->left && (!(previous == cur->right && cur->right != NULL))){
						my_stack.push(cur->left);
						temp_solution->push_back(cur->left->val);
						temp_sum += cur->left->val;

				}else if(cur->right!=NULL && previous != cur->right){
					my_stack.push(cur->right);
					temp_sum += cur->right->val;
					temp_solution->push_back(cur->right->val);
				}else{
					temp_sum -= cur->val;
					temp_solution->pop_back();
					previous = my_stack.top();
					my_stack.pop();
				}
			}
		}
		return solutions;
	}

    bool isInterleave(string s1, string s2, string s3) {
		return true;
        
    }
    vector<string> wordBreakII(string s, unordered_set<string> &dict) {
		vector<string> result;
		int length = s.length();
		if(s.empty()||dict.empty()){
			return result;
		}
		int** dp_table;
		dp_table = new int*[length];
		for(int i=0;i<length;i++){
			dp_table[i]=new int[length];
		}
		//this loop we find all the substring with length i+1
		for(int i=0;i<length;i++){
			//this loop we iterate all the position with substring length of i+1
			for(int j=0;j+i<length;j++){
				//cout<<s.substr(j,i+1)<<endl;
				if(dict.find(s.substr(j,i+1))!=dict.end()){
					dp_table[j][i] = 1;
				}else{
					for(int k=0;k<i;k++){
						if(dp_table[j][j+k]==1&&dp_table[j+k+1][i-k-1]==1){
							dp_table[j][i] = 1;
							break;
						}
					}
				}
			}
		}
		if(dp_table[0][length-1]!=1){
			return result;
		}else{
			wordBreakFindSolution(0,result,"",s,(int**)dp_table,dict);
			return result;
		}
        
    };
	void wordBreakFindSolution(int index,vector<string>& result,string temp,const string& origin,int** dp_table,unordered_set<string> &dict){
		if((unsigned)index!=origin.length()){
			for(unsigned i=index;i<origin.length();i++){
				if(dp_table[index][i-index]==1){
					if(dict.find(origin.substr(index,i-index+1))!=dict.end()){
						if(index==0){
							wordBreakFindSolution(i+1,result,origin.substr(index,i-index+1),origin,dp_table,dict);
						}else{
							wordBreakFindSolution(i+1,result,temp+" "+origin.substr(index,i-index+1),origin,dp_table,dict);
						}
					}
				}
			}
		}else{
			//cout<<"i am here"<<endl;
			result.push_back(temp);
		}
	}
    bool wordBreakI(string s, unordered_set<string> &dict) {
		int length = s.length();
		if(s.empty()||dict.empty()){
			return false;
		}
		if(dict.find(s)!=dict.end()){
			return true;
		}else{
			int dp_table[length][length];
			//this loop we find all the substring with length i+1
			for(int i=0;i<length;i++){
				//this loop we iterate all the position with substring length of i+1
				for(int j=0;j+i<length;j++){
					//cout<<s.substr(j,i+1)<<endl;
					if(dict.find(s.substr(j,i+1))!=dict.end()){
						dp_table[j][i] = 1;
					}else{
						for(int k=0;k<i;k++){
							if(dp_table[j][j+k]==1&&dp_table[j+k+1][i-k-1]==1){
								dp_table[j][i] = 1;
								break;
							}
						}
					}
				}
			}
			if(dp_table[0][length-1]==1){
				return true;
			}
		}
		return false;
    }
};

int
main ( int argc, char *argv[] )
{
	Solution* my_solution = new Solution();
	// test of string
	string start = "ab";
	unordered_set<string> my_dict;
	my_dict.insert("a");
	my_dict.insert("b");
	vector<string> answer = my_solution->wordBreakII(start,my_dict);
	for(auto i=answer.begin();i!=answer.end();i++){
		cout<<*i<<endl;
	}
	return EXIT_SUCCESS;
}				/* ----------  end of function main  ---------- */


