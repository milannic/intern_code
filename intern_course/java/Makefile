#define compiler and compiler flag variables

JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  Helloworld.java \
		  UniqueChar.java 
		  #UniqueChar.java \


#default target
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

