/*   Name: Zach Pannell
*    Class: COP3014
*    Time: 8:00-9:15
*
*/
#include <stdio.h>
#include <stdlib.h>
#define size 20

int main()
{
    int nums[size];
    int i, j, k, temp;
    int count=0, count2=0;


    printf("Enter up to 20 non-negative integers (Enter -1 to stop): \n");
    for(i=0;i<20;i++)
    {
        scanf("%i", &nums[i]);
        count++;
        if(nums[i]==-1)
        {
            nums[i]=nums[i-1];
            count--;
            i=20;
        }
        else if(nums[i]<-1)
        {
            nums[i]=nums[i-1];
            count--;
        }
    }
    printf("\nThe First list of numbers: \n");
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
    for (i=0;i<count;i++)
        printf("%i\n", nums[i]);

    printf("The Final list (Ascending order, No duplicates): \n");
    for(j=0;j<count-1;j++)
    {
       for(i=0;i<count-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
    }
    for(i=0;i<count;i++)
    {
        printf("%i\n",nums[i]);
    }
 return 0;
}





