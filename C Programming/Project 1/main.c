#include <stdio.h>
#include <stdlib.h>

/*
*Delikarl Jean-Baptiste
*C Programming Project 1
*COP3014
*/

int main()
{
    char letter;
    int x;
    int y;
    double a, b;
    //int avg1 = ((x+y)/2);
    //double avg2 = ((double)x+(double)y/(2.0));

    printf("Please enter a character (UPPER CASE)\n");
    scanf("%c", &letter);
    printf("Please enter an integer value\n");
    scanf("%i", &x);
    printf("Please enter another integer value\n");
    scanf("%i", &y);
    printf("Please enter a floating point number\n");
    scanf("%lf", &a);
    printf("Please enter another floating point number\n");
    scanf("%lf", &b);
    printf("Character is \t \t \t \t: %c\n", letter);
    //printf("your integers are: %i, %i\n", x, y);
    printf("ASCII code is \t \t \t \t\: %i\n", letter);
    printf("Character + 32 is \t \t \t: %c\n", letter+32);
    printf("Integers are \t \t \t \t: %i, %i\n", x, y);
    printf("Average (as int) is \t \t \t: %i\n", (x+y)/2);
    printf("Average (as double) is \t \t \t: %f\n\n", (x+y)/(2.0));
	 //printf("Average (as double) is \t \t \t: %lf\n\n", ((double)x+(double)y)/(2));
	 printf("Reals are \t \t \t \t: %lf, %lf\n", a, b);
	 printf("Average (as int) is \t \t \t: %i\n", ((int)a + (int)b)/2);
	 printf("Average (as real) is \t \t \t: %lf\n", (a+b)/2.0);
	 printf("Average of all is \t \t \t: %.02lf\n", ((double)x+(double)y+a+b)/4.0);

    return 0;
}
