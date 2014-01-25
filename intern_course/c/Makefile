#define compiler and compiler flag variables


CFLAGS = -Wall -c
LFLAGS = 
CC = gcc 

PROG = helloworld

.SUFFIXES: .c .o

.c.o:
	$(CC) $(CFLAGS) $< -o $@

helloworld : helloworld.o
	$(CC) $(LFLAGS) $< -o $@


#default target

default: all

all: $(PROG)

clean:
	$(RM) *.o
	$(RM) $(PROG)

