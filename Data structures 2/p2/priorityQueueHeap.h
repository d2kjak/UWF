#ifndef priorityQueue
#define priorityQueue
#include <stdio.h>
#include <stdlib.h>

void initPQ();
void displayPQ();

struct customer{
   double pqTime;
   double arrivalTime;
   double startOfServiceTime;
   double departureTime;
   struct customer *nextCust;
};

struct customer pQueue[SIZE+2];



#endif