#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>

#define MAX 20


void swap(int a[], int, int);
void perm(int a[], int);
double bruteForcePerm(int tours[], int);


/*************************************************************************************
*My main function
*************************************************************************************/
int main(int argc, char** argv) {

   int i, j;
   double graph[MAX][MAX];
   int tours[MAX];
   int numOfCities;
   int numOfTours;
   int numOfGens;
   int percentOfMutations;
   
   printf("What is the number of cities to run? -- ");
   scanf("%d", &numOfCities);
   
   printf("How many individual tours are in a given generation? -- ");
   scanf("%d", &numOfTours);
   
   printf("How many generations to run? -- ");
   scanf("%d", &numOfGens);
   
   printf("What percentage of a generation should be compirsed of mutations? -- ");
   scanf("%d", &percentOfMutations);
   
   printf("\n\n");
   
   
   FILE *fPointer = fopen("cityWeights.txt", "r");
   for(i=0; i<MAX; i++){
      for(j=0; j<MAX; j++){
         fscanf(fPointer, "%lf", &graph[i][j]);
         if(i==j){
            graph[i][j]=0;
         }
      }
   }
   fclose(fPointer);
   
   //This is to test/print out all the weights i read in from the file into my 2d array (graph)
   int x, y;
   for(x=0; x<MAX; x++){
      printf("\n");
      for(y=0; y<MAX; y++){
         if(x!=y){
            printf("\n");
            printf("%.5lf", graph[x][y]);
         }
      }
   }
   

   return (EXIT_SUCCESS);
}

/*************************************************************************************
*this is my swap function
*************************************************************************************/

void swap(int a[], int x, int y){
   int temp;
   temp = a[x];
   a[x] = a[y];
   a[y] = temp;
}



/*************************************************************************************
*this is my brute force algorithm function. It is not complete
*************************************************************************************/

double bruteForcePerm(int tours[], int n){

   
   
   int shortestPaths = 0;
   
   
   

}

