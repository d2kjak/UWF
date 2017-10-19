#include <stdio.h>
#include <string.h>
#include <stdlib.h>




void readSequences();
int max(int, int);
void computelcs(char*, char*);
void printLcs(int, int);
void  display_LCS_MATRIX();
void display_LCS();
char *xArr, *yArr, *lcsResult;
int a, b, c=0, d, maxx, i, j, x, y, **cArr, **lArr;
char LCS[100];


int main()
{
    readSequences();
    computelcs(xArr, yArr);
    display_LCS();
    
    return 0;
}



int max(int num1, int num2){
    if(num1 > num2){
        return num1;
    }
    else{
        return num2;
    }
}

void  display_LCS_MATRIX()
{
    for(i=0; i<x; i++){
        for(j=0; j<y;j++){
            printf("%d",cArr[i][j]);
        }
        printf("\n");
    }
}

void computelcs(char* tempX, char* tempY){
    
    cArr = (int**)malloc((x+1)* sizeof(int*));
    
    for(i=0; i<=x; i++){
        cArr[i] = (int*)malloc((y+1)* sizeof(int));
    }
    
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
    //maxx = cArr[x][y]+1;
    
    display_LCS_MATRIX();
    printf("\n");


    printf("the LCS is: ");
    printLcs(x-1,y-1);
  
    
}
void display_LCS()
{
    
   printf("\n"); 
   for(i=2;i<=(cArr[x][y]);i++){
      printf("%c",LCS[i]);
   }
   printf("\n");
}

void printLcs(int a, int b){
    
    
    
    if(a==0 || b==0){
        return;
    }
    else if(xArr[a-1]==yArr[b-1]){
        printLcs(a-1, b-1);
        if(c==cArr[x][y]-1){
            c=0;
            //printf("\n");
        }
        printf("%c", xArr[a-1]);
        LCS[a-1]=xArr[a-1];
        c++;
    }
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



void readSequences(){
    FILE* file;
    //int i;
    //int j, count = 0;
    xArr = (char*)malloc(sizeof(char)*1000);
    yArr = (char*)malloc(sizeof(char)*1000);
    file = fopen("twoSequences.txt","r");
    if(file==NULL){
        printf("Error");
        exit(1);
    }
    while(!feof(file)){
        fscanf(file, "%s", xArr);
        fscanf(file, "%s", yArr);
    }
    x = strlen(xArr)+1;
    y = strlen(yArr)+1;
    printf("size of x is %d\n", x);
    printf("size of y is %d\n", y);
    printf("x is %s\n", xArr);
    printf("y is %s\n", yArr);
    
    
}



