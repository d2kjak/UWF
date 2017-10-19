#ifndef linkedQueue
#define linkedQueue
#include <stdio.h>
#include <stdlib.h>

int isEmpty();
void enqueue(int x);
void dequeue();
void display();

typedef struct Node{
   int data;
   struct Node* next;
}queueNode;

queueNode *head; 
queueNode *tail;

#endif