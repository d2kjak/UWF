#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include "linkedList.h"
#include "hashTable.h"

char **getFileName(int *);
char **readFile(char *);
int countWords(char *);
int fileCompare(hashT*, char *, int);
void compareAll(char **, int, int);

/*
 * 
 */
 
#define LINE_LEN 300
#define MAX 5000


int main(int argc, char** argv) {

   //system("ls ./datafiles/ > inputfile.txt");
   int count = 0;
   int input;
   char **fileName;
   fileName = getFileName(&count);
   //printf("# of files = %d\n", count);
   //readFile(fileName[2]);
   
   printf("\nWhat is the number of words to analyze (2-10)? -- ");
   scanf("%d", &input);
   while(input <2 || input>10){
      printf("Wrong input: What is the number of words to analyze (2-10)? -- ");
      scanf("%d", &input);
   }
  // hashT *tempHashTable = createHashT
   //compareAll(fileName,count,input)
  // fileCompare(fileName[2], input);
   int numWords;
   
   numWords = countWords(fileName[2]);
   //printf("word count = <%d>\n", numWords);
   
   
      
    return (EXIT_SUCCESS);
}



//this reads in the file that you're passing, and keeps track of the amount of words (count) in the file being read
char **readFile(char *fileName){
   FILE *fPointer;
   int count = 0;
   char buff[MAX];
   char tempCharacter = 0;
    char *token;
   char **stringArray = (char **) malloc(sizeof(char *) * MAX);
   for(count = 0; count < MAX; count++)
   {
      stringArray[count] = (char *)malloc(sizeof(char) * 30);
      //bzero(stringArray[count], sizeof(char) * 30); 
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
   printf("ayy[%s]\n", token);
   while(token != NULL)
   {
      printf(" man[%s]\n", token);
      strcpy(stringArray[count], token);
      count++;
      token = strtok(NULL, " \n\t.,!\"");
   }
     
    return stringArray;

}



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

int fileCompare(hashT* hashTable, char *fileName1, int input){
   FILE *fName1;
   int wordCount;
   int phraseCount=0;
   fName1 = fopen(fileName1, "r");
   int num, i, j;
   wordCount = countWords(fileName1);

   char** strings;
   char *token;
   
   char *temp;
   //char **words = (char *)  malloc(50 * sizeof(char));
   char words[LINE_LEN];
   
   strings = readFile(fileName1);
      for(i=0; i<wordCount-input+1; i++){
        int count = 0;
          for (count = 0; count < LINE_LEN; count++)
         {
             words[count] = '\0';
         }
         /*if(*words == 0){
            strcpy(*words, strings[i+j]); //emptying the string
            }*/
         for(j=0; j<input; j++){
            strcat(words, strings[i+j]);
         }
        //This is where you find(words) printf("i = %d word = [%s]\n", i, words);
        phraseCount += find(hashTable, words);
      }
   //printf("fc: %s \n", words);
      //for(i=0; i<)
   return phraseCount;
  
}

void compareAll(char **fileNames, int numOfFile, int input){
   int count=0;
   char **strArray;
   hashT* hashTable;
   int i, j;
   int numWords;
   
   
   for(i=0; i<numOfFile-1; i++){
      numWords = countWords(fileNames[i]);
      strArray = readFile(fileNames[i]);
      //creatHashTable(char **stringArray, int arrayCount, int phraseSize)
      hashTable = createHashTable(strArray, numWords, input);
      for(j=i+1; j<numOfFile; j++){
         count = fileCompare(hashTable, fileNames[i], input);
         printf("%d",count);
      }
      
   }
   freeTable(hashTable);
   free(strArray);
   
}


char **getFileName(int *counter){
   FILE *filePointer;
   filePointer = fopen("in.txt", "r");
   int count=0;
   char buffer[LINE_LEN];
   char character = 1;
   char line_num;

   if (filePointer == NULL){
      printf("error");
      exit(1);
   }
      
      line_num = 0;
      int cnt = 0;
      char **temp;
      temp = (char **) malloc(LINE_LEN * sizeof(char *));
      int i;
      for (i = 0; i < LINE_LEN; i++) {
         temp[i] = (char *) malloc(256 * sizeof(char));
         }
      //Taking account for null and new line characters, so it can properly count
      while(fgets(buffer, LINE_LEN, filePointer)){
         if(buffer[strlen(buffer)-1] == '\n'){
            buffer[strlen(buffer)-1] = '\0';
            }
            
         strcpy(temp[line_num], buffer);
         printf("line: %d blah: [%s]\n", line_num, temp[line_num]);
         line_num++;
         }
      //keep count of files
      *counter = line_num;
      return temp;
      
}




