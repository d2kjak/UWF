/*
 * File:   Project7.c
 * Author: Delikarl Jean-baptiste
 *
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define sLength 30
#define SIZE 400

/*
 *
 */
int main(int argc, char* argv[]) {




FILE *in, *in2, *out;
    char buffer[sLength + 1];
    char buffer2[sLength + 1];
    char outFile[SIZE];


char string1[sLength];
    char string2[sLength];
    char string1Holder[40][30];
    char string2Holder[40][30];
    int c1 = 0, c2 = 0, count1 = 0, count2 = 0, i=0, j=0;
    int done = -1;



    char infilename[40];
    char outfilename[40];


    /*
    *trial (hard code the names .txt file)
    *
    char string1Holder[11][30] = {"Alex", "Don", "Ellen", "Jacob", "Joe", "Sue", "Tom", "0"};
    char string2Holder[11][30] = {"Alexis", "Allen", "Emma", "Jacob", "Tom", "Tommy", "Thomas", "Wesley", "Zachary", "0"};

       strncpy(string1, string1Holder[c1], 30);
    strncpy(string2, string2Holder[c2], 30);


*/

    if(argc != 4){
      printf("Error with arguments\n");
        exit(1);
    }

      if((in = fopen(argv[1], "r")) == NULL){
          fprintf(stderr, "in file error");
          exit(1);
      }
      if((in2 = fopen(argv[2], "r")) == NULL){
          fprintf(stderr, "in file error 2");
          exit(1);
      }
      if ((out = fopen(argv[3], "w")) == NULL){
         fprintf(stderr, "error with output file");
         exit(1);
      }

     /*
      while(!feof(in))
      {
      fgets(string1Holder[i], sLength, in);
      i++;
      }
      //strcpy(string1Holder[i],"0");
      //printf("%s\n", string1Holder[i]);
      while(!feof(in2))
      {
      fgets(string2Holder[j], sLength, in2);
      j++;
      }
      //strcpy(string2Holder[j],"0");
     // printf("%s\n", string2Holder[j]);

      strncpy(string1, string1Holder[c1], 30);
      strncpy(string2, string2Holder[c2], 30);

      */

      while (! feof(in) && ! feof(in2)){


            fgets(string1Holder, sLength, in);
            fgets(string2Holder, sLength, in2);
            strncpy(string1, string1Holder[c1], 30);
            strncpy(string2, string2Holder[c2], 30);




    while (string1[count1] != '\n' && string2[count2] != '\n') {
        while (string1[count1] != '\0' && string2[count2] != '\0' && done < 0) {
            if (string1[count1] == string2[count2]) {
                count1++;
                count2++;
            }

            else if (string1[count1] < string2[count2]) {
                done = 1;
                //done = 1 for string1 goes first

            } else {
                done = 2;
                //done = 2 for string2 goes first
            }

        }
        if (done == 1) {
            c1++;
//            printf("[%s]\n", string1);
            fputs(string1, out);
            strncpy(string1, string1Holder[c1], 30);

            //fputs(string1, out);
            //fgets(string1, sLength, in);

            //strncpy(string1, inFile, 30);
            //strcpy(string1, inFile);
        } else if (done == 2) {
            c2++;
            fputs(string2, out);

            //printf("[%s]\n", string2);
            strncpy(string2, string2Holder[c2], 30);
            //fputs(string2, out);
            //fgets(string2, sLength, in2);

            //strncpy(string2, inFile2, 30);
            //strcpy(string2, inFile2);
        } else {
            if (string1[count1] == '\0'|| string1[count1] == '\n') {
                c1++;
                //printf("[%s]\n", string1);
                fputs(string1, out);
                strncpy(string1, string1Holder[c1], 30);

                //fputs(string1, out);
            fgets(string1, sLength, in);
            } else {
                c2++;
//                printf("[%s]\n", string2);
               fputs(string2, out);
                strncpy(string2, string1Holder[c2], 30);

                //fputs(string2, out);
                //fgets(string2, sLength, in2);
            }
        }
        //printf("c1 = %d c2 = %d\n", c1, c2);
        done = -1;
        count1 = 0;
        count2 = 0;

    }

    //while(!feof(file1)

   /*
    while(!feof(in))
    {
        //printf("[%s]\n", string1);
	printf(" - %s", buffer);
        c1++;

	fputs(buffer, out);
	fgets(buffer, sLength, in);
    }

    while(!feof(in2))
    {
        //printf("[%s]\n", string2);
        printf(" - %s", buffer2);
        c2++;

	fputs(buffer, out);
	fgets(buffer, sLength, in);
    }
*/

    while(string1[count1] != '\0')
    {
        printf("[%s]\n", string1);
         fputs(string1, out);
        c1++;
        strcpy(string1, string1Holder[c1]);

    }

    while(string2[count2] != '\0')
    {
        printf("[%s]\n", string2);
         fputs(string2, out);
        c2++;
        strcpy(string2, string2Holder[c2]);

    }

        /*
    while (strcmp(string1Holder[c1],"0") != 0) {
        strncpy(string1, string1Holder[c1], 30);
        printf("[%s]\n", string1);
        c1++;                                                                        \
    }                                                                           //    > trial printing

    while (strcmp(string2Holder[c2],"0") != 0) {
        strncpy(string2, string2Holder[c2], 30);
        printf("[%s]\n", string2);
        c2++;
    }
*/
}

	fclose(in);
        fclose(in2);
        fclose(out);



    return (EXIT_SUCCESS);

}

