CC=gcc
CFLAGS=-c -Wall -g
LDFLAGS= -lm
FILE= car_1

all: ${FILE}

${FILE}: ${FILE}_harness.o ${FILE}.o
	$(CC) $(LDFLAGS) ${FILE}_harness.o ${FILE}.o -o ${FILE}

${FILE}_harness.o: ${FILE}_harness.c
	$(CC) $(CFLAGS) ${FILE}_harness.c

${FILE}.o: ${FILE}.c
	$(CC) $(CFLAGS) ${FILE}.c

clean:
	rm -rf *o ${FILE}
