//#include "linkedList.c"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "hashTable.h"


typedef struct linkListHash{
   char *fWords;
   struct linkListHash *next;
} List;

typedef struct hashTable{
   List **table;
}hashT;



List *initializeNode(char *stringToAdd)
{
   List *temp;
   temp = (List *) malloc (sizeof(struct linkListHash));
   if(temp== NULL)
   {
      return NULL;
   }
   temp->next = NULL;
   strcpy(temp->fWords, stringToAdd);
   return temp;
}


/*
*hashT *hTable;
*int tableSize = what? 5003?
*hTable = createHashTable(tableSize);
*/
hashT *initTable(){
   hashT *temp;
   int i;
   
   if((temp = malloc(sizeof(hashT))) == NULL){
      return NULL;
   }
   if((temp->table = malloc(sizeof(List*)*TABLESIZE))==NULL){
      return NULL;
   }
   for(i=0; i<TABLESIZE; i++){
      temp->table[i] = NULL;
   }
   
   
   return temp;
   
}



hashT *createHashTable(char **stringArray, int arrayCount, int phraseSize){
   hashT *tmpTable;
   
   //allocate memory for table
   tmpTable = initTable();
   int i, j;
   char tempBuffer[300];
   for(i = 0; i < arrayCount - phraseSize + 1; i++)
   {
      
      strcpy(tempBuffer, "");
      for(j = 0; j < phraseSize; j++)
      {
         strcat(tempBuffer, stringArray[i + j]);
      }
      add(tmpTable, tempBuffer);
      //bzero(tempBuffer);
   }
   
   
}
int hash(char *stringToHash){
   char *temp = stringToHash;
   
   int value=1;
   int i=1;
   while(temp != NULL){
      value += (i+1) * (*temp);
      i++;
      temp++;
   }
   return value %= TABLESIZE;

   
}

void add(hashT *hashTable, char *stringToAdd){
   int key = hash(stringToAdd);
   List *tempPtr = initializeNode(stringToAdd);
   tempPtr->next = hashTable->table[key];
   hashTable->table[key] = tempPtr;
}

int find(hashT *hashTable, char *stringToAdd){
   int count=0;
   int key = hash(stringToAdd);
   List *currentPtr = hashTable->table[key];
   while(currentPtr != NULL){
      if(strcmp(stringToAdd, currentPtr->fWords) !=0){
         currentPtr = currentPtr->next;
      }
      else{
         count++;
      }
      return count;
   }
}

void freeTable(hashT *hashTable){
   int i;
   List *list, *temp;
   
   if(hashTable == NULL){
      return;
   }
   
   for(i=0; i<TABLESIZE; i++){
      list = hashTable->table[i];
      while(list != NULL){
         temp = list;
         list = list->next;
         free(temp->fWords);
         free(temp);
      }
   }
   free(hashTable->table);
   free(hashTable);
}