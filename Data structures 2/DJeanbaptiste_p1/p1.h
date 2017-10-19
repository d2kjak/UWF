#ifndef _p1_h
#define _p1_h


#define LINE_LEN 300
#define MAX 5000


char **getFileName(int *);
char **readFile(char *);
int countWords(char *);
int fileCompare(hashT*, char *, int);
void compareAll(char **, int, int);


#endif