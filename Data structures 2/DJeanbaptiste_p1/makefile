FLAGS = -g -Wall
CC = gcc

objects = p1.o hashTable.o linkedList.o

Program: $(objects)
	$(CC) $(FLAGS) -o p1 $(objects)

p1.o: p1.c linkedList.h hashTable.h

linkedList.o: linkedList.c linkedList.h 

hashTable.o: hashTable.c hashTable.h linkedList.h

.Clean : clean
clean:
	rm p1 $(objects)
