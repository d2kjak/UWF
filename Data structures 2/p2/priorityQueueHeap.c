#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <math.h>

#define SIZE 200
void displayPQ();

//void createHeap();
//void insert(Element);

int main(int argc, char** argv) {

   void displayPQ();
   
   return (EXIT_SUCCESS);
}

struct customer{
   double pqTime;
   double arrivalTime;
   double startOfServiceTime;
   double departureTime;
   struct customer *nextCust; //fifo queue link
}custP*;

custP* pQueue[SIZE+2];
   

void initPQ(){
   custP* pQueue;
}





pQueue[1]->pqTime = 1.5;
pQueue[2].pqTime = 1.8;
pQueue[5].pqTime = 3.5;
pQueue[1].departureTime = 2.6
pQueue[2].departureTime = 3.3
pQueue[7].departureTime = 2.8






void displayPQ(){
   for(int i=0; i<8;i++){
      printf("\npqTime is: %.1lf and departureTime is: %.1lf \n", pQueue[i].pqTime, pQueue[i].departureTime);
   }
}

/*
void initializePQueue(CustP *cp){
   CustP* pQueue = (CustP*)malloc(sizeof(CustP*) * SIZE);
}*/