#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <math.h>
#include "poissonDistribution.h"
#include "linkedQueue.h"
#include "priorityQueueHeap.h"
#include "events.h"

double factorial(int);
double powerFunction(double, double);
double summationFunc(int, int, int);
double percentIdleTime(int, int, int);
double avgNumOfPeopleInSystem(int, int, int);
double avgTimeCustomerSpendsInSystem(int, int, int);
double avgNumOfCustomersInQueue(int, int, int);
double avgTimeCustomerSpendsWaitingInQueue(int, int, int);
double utilizationFactorForSystem(int, int, int);
double getNextRandomInterval(double);

/*
*Project 2 Programmed by Delikarl Jean-baptiste
*
*/

/*************************************************************************************
*This is my main function for the that will print out the results from each equation
*************************************************************************************/
int main(int argc, char** argv) {
   
   int n;
   int l=2;
   int m=3;
   int bigM=2;
   double getPo = percentIdleTime(l, m, bigM); //this is to get percent idle time
   double getL = avgNumOfPeopleInSystem(l, m, bigM); //this is to get average number of people in the system
   double getW = avgTimeCustomerSpendsInSystem(l, m, bigM); //this is to get the average time a customer spends in the system
   double getLq = avgNumOfCustomersInQueue(l, m, bigM); //this is to get the average number of people in the queue
   double getWq = avgTimeCustomerSpendsWaitingInQueue(l, m, bigM); //this is to get the average time a customer spends waiting in the queue
   /*printf("\nwhat is the number of arrivals to simulate? \n");
   scanf("%d", &n);
   printf("\nwhat is the average arrivals in a time period?\n");
   scanf("%d", &l);
   printf("\nwhat is the average number served in a time period? \n");
   scanf("%d", &m);
   printf("\nwhat is the number of service channels?\n");
   scanf("%d", &bigM);*/
   printf("\nPo = %.4lf ", getPo);
   printf("\nL = %.4lf ", getL);
   printf("\nW = %.4lf ", getW);
   printf("\nLq = %.4lf ", getLq);
   printf("\nWq = %.4lf \n",getWq);
   
      
   return (EXIT_SUCCESS);
}

/*************************************************************************************
*This is my function to calculate factorials
*************************************************************************************/
double factorial(int x){
   double a;
   if(x==0){
      a=1;
   }
   else{
      a = x*factorial(x-1);
   }
   return a;
}

/*************************************************************************************
*This is my math function to get the result of a "power"
*************************************************************************************/
double powerFunction(double x, double y){
   double a;
   a=pow(x, y);
   return a;
   
}

/*************************************************************************************
*This is my math function to get summation of the first part of Po.
*************************************************************************************/
double summationFunc(int upperLimit, int lambda, int mu){
   int i;
   double l=(double)lambda;
   double m=(double)mu; 
   double sum=0;
   double ldivM=(l/m);
   
   //summation from 0 to upperlimit (M-1)
   for(i=0; i<=upperLimit; i++){
      sum+=(1/(factorial(i)))*powerFunction(ldivM,(double)i);
      
   }
   return sum;
   
}

/*************************************************************************************
*This is my percent idle time function to get Po
*************************************************************************************/
double percentIdleTime(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   int bigM2= bigM-1;
   double calculatePo;
   double ldivM = (l/m);
   double power = powerFunction(ldivM, bigM);
   double summation = summationFunc(bigM2, l, m);
   //summation + the second part of the Po fraction
   calculatePo = summation + (((1/(factorial(bigM)))*(power))*((bigM*m)/(bigM*m-l)));
   
   //returning the fraction result of the the button part of Po over 1
   return (1.0/calculatePo);

}

/*************************************************************************************
*This is my function to get the average number of people in the system (L)
*************************************************************************************/
double avgNumOfPeopleInSystem(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double ldivM = (l/m);
   double power = (powerFunction(ldivM, bigM));
   double calculateBigL = 0;
   double Po=percentIdleTime((int)l, (int)m, bigM);
   //calculatin L using Po to get it
   calculateBigL = ((l*m*(powerFunction(ldivM, bigM)))/((factorial(bigM-1))*(pow((bigM*m-l), 2)))) * Po + (l/m); 
   
   return calculateBigL;
   
}

/*************************************************************************************
*This is my function to get average time a customer spends in the system (W)
*************************************************************************************/
double avgTimeCustomerSpendsInSystem(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double bigL=avgNumOfPeopleInSystem((int)l, (int)m, bigM);
   double calculateBigW;
   //calculating W using Po and L to get it
   calculateBigW = (bigL/l);
   
   return calculateBigW;
   
}

/*************************************************************************************
*This is my function to get average number of people in the queue (Lq)
*************************************************************************************/
double avgNumOfCustomersInQueue(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double bigL=avgNumOfPeopleInSystem((int)l, (int)m, bigM); //getting L by calling the function
   double calculateLq;
   
   //calculating Lq using L
   calculateLq = bigL-(l/m);
   
   return calculateLq;
   
}

/****************************************************************************************
*This is my function to get the average time a customer spends waiting in the queue (Wq)
****************************************************************************************/
double avgTimeCustomerSpendsWaitingInQueue(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double getLq;
   //getting Lq
   getLq = avgNumOfCustomersInQueue((int)l, (int)m, bigM);
   double calculateWq = getLq/l;//calculating Wq using Lq
   
   return calculateWq;
   
}

/*************************************************************************************
*This is my function to get the utilization factor for the system (rho)
*************************************************************************************/
double utilizationFactorForSystem(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double rho;
   rho = l/((double)bigM*m);
   
   return rho;
   
}

/******************************************************************************************************
*This is my function to compute arrival and service time intervals with avg being either lambda or mu
******************************************************************************************************/
double getNextRandomInterval(double avg){
   double randomNum = rand();
   double f = (randomNum / 1.0);
   double intervalTime = (-1*(1.0/avg)*log(f)); //natural logarithm of f

   return intervalTime;
}