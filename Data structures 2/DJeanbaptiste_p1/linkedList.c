#include "linkedList.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


typedef struct node{
   char info;
   struct node *next;
}Node;


   
Node* initialize(char *fName){
   Node* temp = (Node*)malloc(sizeof(Node));
  	temp->info = fName;
  	temp->next = NULL;
   return temp;
}