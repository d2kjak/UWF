#include <stdio.h>
#include <stdlib.h>

/*
*Delikarl Jean-Baptiste
*Project 3
*COP3014
*/


int main()
{
   int i = 0, j, k, temp, count = 0, size=20;
   int nums[size];
   int isDone=0;
    //int noDup[size];
   printf("enter 20 non-negative numbers\n");
  // for (i=0; i<size;i++){
  
  
   while (!isDone){
      scanf("%d", &nums[i]);
      
       
         if(nums[i] == -1 || i == size){
            isDone=1;
         }
         else if(nums[i] > -1){
         count++;
         i++;
        }
      }
   
           
    printf("numbers are:\n");
    for(i=0; i < count;i++){
         printf("%i\n", nums[i]);
     }
     
     
     
   /* for(i=0;i<size;i++){
        printf("%i\n", nums[i]);
        if (nums[i+1] == -1){
            break;
        }
        
    }*/
    
      printf("\nnew array (without duplicate) is :\n");
    for(i=0;i<count;i++)
    {
        printf("%i\n", nums[i]);
    }
    printf("The Second list of numbers (No duplicates): \n");
    for(i=0;i<count;i++)
    {
        for(j=i+1;j<count;)
        {
            if(nums[i]== nums[j])
            {
                for(k=j;k<count;k++)
                    nums[k]=nums[k+1];
                    count--;
            }
            else
                j++;
        }
    }
    
      for(i=0; i<count; i++){
         printf("%i\n", nums[i]);
      }
      
      printf("The list of numbers after being sorted is: \n");
      for(j=0;j<count-1;j++){
         for(i=0;i<count-1;i++){
            if(nums[i]>nums[i+1])
            {
                temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
    }
      for(i=0;i<count;i++){
        printf("%i\n",nums[i]);
    }
   
   
      return 0;
   }
