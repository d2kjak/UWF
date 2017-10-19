#include <stdio.h>
#include <stdlib.h>

/*
*Delikarl Jean-Baptiste
*Project 4
*COP3014
*/

#define size 20

int funcArray(int[], int);
void printOriginal(int[], int);
int noDup(int[], int);
void sortArray(int[], int);

int main(){   
   int count = 0;
   int nums[size];
   int isDone=0;
   count = funcArray(nums, size);
   printf("numbers are:\n");
   printOriginal(nums, count);
   count = noDup(nums, count);
   printOriginal(nums, count);
   sortArray(nums, count);
   printOriginal(nums, count);
   return 0;
}
  
  int funcArray( int tempArray[], int theSize){
  int isDone=0, i=0, count=0;
  printf("enter 20 non-negative numbers\n");
  while (!isDone){
      scanf("%d", &tempArray[i]);
      
       
         if(tempArray[i] == -1 || i == theSize){
            isDone=1;
         }
         else if(tempArray[i] > -1){
         count++;
         i++;
        }
      }
      return count;
   
  }
  void printOriginal(int tempArray2[], int count){
   int i;
    for(i=0; i < count;i++){
         printf("%i\n", tempArray2[i]);
     }
  }
   int noDup(int tempArray3[], int count){
      int i, j, k;
      printf("The Second list of numbers (No duplicates): \n");
      for(i=0;i<count;i++)
      {
        for(j=i+1;j<count;)
        {
            if(tempArray3[i]== tempArray3[j])
            {
                for(k=j;k<count;k++)
                    tempArray3[k]=tempArray3[k+1];
                    count--;
            }
            else
                j++;
        }
    }
    return count;
   }
   
   void sortArray(int tempArray4[], int count){
      int i, j, k, temp;
      printf("The list of numbers after being sorted is: \n");
      for(j=0;j<count-1;j++){
         for(i=0;i<count-1;i++){
            if(tempArray4[i]>tempArray4[i+1])
            {
                temp = tempArray4[i];
                tempArray4[i] = tempArray4[i+1];
                tempArray4[i+1] = temp;
            }
        }
    }
   
   }

  