#include <stdio.h>
#include <stdlib.h>

int isEmpty();
void enqueue(int);
void dequeue();
void display();

//my queue struct function
typedef struct Node{
   int data;
   struct Node* next;
}queueNode;

queueNode *head=NULL;
queueNode *tail=NULL;

//my function to see if the queue is empty
int isEmpty(){
   return (head==NULL);
}

//my function to add to the queue
void enqueue(int x){
   queueNode* temp = (struct Node*)malloc(sizeof(queueNode*));
   temp->data=x;
   temp->next=NULL;
   if(isEmpty()){
      head = tail = temp;
      return;
   }
   else{
      tail->next=temp;
      tail=temp;
   }
   
}

//my function to remove from the queue
void dequeue(){
   queueNode* temp = head;
   if(isEmpty()){
      return;
   }
   if(head==tail){
      head=tail=NULL;
   }
   else{
      head = head->next;
   }
   free(temp);
   
}

void display(){
   queueNode* temp = head;
   while(temp!=NULL){
      printf("data is: %d\n", temp->data);
      temp = temp->next;
   }

}




