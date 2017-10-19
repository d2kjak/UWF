#ifndef _LCS
#define _LCS



/******************************************************************************************************************
*My h file for my LCS main class
*******************************************************************************************************************/
void readSequences();

void readMultipleSequences();

int max(int, int);

void computelcs(char*, char*);

void printLcs(int, int);

void  display_LCS_MATRIX();

void display_LCS();

void findMaxLcs(char[], int);

char *xArr, *yArr, *lcsResult, *buf;

int a, b, c=0, d, maxx, i, j, x, y, **cArr, **lArr;

int numOfStrings;

char LCS[100];

//char buf[256];




#endif