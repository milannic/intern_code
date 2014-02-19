#! /usr/local/bin/python


class Solution:
    # @param ratings, a list of integer
    # @return an integer
    def candy(self, ratings):
        if ratings == None:
            return None
        length = len(ratings)
        if len(ratings) == 1:
            return 1
        A = [0]*length
        first_maximum_curr = 0
        last_maximum_curr = 0
        A[0] = 1
        curr = 0
        flag = 0
        while curr<length-1 and ratings[curr] == ratings[curr+1] :
            A[curr+1] = A[curr]
            curr +=1
        if curr == length-1:
            return sum(A)
        if ratings[curr] > ratings[curr+1]:
            flag = -1
        else:
            flag = 1
        while curr < length:
            # if down steaming
            if ratings[curr] > ratings[curr+1] :
                #set the flag
                flag = 0
                #just deduce
                A[curr+1] = A[curr]-1
            # if up steaming
            elif ratings[curr] < ratings[curr+1]:
                #if current upsteaming
                if flag == 1:
                    #renew the interval
                    first_maximum_curr = curr+1
                    last_maximum_curr = curr+1
                else:
                #if current downsteaming
                # if current value are negative,restore it and the maximum interval
                    if A[curr] <= 0:
                        counter_part = 1-A[curr]
                        for i in range(first_maximum_curr,curr+1):
                            A[i] += counter_part
                    # else we can optimize it
                    elif A[curr] > 1:
                        counter_part = A[curr] - 1
                        for i in range(last_maximum_curr+1,curr+1):
                            A[i] -= counter_part
                    first_maximum_curr = curr+1
                    last_maximum_curr = curr+1
                    flag = 1
                #renew the value
                A[curr+1] = A[curr]+1
            #else are equal
            else:
                #if current are up steaming
                if flag == 1:
                    last_maximum_curr = curr+1
                #if current are down steaming
                A[curr+1] = A[curr]
            curr += 1
        if A[curr-1] <=0 :
            counter_part = 1-A[curr-1]
            for i in range(first_maximum_curr,curr):
                A[i] += counter_part
        elif flag == -1 and A[curr-1] != 1 :
            counter_part = A[curr-1] - 1
            for i in range(last_maximum_curr+1,curr):
                A[i] -= counter_part
        return sum(A)
                

        
