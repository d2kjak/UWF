#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <math.h>

double factorial(int);
double summationFunc(int, int, int);
double percentIdleTime(int, int, int);
double avgNumOfPeopleInSystem(int, int, int);
double avgTimeCustomerSpendsInSystem(int, int, int);
double avgNumOfCustomersInQueue(int, int, int);
double avgTimeCustomerSpendsWaitingInQueue(int, int, int);
double utilizationFactorForSystem(int, int, int);
/*
*Project 2 Programmed by Delikarl Jean-baptiste
*
*/
int main(int argc, char** argv) {
   
   int n;
   int l=2;
   int m=3;
   int bigM=2;
   double getPo = percentIdleTime(l, m, bigM);
   double getL = avgNumOfPeopleInSystem(l, m, bigM);
   double getW = avgTimeCustomerSpendsInSystem(l, m, bigM);
   double getLq = avgNumOfCustomersInQueue(l, m, bigM);
   double getWq = avgTimeCustomerSpendsWaitingInQueue(l, m, bigM);
   printf("\nPo = %.4lf ", getPo);
   printf("\nL = %.4lf ", getL);
   printf("\nW = %.4lf ", getW);
   printf("\nLq = %.4lf ", getLq);
   printf("\nWq = %.4lf \n",getWq);
   //n=factorial(5);
   //printf("5! is: %d", n);
   //m=summationFunc(0, 3);
   //printf("summation func of 3 is: %.2lf", m);
   
      
   return (EXIT_SUCCESS);
}

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


double powerFunction(double x, double y){
   double a;
   a=pow(x, y);
   //fprintf(stderr,"in PF: pf is %.2lf, x is: %.2lf, y is: %.2lf \n", a, x, y);
   return a;
   
}

double summationFunc(int upperLimit, int lambda, int mu){
   int i;
   double l=(double)lambda;
   double m=(double)mu; 
   double sum=0;
   double ldivM=(l/m);
   //fprintf(stderr, "\nin summation function before loop, ldivM is: %.2lf\n", ldivM);
   
   for(i=0; i<=upperLimit; i++){
      sum+=(1/(factorial(i)))*powerFunction(ldivM,(double)i);
      
      //fprintf(stderr,"in summation function, pf is: %.2lf\n",sum);
   }
   fprintf(stderr,"in summation function, pf is: %.2lf\n",sum);
   return sum;
   
}

double percentIdleTime(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   int bigM2= bigM-1;
   double calculatePo;
   double ldivM = (l/m);
   double power = powerFunction(ldivM, bigM);
   double summation = summationFunc(bigM2, l, m);
   calculatePo = summation + (((1/(factorial(bigM)))*(power))*((bigM*m)/(bigM*m-l)));
   printf("\nin Po, factorial bigM is: %.2lf - yo - ", factorial(bigM));
   printf("\nin Po, calculatePo is: %.2lf \n", calculatePo);
   
   return (1.0/calculatePo);

}

double avgNumOfPeopleInSystem(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double ldivM = (l/m);
   double power = (powerFunction(ldivM, bigM));
   //printf("\nin L, power is: %.2lf - ayy - ", power);
   double calculateBigL = 0;
   double Po=percentIdleTime((int)l, (int)m, bigM);
   calculateBigL = ((l*m*(powerFunction(ldivM, bigM)))/((factorial(bigM-1))*(pow((bigM*m-l), 2)))) * Po + (l/m); 
   //printf("\nin L, calculateBigL is: %.2lf - aww - ", calculateBigL);
   
   return calculateBigL;
   
}


double avgTimeCustomerSpendsInSystem(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double bigL=avgNumOfPeopleInSystem((int)l, (int)m, bigM);
   double calculateBigW;
   calculateBigW = (bigL/l);
   
   return calculateBigW;
   
}

double avgNumOfCustomersInQueue(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double bigL=avgNumOfPeopleInSystem((int)l, (int)m, bigM);
   printf("in avgNumOfCustomersInQueue(Lq), bigL is: %.2lf", bigL);
   double calculateLq;
   
   calculateLq = bigL-(l/m);
   
   return calculateLq;
   
}

double avgTimeCustomerSpendsWaitingInQueue(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double getLq;
   getLq = avgNumOfCustomersInQueue((int)l, (int)m, bigM);
   double calculateWq = getLq/l;
   
   return calculateWq;
   
}

double utilizationFactorForSystem(int lambda, int mu, int numOfServiceChannels){
   double l=(double)lambda;
   double m=(double)mu;
   int bigM=numOfServiceChannels;
   double rho;
   rho = l/((double)bigM*m);
   
   return rho;
   
}