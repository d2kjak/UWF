#ifndef poissonDistribution
#define poissonDistribution
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

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

#endif
