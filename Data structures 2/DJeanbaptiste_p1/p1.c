#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include "linkedList.h"
#include "hashTable.h"
#include "hashTable.c"

char **getFileName(int *);
char **readFile(char *);
int countWords(char *);
int fileCompare(hashT*, char *, int);
int compareAll(char **, int, int);

/*
 * 
 */
 
#define LINE_LEN 300
#define MAX 10000

/*
*Project 1 Programmed by Delikarl Jean-baptiste
*
*/
//This is my main file that gets the name of the files and open to compare
int main(int argc, char** argv) {

   system("ls ./datafiles/ > inputfile.txt");
   int count = 0;
   int input;
   char **fileName;
   fileName = getFileName(&count);
   readFile(fileName[2]);
   printf("\nfileName is: %s\n", fileName[0]);
   
   printf("\nWhat is the number of words to analyze (2-10)? -- ");
   scanf("%d", &input);
   while(input <2 || input>10){
      printf("Wrong input: What is the number of words to analyze (2-10)? -- ");
      scanf("%d", &input);
   }
   
   hashT *tempHashTable = createHashTable(fileName, count, input);
   //fileCompare(tempHashTable, fileName, input);
   compareAll(fileName, count, input);

   
      
   return (EXIT_SUCCESS);
}



//this reads in the file that you're passing, and keeps track of the amount of words (count) in the file being read
char **readFile(char *fileName){
   FILE *fPointer;
   int count;
   char buff[MAX];
   char tempCharacter = 0;
   char *token;
   char **stringArray = (char **) malloc(sizeof(char *) * MAX);
   for(count = 0; count < MAX; count++)
   {
      stringArray[count] = (char *)malloc(sizeof(char) * 30);
      bzero(stringArray[count], sizeof(char) * 30); 
   } 
   fPointer = fopen(fileName, "r");
   if(fPointer==NULL){
      fprintf(stderr, "cannot open");
      exit(1);
   }
   count = 0;
   while(!feof(fPointer))
   {
      tempCharacter = fgetc(fPointer);
      if(tempCharacter > 0)
      {
         buff[count] = tempCharacter;
         (count)++;
      }
   }
   buff[count] = '\0';
   count = 0;
   
   token = strtok(buff, " \n\t.,!\"");
   while(token != NULL)
   {
      strcpy(stringArray[count], token);
      count++;
      token = strtok(NULL, " \n\t.,?!\"");
   }
     
   return stringArray;

}


//This function counts the amount of words in a file passed into it and returns an integer
int countWords(char *fileName2){
   FILE *fileOpened;
   int cnt=1;
   char str;
   fileOpened = fopen(fileName2, "r");
   
   while(!feof(fileOpened))
   {
      str = fgetc(fileOpened);
      if(str == ' ' || str == '\n'){
         cnt++;
      }
   }
   return cnt;
}


//this function takes in a file and the amount of words (&input) you want to compare and it looks for a comparison from the hash table
int fileCompare(hashT* hashTable, char *fileName1, int input){
   FILE *fName1;
   fName1 = fopen(fileName1, "r");
   int wordCount;
   int phraseCount=0;
   int num, i, j;
   wordCount = countWords(fileName1);

   char** strings;
   char *temp;
   char words[LINE_LEN];
   
   
   
   strings = readFile(fileName1);
   
   //this is my loop to find the word PHRASES and put the into an array
   for(i=0; i<wordCount-input+1; i++){
      int count = 0;

      for (count = 0; count < LINE_LEN; count++)
      {
         words[count] = '\0';
      }  
      for(j=0; j<input; j++){
         strcat(words, strings[i+j]);
      }
      phraseCount += find(hashTable, words);  //finding the matched word phrases
   }
   printf("fc: %d \n", phraseCount);
   return phraseCount;
  
}


//this function  opens another file to compare to other all other files
int compareAll(char **fileNames, int numOfFile, int input){
   int count=0;
   char **strArray;
   hashT* hashTable;
   int i, j;
   int numWords;
   
   
   for(i=0; i<numOfFile-1; i++){
      numWords = countWords(fileNames[i]);
      strArray = readFile(fileNames[i]);
      hashTable = createHashTable(strArray, numWords, input);
      for(j=i+1; j<numOfFile; j++){
         count += fileCompare(hashTable, fileNames[i], input);
         printf("%d",count);
      }
      
   }
   //freeing the memories that i allocated
   freeTable(hashTable);
   free(strArray);
   return count;
   
}


//this function gets the file name from the input file that shall contain the other file name being used in this program.
//it was working before but it can only hold the file name from the last of it's index
char **getFileName(int *counter){
   FILE *filePointer;
   filePointer = fopen("inputfile.txt", "r");
   int count=0;
   char buffer[MAX];
   char character = 1;
   char line_num;

   if (filePointer == NULL){
      printf("error");
      exit(1);
   }
   
   
   line_num = 0;
   int cnt = 0;
   int i;
   char **temp;
   temp = (char **) malloc(LINE_LEN * sizeof(char *));
   
   while(!feof(filePointer)){
      fscanf(filePointer, "%s", buffer);
      for (i = 0; i < LINE_LEN; i++) {
         strtok(temp[i], " \n\t,!\"");
         temp[i] = (char *) malloc(256 * sizeof(char));
      }
      strcpy(temp[line_num], buffer);
         if(buffer[strlen(buffer)-1] == '\n'|| buffer[strlen(buffer)-1] == ' '){
            buffer[strlen(buffer)-1] = '\0';
            }
         line_num++;

   }
   *counter = line_num; //keeps count of file
   return temp;
      
}



