/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   p1.c
 * Author: djj5
 *
 * Created on September 13, 2016, 12:54 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char **getFileName();
/*
 * 
 */
 
#define LINE_LEN 100


int main(int argc, char** argv) {

   //system("ls ./datafiles/ > inputfile.txt");
   
   char **fileName;
   fileName = getFileName();
   printf("\n meh - %s\n", fileName[3]);
   FILE *fPointer;
   fPointer = fopen(fileName[2], "r");
   char buff[LINE_LEN];
   while(fgets(buff, LINE_LEN, fPointer)){
         if(buff[strlen(buff)-1] == '\n'){
            buff[strlen(buff)-1] = '\0';
            }
         printf("\n yo -- [%s]", buff);
        
      }
   
   
   
    return (EXIT_SUCCESS);
}

char **getFileName(){
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
/*   while(!feof(filePointer)){
      character = fgetc(filePointer);
      printf("%c", character);
      if(character == '\n'){
        count++;
        printf("\n");
        }
   }
   count++;
   printf("count = %d\n", count); */
  
  /* while(!feof(filePointer)){
      fgets(buffer, LINE_LEN, filePointer);
      puts(buffer);
      character = fgetc(filePointer);
      if (character == '\n'){
         count++;
         printf("blah");
      }
   }
   printf("count = %d\n", count);
*/

/*   while(!feof(filePointer)){
      printf("{%s}\n", fscanf(filePointer("
      */
/*      while(fgets(buffer, LINE_LEN, filePointer) != NULL){
         buffer[strlen(buffer)-1] = '\0';
         printf("[%s]\n", buffer);
         count++;  
      }*/
      
      line_num = 0;
      int cnt = 0;
      char **temp;
      temp = (char **) malloc(LINE_LEN * sizeof(char *));
      int i;
      for (i = 0; i < LINE_LEN; i++) {
         temp[i] = (char *) malloc(256 * sizeof(char));
         }
      while(fgets(buffer, LINE_LEN, filePointer)){
         if(buffer[strlen(buffer)-1] == '\n'){
            buffer[strlen(buffer)-1] = '\0';
            }
            line_num++;
         strcpy(temp[line_num], buffer);
         printf("line: %d blah: [%s]\n", line_num, temp[line_num]);
         }
      
      return temp;
      
}



