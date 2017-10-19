#ifndef _BinPacking
#define _BinPacking


/******************************************************************************************************************
*My h file for my bin packing class
*******************************************************************************************************************/
double *item;
double *tempItem;
int max;
int count;

typedef struct LinkList Link;
typedef struct AdjListNode AdjList;

Link* initLink(double);

AdjList* initAdjList(double);

void readBinInfo();

void addToCurrentBin(double, AdjList*);

int nextFit(double[], int);

AdjList* addNextFit(double, AdjList*);

int firstFit(double[], int);

AdjList* addFirstFit(double, AdjList*);

int firstFitOffline(double[], int);

void printItems(double[], int);

void sort(double [], int);

void printTempItems(double[], int);



#endif