#include <stdio.h>
#include <stdlib.h>

int main()
{

    double score, sum;
	 double high = 0.0;
	 double low = 100.0;
	 double totalScore = 0.0;
    int totalCount = 0;
    int Acount=0;
    int Bcount=0;
    int Ccount=0;
    int Dcount=0;
    int Fcount=0;
    char letterGrade;


    do {
	   printf("Please enter a score (negative to stop) -- ");
    scanf("%lf", &score);

	 while (score > 100) {
	 		printf("That is not a valid score. Enter another -- ");
			    //printf("Please enter a valid score\n");
   			 scanf("%lf", &score);

	 }


        if (score <=100 && score >= 89.5){
            letterGrade = 'A';
				sum = sum+4.0;
            Acount++;
        }
        else if (score <= 89.49 && score >=79.5){
                letterGrade = 'B';
					 sum=sum+3.0;
                Bcount++;
            }

        else if (score<=79.49 && score >=69.5){
                letterGrade = 'C';
					 sum=sum+2.0;
                Ccount++;
            }

        else if (score<=69.49 && score >=59.5){
                letterGrade = 'D';
					 sum=sum+1.0;
                Dcount++;
            }

        else if (score <= 59.49 && score >=0) {
                letterGrade = 'F';
                Fcount++;
            }
				if (score >= 0){
					totalScore = totalScore + score;
					totalCount++;
					if (score > high)
						high = score;
					if (score < low)
						low = score;
                  
               printf("Score = %.02lf \t Grade = %c \n", score, letterGrade);
				}

				




    }
	 while (score <= 100 && score >=0);

     printf("Number of scores \t %i\n", totalCount);
     printf("Number of A's \t \t %i\n", Acount);
     printf("Number of B's \t \t %i\n", Bcount);
     printf("Number of C's \t \t %i\n", Ccount);
     printf("Number of D's \t \t %i\n", Dcount);
     printf("Number of F's \t \t %i\n", Fcount);
	 printf("High score \t \t %.02lf \n", high);
	 printf("Low score \t \t %.02lf \n", low);
	 printf("Average score \t \t %.02lf \n", totalScore/((double)totalCount));
	 printf("Exam GPA \t \t %.02lf \n", sum/((double)totalCount));
    //printf("total A scores entered is %lf, ")
    //printf("total A scores entered is %lf, ")
    //printf("total A scores entered is %lf, ")
    //printf("total A scores entered is %lf, ")


    return 0;
}
