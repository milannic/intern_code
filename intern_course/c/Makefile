#define compiler and compiler flag variables


CFLAGS = -Wall -c
LFLAGS = 
CC = gcc 

PROG = helloworld reverse

.SUFFIXES: .c .o

.c.o:
	$(CC) $(CFLAGS) $< -o $@

default: all

all: $(PROG)

helloworld : helloworld.o
	$(CC) $(LFLAGS) $< -o $@

reverse : reverse.o
	$(CC) $(LFLAGS) $< -o $@


#default target



clean:
	$(RM) *.o
	$(RM) $(PROG)

