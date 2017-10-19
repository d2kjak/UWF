#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "LCS.h"



/******************************************************************************************************************
*This is my main to call all my other functions to computer Longest Common subsequence
*******************************************************************************************************************/
int main()
{
    readSequences();
    computelcs(xArr, yArr);
    display_LCS();
    printf("\n");
    readMultipleSequences();
    
    return 0;
}


/******************************************************************************************************************
*This my max function that will return the greater of two numbers pasted into it
*******************************************************************************************************************/
int max(int num1, int num2){
    if(num1 > num2){
        return num1;
    }
    else{
        return num2;
    }
}

/******************************************************************************************************************
*This is my display function to show the final matrix after computing the LCS
*******************************************************************************************************************/
void  display_LCS_MATRIX()
{
    for(i=0; i<x; i++){
        for(j=0; j<y;j++){
            printf("%d",cArr[i][j]);
        }
        printf("\n");
    }
}

/******************************************************************************************************************
*My function to get my x-array and y-array to computer the longest common subsequence
*******************************************************************************************************************/
void computelcs(char* tempX, char* tempY){
    
    cArr = (int**)malloc((x+1)* sizeof(int*)); //mallocing for my integer 2D "c" array
    for(i=0; i<=x; i++){
        cArr[i] = (int*)malloc((y+1)* sizeof(int));
    }
    
    //computing my matrix
    for(i=0;i<x; i++){
        cArr[i][0]=0;
    }
    for(j=0; j<y;j++){
        cArr[0][j]=0;
    }
    for(i=1; i<=x; i++){
        for(j=1; j<=y;j++){
            if(tempX[i-1]==tempY[j-1]){
                cArr[i][j] = cArr[i-1][j-1]+1;
            }
            else{
                if(cArr[i-1][j] >= cArr[i][j-1]){
                    cArr[i][j] = cArr[i-1][j];
                }
                else{
                    cArr[i][j] = cArr[i][j-1];
                }
            }
        }
    }
    
    display_LCS_MATRIX();//calling my display function after the matrix is done computing
    printf("\n");


    printf("the LCS is: ");
    printLcs(x-1,y-1);
  
    
}

/******************************************************************************************************************
*My function to display my LCS after computing
*******************************************************************************************************************/
void display_LCS()
{
    
   printf("\n"); 
   for(i=2;i<=(cArr[x][y]);i++){
      printf("%c",LCS[i]);
   }
   printf("\n");
}


/******************************************************************************************************************
*This is my print function that goes through my matrix and find the lcs dynamically
*******************************************************************************************************************/
void printLcs(int a, int b){
    //skipping zeroes, since we don't care about them  
    if(a==0 || b==0){
        return;
    }
    //printing if we find a match
    else if(xArr[a-1]==yArr[b-1]){
        printLcs(a-1, b-1);
        if(c==cArr[x][y]-1){
            c=0;
            //printf("\n");
        }
        //printf("%c", xArr[a-1]);//<- printing, BUT this gives me an extra character, i do not know why
        LCS[a-1]=xArr[a-1]; //storing to an array to show the lcs
        c++;
    }
    //else recursive
    else if(cArr[a-1][b]==cArr[a][b-1]){
        printLcs(a-1, b);
        printLcs(a, b-1);
    }
    else if(cArr[a][b-1] >= cArr[a-1][b]){
        printLcs(a, b-1);
    }
    else{
        printLcs(a-1, b);
    }
    return;
    
    
}


/******************************************************************************************************************
*This is my read function to read my twoSequence file and store values into array
*******************************************************************************************************************/
void readSequences(){
    FILE* file;
    //mallocing for both arrays
    xArr = (char*)malloc(sizeof(char)*1000);
    yArr = (char*)malloc(sizeof(char)*1000);
    file = fopen("twoSequences.txt","r");
    if(file==NULL){
        printf("Error");
        exit(1);
    }
    //read until end of file
    while(!feof(file)){
        fscanf(file, "%s", xArr);
        fscanf(file, "%s", yArr);
    }
    //getting the lengths for both arrays
    x = strlen(xArr)+1;
    y = strlen(yArr)+1;
    //printing out the size and values for both x and y arrays
    printf("size of x is %d\n", x);
    printf("size of y is %d\n", y);
    printf("x is %s\n", xArr);
    printf("y is %s\n", yArr);
    
    
}
/********************************************************************************************************************/

/******************************************************************************************************************
*This is my read function to read multiple sequence from a file to compare
*******************************************************************************************************************/
void readMultipleSequences(){

   printf("\nin reading multiple sequences");
   FILE *fp = fopen("multipleSequences.txt", "r");//my file pointer
	buf = (char*)malloc(sizeof(char)*1000);//malloc for my buffer array 
   fpos_t pos;
   fscanf(fp, "%d", &numOfStrings);//scanning first the max number of strings to follow
   fgetpos(fp, &pos);//setting my file pointer position RIGHT AFTER i scan the max number of strings
   if(fp == NULL){
      printf("Error");
      exit(1);
   }
   while(!feof(fp)){//reading in the sequences of characters and setting it to my buffer array
      //fscanf(fp, "%c", &buf);
		fgets(buf, 1000, fp);
      printf("%s", buf);
   }
   
   fsetpos(fp, &pos);//ii'm done with my file pointer position
   printf("\nnumber of strings are: %d \n", numOfStrings);
	findMaxLcs(buf, numOfStrings);
	
   
}


/******************************************************************************************************************
*This is my read function to find the compare each element of characters to find max lcs. //note, may not work
*******************************************************************************************************************/
void findMaxLcs(char multLCS[], int max){
	printf("\nin findMax\n");
	for(i=0; i<=max; i++){
		for(j=1; j<=max; j++){
			//computelcs(multLCS[i], multLCS[j]);
		}
		printf("\n---\n");
	}
   
   
}
