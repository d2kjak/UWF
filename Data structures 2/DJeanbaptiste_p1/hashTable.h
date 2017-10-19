#ifndef _hashTable_h
#define _hashTable_h

#define TABLESIZE 5003


typedef struct linkListHash List;

typedef struct hashTable hashT;


void add(hashT *, char *);
List *initializeNode(char *);
hashT *initTable();
hashT *createHashTable(char **, int, int);
int hash(char *);
int find(hashT *, char *);
void freeTable(hashT *);

#endif