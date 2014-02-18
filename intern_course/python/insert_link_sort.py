#! /usr/local/bin/python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
   def insertionSortList(self, head):
		if head == None or head.next == None:
			return head
	#at first we calculate the length of the linknode
		new_head = head
		new_tail = head
		curr = head.next
		head.next = None
		while curr != None:
			temp_node = curr.next
			if curr.val <= new_head.val:
				curr.next = new_head
				new_head = curr 
			elif curr.val >= new_tail.val:
				new_tail.next = curr
				new_tail = curr 
				curr.next = None
			else:
				pointer = new_head
				while pointer != None and curr.val > pointer.val:
					curr.next = pointer 
					pointer = pointer.next
				curr.next.next = curr
				curr.next = pointer
			curr = temp_node
		return new_head






