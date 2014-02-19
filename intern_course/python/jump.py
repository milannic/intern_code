#! /usr/local/bin/python

class Solution:

    # @param A, a list of integers
    # @return a boolean

    def canJump(self, A):
        if A==None:
            return False
        if len(A) == 1:
            return True
        if A[0] == 0:
            return False
        for i in A:
            if i < 0:
                return False
        position = 0;
        while A != None:
            if position == len(A)-1 :
                return True
            if A[position] !=0:
                position += 1
            else:

                curr = position - 1
                while curr != -1 :
                    if curr + A[curr] >= position:
                        A[curr] = A[curr]-1;
                    curr -= 1
                del A[position]
                position = 0
                if A[0] == 0:
                    return False
                
        if A == None:
            return False
