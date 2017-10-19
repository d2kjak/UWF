#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*
*Delikarl Jean-Baptiste
*Project 5
*COP3014
*/


int findString(char *, char *);
void removeString(char *, int, int);
void insertString(char *, char *, int);

int main(){
    //find
    printf("Found hat at %i\n", findString("chatterbox", "hat"));
    printf("Found att at %i\n", findString("chatterbox", "att"));
    printf("Found box at %i\n", findString("chatterbox", "box"));
    printf("Found boxx at %i\n", findString("chatterbox", "boxx"));

    //remove
    char str3[20] = "chatterbox";
    removeString(str3, 9, 1);
    printf("\nAfter remove 1 = %s\n", str3);

    char str4[20] = "chatterbox";
    removeString(str4, 4, 5);
    printf("After remove 2 = %s\n", str4);

    char str5[20] = "chatterbox";
    removeString(str5, 0, 7);
    printf("After remove 3 = %s\n", str5);

    //insert
    char str8[20] = "the wrong son";

    insertString(str8, "per", 14);
    printf("\nAfter insert 1  = %s\n", str8);

    insertString(str8, "per", 10 );
    printf("After insert 2  = %s\n", str8);

    insertString(str8, "You are ", 0);
    printf("After insert 3  = %s\n\n", str8);
    return 0;

}

int findString(char *first, char *second){
   int count=0, count2=0, start;
   while(first[count] != '\0'){
      start=count;
      while(first[count]==second[count2]){
         count++;
         count2++;
      }
      if(first[count] != second[count2] && second[count2]!='\0'){
         count-=count2;
         count2=0;
      }
      if(second[count2]=='\0')
         return start;
      count++;
   }
   return -1;

}


void removeString(char *s, int i, int j){

   char *p = s+i;
   do{
      *p = *(p+j);
      if(*p != '\0'){
         p++;
      }
   }
   while(*p != '\0');

}
/*

void insertString(char *first, char *second, int i){

   int count=0, count2=i;
   char temp1, temp2;

   //, first, second;
   while(second[count] != '\0')
   {

      temp1=second[count];
      count++;
      //while(first[count2]!='\0'){
         temp2=first[count2];

         first[count2]=temp1;
         count2++;

      //}
   }

}
*/

void insertString(char *first,char *second, int i){

   int temp2=strlen(second);
   char *temp=first + i;


   while (*second != '\0'){
      *(temp+temp2) = *temp;
      *temp = *second;
      *temp++;
      *second++;

    }
 }
