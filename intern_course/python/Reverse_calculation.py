#! /usr/bin/python

import sys
import math

def evalRPN(tokens):
		a = []
		number1 = 0
		number2 = 0
		if len(tokens) == 0:
			return None
		else:
			for i in tokens:
				if i == '+':
					#if there is not enough operation word in the stack, then return error
					if len(a)<2 :
						raise Exception("input error")
					else:
						number2 = a.pop()
						number1 = a.pop()
						a.append(number1+number2)
                                            
				elif i == '-':
					if len(a)<2 :
						raise Exception("input error")
					else:
						number2 = a.pop()
						number1 = a.pop()
						a.append(number1-number2)
				elif i == '*':
					if len(a)<2 :
						raise Exception("input error")
					else:
						number2 = a.pop()
						number1 = a.pop()
						a.append(number1*number2)
				elif i == '/':
					if len(a)<2 :
						raise Exception("input error")
					else:
						number2 = a.pop()
						number1 = a.pop()
						a.append(int((float(number1)/float(number2))))
				else:
					a.append(int(i))
			if len(a) != 1: 
				raise Exception("input error")
			return a.pop()



if __name__ == '__main__':
	print evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"])
