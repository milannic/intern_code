#define compiler and compiler flag variables

JFLAGS = -g
#JOPFLAGS = -d
JC = javac
#OUTPUTPATH = ./bin

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java $(JOPFLAGS)

CLASSES = \
		  Helloworld.java \
		  UniqueChar.java \
		  Permutation.java \
		  ChangeSpace.java \
		  Line_common.java \
		  Jump.java \
		  WordBreak.java \
		  WordBreak2.java \
		  ReorderList.java \
		  BinaryTreePreorderTraversal.java \
		  BinaryTreePostorderTraversal.java \
		  Sort.java \
		  LinkedListCycle.java \
		  Candy.java \
		  SingleNumber.java \
		  GasStation.java \
		  CopyListRandomP.java \
		  WordsReverse.java \
		  TwoSum.java \
		  FindMedianSortedArrays.java \
		  Triangle.java \


#default target
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

