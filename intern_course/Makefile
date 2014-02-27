#define compiler and compiler flag variables

JFLAGS = -g
JOPFLAGS = -d
JC = javac
SRCPATH = ./src/
OUTPUTPATH = ./bin

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $(SRCPATH)*.java $(JOPFLAGS) $(OUTPUTPATH)

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


#default target
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

