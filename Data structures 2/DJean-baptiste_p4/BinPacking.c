#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include "BinPacking.h"



//Link* initLink(int);
//AdjList* initAdjList(int);


/******************************************************************************************************************
*My structs for my Bin packing class
*******************************************************************************************************************/
typedef struct LinkList{
   double value;
   struct LinkList* next;
}Link;

typedef struct AdjListNode{
   double val;
   double totalWeight;
   struct LinkList* next;
   struct AdjListNode* down;  
}AdjList;

/******************************************************************************************************************
*My initialization for my link list
*******************************************************************************************************************/
Link* initLink(double num){
   Link* temp;
   temp = (Link*)malloc(sizeof(struct LinkList)*max);
   temp->value = num;
   temp->next = NULL;
   return temp;
}

/******************************************************************************************************************
*My initialization for my adjacency list
*******************************************************************************************************************/
AdjList* initAdjList(double num){
   AdjList* temp;
   temp = (AdjList*)malloc(sizeof(struct AdjListNode));
   temp->val = num;
   temp->totalWeight = temp->val;
   temp->next = NULL;
   temp->down = NULL;
   return temp;
}


/******************************************************************************************************************
*My method to read the items into and array to bin pack them
*******************************************************************************************************************/
void readBinInfo(){
   FILE *fPointer;
   int i;
   int counter = 0;
   fPointer = fopen("items.txt", "r");
   fscanf(fPointer, "%d", &max);
   if(fPointer == NULL){
      printf("Error");
      exit(1);
   }
   double temp;
   while(!feof(fPointer)){
    fscanf(fPointer, "%lf", &temp);
    counter++;
   }
   count = counter;
   printf("count = %d \n", count);
    printf("max = %d \n", max);
   item = (double *)malloc(sizeof(double) * count);
   tempItem = (double *)malloc(sizeof(double) * count);
   rewind(fPointer);
   fscanf(fPointer, "%d", &max);
   for(i=0;i<counter;i++){

      fscanf(fPointer, "%lf", &item[i]);
      tempItem[i]=item[i];
   }
   fclose(fPointer);
}





void printItems(double item[], int count){
   int i;
   for(i=0; i<count; i++){
      printf("\nprintItem = %.6lf\n", item[i]);
   }
}

/******************************************************************************************************************
*My sorting method for offline
*******************************************************************************************************************/
void sort(double tempItem[], int count){
   int i, j, temp;
   for(i=0; i<count; i++){
      for(j=i+1; j<count; j++){
         if(tempItem[i] < tempItem[j]){
            temp = tempItem[i];
            tempItem[i] = tempItem[j];
            tempItem[j] = temp;
         }
      }
   }
}


void printTempItems(double tempItem[], int count){
   int i;
   for(i=0; i<count; i++){
      printf("\nprintTempItem = %.6lf\n", tempItem[i]);
   }
}



/******************************************************************************************************************
*My help method to store the items into the current bin
*******************************************************************************************************************/
void addToCurrentBin(double item, AdjList *currentBin){
   Link *newLink = initLink(item);
   Link *currentLink = currentBin->next;
   if(currentBin->next == NULL){
      currentBin->next = newLink;
   }
   else{
      while(currentLink->next !=NULL){
         currentLink = currentLink->next;
      }
      currentLink->next = newLink;
   }
   currentBin->totalWeight +=item;
   //printf("\ntotalWeight is: %.6lf\n", currentBin->totalWeight);
   
}


/******************************************************************************************************************
*My help method to add item through next fit method
*******************************************************************************************************************/
AdjList* addNextFit(double item, AdjList* currentBin){
   
   if(max-(currentBin->totalWeight + item)>= 0){
      addToCurrentBin(item, currentBin);
      return currentBin;
   }
   else{
      currentBin->down=initAdjList(item);
      return currentBin->down;
   }
}


/******************************************************************************************************************
*My next fit method
*******************************************************************************************************************/
int nextFit(double Link[], int count){
   int i, length=0;
   AdjList* temp;
   AdjList* rootbin = initAdjList(Link[0]);
   AdjList* currentBin = rootbin;
   temp = currentBin;
   for(i=1; i<count; i++){
      currentBin = addNextFit(Link[i], currentBin);
   }
   while(temp != NULL){
      length++;
      temp = temp->down;
   }
   return length;
   
}

/******************************************************************************************************************
*My help method to add items into first fit bin
*******************************************************************************************************************/
AdjList* addFirstFit(double item, AdjList* rootBin /*currentBin*/){
   AdjList *tempBin = rootBin;
   
   if(max-(rootBin->totalWeight + item) >= 0){
      addToCurrentBin(item, rootBin);
   }
   else{
      //tempBin->down = initAdjList(item);
      if(rootBin->down == NULL){
         rootBin->down = initAdjList(item);
      }
      else if(rootBin->down != NULL){
         tempBin = tempBin->down;
         if(max-(tempBin->totalWeight + item) >=0){
            addToCurrentBin(item, tempBin);
         }
      }
      
   }
   return rootBin;
}

/******************************************************************************************************************
*My first fit method
*******************************************************************************************************************/
int firstFit(double Link[], int count){
   int i, length=0;
   AdjList* rootbin = initAdjList(Link[0]);
   AdjList* currentBin = rootbin;
   AdjList* temp = currentBin;
   for(i=1; i<count; i++){
      currentBin = addFirstFit(Link[i], currentBin);
   }
   while(temp != NULL){
      length++;
      temp = temp->down;
   }
   return length;
   
}


/******************************************************************************************************************
*My main
*******************************************************************************************************************/
int main(int argc, char** argv) {

      readBinInfo();
      //printItems(item, count); 
      //printTempItems(item, count);
      int bin = nextFit(item, count);
      int fBin = firstFit(item, count);
      printf("\nnumber of bin for nextFit is %d\n", bin);
      printf("\nnumber of fBin for firstFit is %d\n", fBin);
   return (EXIT_SUCCESS);
}
