#! /usr/local/bin/python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    # @param head, a ListNode
    # @return a ListNode
    def sortList(self, head):
        if head == None:
            return head 
        if head.next == None:
            return head
        if head.next.next == None:
            if head.val > head.next.val:
                temp_val = head.val
                head.val = head.next.val
                head.next.val = temp_val
            return head
        pointer_1x = head
        pointer_2x = head
        # we go to the last of the singly linklist.
        while pointer_2x != None and pointer_2x.next != None:
            pointer_2x = pointer_2x.next.next
            pointer_1x = pointer_1x.next
        #de-link
        pointer_2x = pointer_1x
        pointer_1x = pointer_1x.next
        pointer_2x.next = None
        mysolution = Solution()
        new_head1 = mysolution.sortList(head)
        new_head2 = mysolution.sortList(pointer_1x)
        startflag = False
        while new_head1 != None and new_head2 != None:
            if new_head1.val < new_head2.val :
                if startflag == False :
                    new_head = new_head1
                    startflag = True
                    current_pointer = new_head
                else :
                    current_pointer.next = new_head1
                    current_pointer = new_head1
                new_head1 = new_head1.next
            else:
                if startflag == False :
                    new_head = new_head2
                    startflag = True
                    current_pointer = new_head
                else :
                    current_pointer.next = new_head2
                    current_pointer = new_head2
                new_head2 = new_head2.next
        if startflag == False:
            if new_head1 == None:
                return new_head2
            else:
                return new_head1
        else:
            if new_head1 == None:
                current_pointer.next = new_head2
            else :
                current_pointer.next = new_head1
                
        return new_head
