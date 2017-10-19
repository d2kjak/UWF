#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <math.h>
#include "poissonDistribution.h"
#include "linkedQueue.h"

#define SIZE 200
void initPQ();
void createCustomer();

/*************************************************************************************
*This is my PQ class which contains my customers and priority queue list
*************************************************************************************/
//struct for customers
struct customer{
   double pqTime;
   double arrivalTime;
   double startOfServiceTime;
   double departureTime;
   struct customer *nextCust; //fifo queue link
};

struct customer pQueue[SIZE+2];
   
//function to initialize the priority queue by setting everything to 0;
void initPQ(){
   int i;
   for(i=0;i<SIZE; i++){
      pQueue[i].pqTime = 0;
      pQueue[i].arrivalTime = 0;
      pQueue[i].startOfServiceTime = 0;
      pQueue[i].departureTime = 0;
   }
}


void createCustomer(){
   
}



/*
//main function to test current values in the priority queue
int main(int argc, char** argv) {

   pQueue[1].pqTime = 1.5;
   pQueue[2].pqTime = 1.8;
   pQueue[5].pqTime = 3.5;
   pQueue[1].departureTime = 2.6;
   pQueue[2].departureTime = 3.3;
   pQueue[7].departureTime = 2.8;
   displayPQ();
   void displayPQ();
   
   return (EXIT_SUCCESS);
}
*/