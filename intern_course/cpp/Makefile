#define compiler and compiler flag variables


CFLAGS = -Wall -c
LFLAGS = 
CC = g++

PROG = helloworld 

.SUFFIXES: .cpp .o

.cpp.o:
	$(CC) $(CFLAGS) $< -o $@

default: all

all: $(PROG)

helloworld : helloworld.o
	$(CC) $(LFLAGS) $< -o $@

#default target

clean:
	$(RM) *.o
	$(RM) $(PROG)

